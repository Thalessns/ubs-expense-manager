package dev.java21.UbsExpenseManager.dtos.funcionario;

import java.util.UUID;

public record FuncionarioRequest(
        String nome,
        String email,
        String cargo,
        UUID departamentoID,
        UUID gestorId
) {
}
