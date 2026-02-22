package dev.java21.UbsExpenseManager.dtos.departamento;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record DepartamentoResponse(
        UUID id,
        String nome,
        BigDecimal orcamentoMensal,
        LocalDateTime dataCriacao
) {
}
