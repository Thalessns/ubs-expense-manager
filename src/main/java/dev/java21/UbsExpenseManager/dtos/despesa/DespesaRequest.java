package dev.java21.UbsExpenseManager.dtos.despesa;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record DespesaRequest(
        @NotNull
        UUID funcionarioId,
        @NotNull
        @Pattern(regexp = "Viagem|Refeicao|Transporte|Outros")
        String categoria,
        @DecimalMin("0.01")
        BigDecimal valor,
        @NotNull
        @Pattern(regexp = "BRL|USD|EUR")
        String moeda,
        @NotNull
        @Size(min = 0, max = 100)
        String descricao,
        @NotNull
        LocalDateTime data
) {
}
