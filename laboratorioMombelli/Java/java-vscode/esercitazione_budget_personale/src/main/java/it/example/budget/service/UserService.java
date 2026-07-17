package it.example.budget.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.example.budget.dto.PasswordChangeRequest;
import it.example.budget.dto.RegisterRequest;
import it.example.budget.dto.UserUpdateRequest;
import it.example.budget.entity.User;
import it.example.budget.exception.ResourceNotFoundException;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final it.example.budget.repository.UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public User register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new ValidationException("Email già registrata");
        }
        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .financialGoal(request.getFinancialGoal())
                .build();
        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public User getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !auth.isAuthenticated()) {
            throw new ResourceNotFoundException("Nessun utente autenticato");
        }
        String email = auth.getName();
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Utente non trovato: " + email));
    }

    @Transactional
    public User updateProfile(UserUpdateRequest request) {
        User user = getCurrentUser();
        if (!user.getEmail().equals(request.getEmail())
                && userRepository.existsByEmail(request.getEmail())) {
            throw new ValidationException("Email già in uso");
        }
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setFinancialGoal(request.getFinancialGoal());
        return userRepository.save(user);
    }

    @Transactional
    public void changePassword(PasswordChangeRequest request) {
        User user = getCurrentUser();
        if (!passwordEncoder.matches(request.getCurrentPassword(), user.getPassword())) {
            throw new ValidationException("La password attuale non è corretta");
        }
        if (!request.getNewPassword().equals(request.getConfirmPassword())) {
            throw new ValidationException("Le password non coincidono");
        }
        user.setPassword(passwordEncoder.encode(request.getNewPassword()));
        userRepository.save(user);
    }
}
