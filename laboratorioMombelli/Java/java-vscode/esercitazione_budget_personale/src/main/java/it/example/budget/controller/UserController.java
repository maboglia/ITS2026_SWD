package it.example.budget.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.example.budget.dto.PasswordChangeRequest;
import it.example.budget.dto.UserUpdateRequest;
import it.example.budget.entity.User;
import it.example.budget.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/profile")
    public String profile(Model model) {
        populateModel(model);
        return "profile";
    }

    @PostMapping("/profile")
    public String updateProfile(@Valid @ModelAttribute("userUpdateRequest") UserUpdateRequest userUpdateRequest,
            BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("passwordChangeRequest", new PasswordChangeRequest());
            model.addAttribute("currentUser", userService.getCurrentUser());
            return "profile";
        }
        try {
            userService.updateProfile(userUpdateRequest);
            redirectAttributes.addFlashAttribute("profileSuccess", "Profilo aggiornato con successo");
        } catch (ValidationException ex) {
            redirectAttributes.addFlashAttribute("profileError", ex.getMessage());
        }
        return "redirect:/profile";
    }

    @PostMapping("/profile/password")
    public String changePassword(
            @Valid @ModelAttribute("passwordChangeRequest") PasswordChangeRequest passwordChangeRequest,
            BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("userUpdateRequest", toUpdateRequest(userService.getCurrentUser()));
            model.addAttribute("currentUser", userService.getCurrentUser());
            return "profile";
        }
        try {
            userService.changePassword(passwordChangeRequest);
            redirectAttributes.addFlashAttribute("passwordSuccess", "Password aggiornata con successo");
        } catch (ValidationException ex) {
            redirectAttributes.addFlashAttribute("passwordError", ex.getMessage());
        }
        return "redirect:/profile";
    }

    private void populateModel(Model model) {
        User user = userService.getCurrentUser();
        model.addAttribute("currentUser", user);
        if (!model.containsAttribute("userUpdateRequest")) {
            model.addAttribute("userUpdateRequest", toUpdateRequest(user));
        }
        if (!model.containsAttribute("passwordChangeRequest")) {
            model.addAttribute("passwordChangeRequest", new PasswordChangeRequest());
        }
    }

    private UserUpdateRequest toUpdateRequest(User user) {
        return new UserUpdateRequest(user.getName(), user.getEmail(), user.getFinancialGoal());
    }
}
