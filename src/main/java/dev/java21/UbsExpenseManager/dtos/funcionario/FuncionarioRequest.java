package dev.java21.UbsExpenseManager.dtos.funcionario;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.*;

import java.util.UUID;

public record  FuncionarioRequest(
        @NotBlank(message = "Nome cant be blank.")
        @Size(min = 3, max = 50)
        String nome,
        @NotBlank(message = "Email cant be blank.")
        @Email
        @Size(min = 3, max = 50)
        String email,
        @NotBlank(message = "Cargo cant be blank.")
        @Size(min = 3, max = 50)
        String cargo,
        @NotNull
        UUID departamentoID,
        @Nullable
        UUID gestorId
) {
}
