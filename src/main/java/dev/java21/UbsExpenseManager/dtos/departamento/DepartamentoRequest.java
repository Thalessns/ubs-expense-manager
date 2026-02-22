package dev.java21.UbsExpenseManager.dtos.departamento;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record DepartamentoRequest(
        @NotEmpty
        @Size(min = 3, max = 50)
        String nome,
        @NotNull
        @DecimalMin("1")
        BigDecimal orcamentoMensal
) {
}
