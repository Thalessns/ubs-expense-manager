package dev.java21.UbsExpenseManager.dtos.despesa;

import dev.java21.UbsExpenseManager.enums.DespesaCategoria;
import dev.java21.UbsExpenseManager.enums.Moeda;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record DespesaRequest(
        UUID funcionarioId,
        DespesaCategoria categoria,
        BigDecimal valor,
        Moeda moeda,
        String descricao,
        LocalDateTime data
) {
}
