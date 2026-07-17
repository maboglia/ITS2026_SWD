package it.example.budget.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.example.budget.dto.TransactionRequest;
import it.example.budget.dto.TransactionResponse;
import it.example.budget.entity.Transaction;
import it.example.budget.service.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionRestController {

    private final TransactionService transactionService;

    @GetMapping
    public ResponseEntity<List<TransactionResponse>> getAll() {
        List<TransactionResponse> list = transactionService.listUserTransactions().stream()
                .map(TransactionResponse::from)
                .toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionResponse> getOne(@PathVariable Long id) {
        Transaction t = transactionService.getOwnedTransaction(id);
        return ResponseEntity.ok(TransactionResponse.from(t));
    }

    @PostMapping
    public ResponseEntity<TransactionResponse> create(@Valid @RequestBody TransactionRequest request) {
        Transaction created = transactionService.create(request, null);
        return ResponseEntity
                .created(URI.create("/api/transactions/" + created.getId()))
                .body(TransactionResponse.from(created));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransactionResponse> update(@PathVariable Long id,
            @Valid @RequestBody TransactionRequest request) {
        Transaction updated = transactionService.update(id, request, null);
        return ResponseEntity.ok(TransactionResponse.from(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        transactionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
