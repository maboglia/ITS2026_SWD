package it.example.budget.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.example.budget.dto.TransactionRequest;
import it.example.budget.entity.Transaction;
import it.example.budget.entity.TransactionType;
import it.example.budget.exception.FileStorageException;
import it.example.budget.service.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping("/")
    public String home() {
        return "redirect:/dashboard";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("dashboard", transactionService.buildDashboard());
        return "dashboard";
    }

    @GetMapping("/transactions")
    public String list(@RequestParam(required = false) String category, Model model) {
        if (category != null && !category.isBlank()) {
            model.addAttribute("transactions", transactionService.searchByCategory(category));
        } else {
            model.addAttribute("transactions", transactionService.listUserTransactions());
        }
        model.addAttribute("filterCategory", category);
        return "transactions";
    }

    @GetMapping("/transactions/new")
    public String newForm(Model model) {
        TransactionRequest request = new TransactionRequest();
        request.setType(TransactionType.USCITA);
        model.addAttribute("transactionRequest", request);
        model.addAttribute("editMode", false);
        model.addAttribute("types", TransactionType.values());
        return "transaction-form";
    }

    @PostMapping("/transactions")
    public String create(@Valid @ModelAttribute("transactionRequest") TransactionRequest transactionRequest,
            BindingResult bindingResult,
            @RequestParam(value = "receiptFile", required = false) MultipartFile receiptFile,
            Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("editMode", false);
            model.addAttribute("types", TransactionType.values());
            return "transaction-form";
        }
        try {
            transactionService.create(transactionRequest, receiptFile);
        } catch (FileStorageException ex) {
            model.addAttribute("editMode", false);
            model.addAttribute("types", TransactionType.values());
            model.addAttribute("uploadError", ex.getMessage());
            return "transaction-form";
        }
        redirectAttributes.addFlashAttribute("success", "Transazione creata con successo");
        return "redirect:/transactions";
    }

    @GetMapping("/transactions/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Transaction t = transactionService.getOwnedTransaction(id);
        TransactionRequest request = new TransactionRequest(
                t.getId(), t.getDescription(), t.getDate(), t.getAmount(), t.getType(), t.getCategory());
        model.addAttribute("transactionRequest", request);
        model.addAttribute("editMode", true);
        model.addAttribute("existingReceipt", t.getReceipt());
        model.addAttribute("types", TransactionType.values());
        return "transaction-form";
    }

    @PostMapping("/transactions/update/{id}")
    public String update(@PathVariable Long id,
            @Valid @ModelAttribute("transactionRequest") TransactionRequest transactionRequest,
            BindingResult bindingResult,
            @RequestParam(value = "receiptFile", required = false) MultipartFile receiptFile,
            Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("editMode", true);
            model.addAttribute("types", TransactionType.values());
            return "transaction-form";
        }
        try {
            transactionService.update(id, transactionRequest, receiptFile);
        } catch (FileStorageException ex) {
            model.addAttribute("editMode", true);
            model.addAttribute("types", TransactionType.values());
            model.addAttribute("uploadError", ex.getMessage());
            return "transaction-form";
        }
        redirectAttributes.addFlashAttribute("success", "Transazione aggiornata con successo");
        return "redirect:/transactions";
    }

    @PostMapping("/transactions/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        transactionService.delete(id);
        redirectAttributes.addFlashAttribute("success", "Transazione eliminata");
        return "redirect:/transactions";
    }
}
