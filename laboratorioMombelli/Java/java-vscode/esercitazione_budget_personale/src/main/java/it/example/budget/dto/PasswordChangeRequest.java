package it.example.budget.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PasswordChangeRequest {

    @NotBlank(message = "La password attuale è obbligatoria")
    private String currentPassword;

    @NotBlank(message = "La nuova password è obbligatoria")
    @Size(min = 6, max = 100, message = "La password deve avere almeno 6 caratteri")
    private String newPassword;

    @NotBlank(message = "La conferma password è obbligatoria")
    private String confirmPassword;
}
