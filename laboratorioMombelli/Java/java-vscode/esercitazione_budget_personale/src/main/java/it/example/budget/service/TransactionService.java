package it.example.budget.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import it.example.budget.dto.DashboardResponse;
import it.example.budget.dto.TransactionRequest;
import it.example.budget.entity.Transaction;
import it.example.budget.entity.TransactionType;
import it.example.budget.entity.User;
import it.example.budget.exception.ResourceNotFoundException;
import it.example.budget.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private static final DateTimeFormatter MONTH_FMT = DateTimeFormatter.ofPattern("yyyy-MM");

    private final TransactionRepository transactionRepository;
    private final UserService userService;
    private final FileStorageService fileStorageService;

    @Transactional(readOnly = true)
    public List<Transaction> listUserTransactions() {
        return transactionRepository.findByUserOrderByDateDesc(userService.getCurrentUser());
    }

    @Transactional(readOnly = true)
    public Transaction getOwnedTransaction(Long id) {
        User user = userService.getCurrentUser();
        Transaction t = transactionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transazione non trovata: " + id));
        if (!t.getUser().getId().equals(user.getId())) {
            throw new ResourceNotFoundException("Transazione non trovata: " + id);
        }
        return t;
    }

    @Transactional
    public Transaction create(TransactionRequest request, MultipartFile receipt) {
        User user = userService.getCurrentUser();
        Transaction t = Transaction.builder()
                .description(request.getDescription())
                .date(request.getDate())
                .amount(request.getAmount())
                .type(request.getType())
                .category(request.getCategory())
                .receipt(fileStorageService.store(receipt))
                .user(user)
                .build();
        return transactionRepository.save(t);
    }

    @Transactional
    public Transaction update(Long id, TransactionRequest request, MultipartFile receipt) {
        Transaction t = getOwnedTransaction(id);
        t.setDescription(request.getDescription());
        t.setDate(request.getDate());
        t.setAmount(request.getAmount());
        t.setType(request.getType());
        t.setCategory(request.getCategory());
        String stored = fileStorageService.store(receipt);
        if (stored != null) {
            t.setReceipt(stored);
        }
        return transactionRepository.save(t);
    }

    @Transactional
    public void delete(Long id) {
        Transaction t = getOwnedTransaction(id);
        transactionRepository.delete(t);
    }

    @Transactional(readOnly = true)
    public List<Transaction> searchByCategory(String category) {
        return transactionRepository.findByUserAndCategory(userService.getCurrentUser(), category);
    }

    @Transactional(readOnly = true)
    public List<Transaction> searchByDate(LocalDate start, LocalDate end) {
        return transactionRepository.findByUserAndDateBetween(userService.getCurrentUser(), start, end);
    }

    @Transactional(readOnly = true)
    public DashboardResponse buildDashboard() {
        User user = userService.getCurrentUser();
        List<Transaction> transactions = transactionRepository.findByUser(user);

        BigDecimal totalIncome = BigDecimal.ZERO;
        BigDecimal totalExpense = BigDecimal.ZERO;
        Map<String, BigDecimal> expensesByCategory = new LinkedHashMap<>();
        Map<String, BigDecimal> monthlyBalances = new TreeMap<>();

        String currentMonth = LocalDate.now().format(MONTH_FMT);
        BigDecimal monthlyBalance = BigDecimal.ZERO;

        for (Transaction t : transactions) {
            BigDecimal amount = t.getAmount();
            String month = t.getDate().format(MONTH_FMT);
            BigDecimal signed;

            if (t.getType() == TransactionType.ENTRATA) {
                totalIncome = totalIncome.add(amount);
                signed = amount;
            } else {
                totalExpense = totalExpense.add(amount);
                signed = amount.negate();
                expensesByCategory.merge(t.getCategory(), amount, BigDecimal::add);
            }

            monthlyBalances.merge(month, signed, BigDecimal::add);
            if (month.equals(currentMonth)) {
                monthlyBalance = monthlyBalance.add(signed);
            }
        }

        return DashboardResponse.builder()
                .totalIncome(totalIncome)
                .totalExpense(totalExpense)
                .totalBalance(totalIncome.subtract(totalExpense))
                .monthlyBalance(monthlyBalance)
                .expensesByCategory(expensesByCategory)
                .monthlyBalances(monthlyBalances)
                .build();
    }
}
