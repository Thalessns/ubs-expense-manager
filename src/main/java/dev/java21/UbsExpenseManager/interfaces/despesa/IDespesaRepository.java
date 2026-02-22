package dev.java21.UbsExpenseManager.interfaces.despesa;

import dev.java21.UbsExpenseManager.dtos.despesa.DespesaRequest;
import dev.java21.UbsExpenseManager.models.Despesa;

import java.util.List;
import java.util.UUID;

public interface IDespesaRepository {

    public Despesa createDespesa(Despesa despesa);
    public List<Despesa> getAllDespesas();
    public Despesa getDespesaById(UUID id);
}
