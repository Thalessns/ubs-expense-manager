package dev.java21.UbsExpenseManager.dtos.funcionario;

import java.time.LocalDateTime;
import java.util.UUID;

public record FuncionarioResponse(
        UUID id,
        String nome,
        String email,
        String cargo,
        UUID departamentoId,
        UUID gestorId,
        LocalDateTime dataCriacao
) {
}
