package dev.java21.UbsExpenseManager.dtos.departamento;

import java.math.BigDecimal;

public record DepartamentoRequest(
        String nome,
        BigDecimal orcamentoMensal
) {
}
