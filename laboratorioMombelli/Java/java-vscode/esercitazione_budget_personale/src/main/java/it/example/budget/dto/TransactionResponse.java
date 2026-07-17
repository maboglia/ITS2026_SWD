package it.example.budget.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import it.example.budget.entity.Transaction;
import it.example.budget.entity.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionResponse {

    private Long id;
    private String description;
    private LocalDate date;
    private BigDecimal amount;
    private TransactionType type;
    private String category;
    private String receipt;
    private LocalDateTime createdAt;

    public static TransactionResponse from(Transaction t) {
        return TransactionResponse.builder()
                .id(t.getId())
                .description(t.getDescription())
                .date(t.getDate())
                .amount(t.getAmount())
                .type(t.getType())
                .category(t.getCategory())
                .receipt(t.getReceipt())
                .createdAt(t.getCreatedAt())
                .build();
    }
}
