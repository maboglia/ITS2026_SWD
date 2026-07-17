package it.example.budget.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import it.example.budget.entity.TransactionType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRequest {

    private Long id;

    @NotBlank(message = "La descrizione è obbligatoria")
    @Size(max = 255, message = "La descrizione è troppo lunga")
    private String description;

    @NotNull(message = "La data è obbligatoria")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate date;

    @NotNull(message = "L'importo è obbligatorio")
    @Positive(message = "L'importo deve essere positivo")
    private BigDecimal amount;

    @NotNull(message = "Il tipo è obbligatorio")
    private TransactionType type;

    @NotBlank(message = "La categoria è obbligatoria")
    @Size(max = 100, message = "La categoria è troppo lunga")
    private String category;
}
