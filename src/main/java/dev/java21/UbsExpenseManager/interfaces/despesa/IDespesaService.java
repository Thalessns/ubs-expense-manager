package dev.java21.UbsExpenseManager.interfaces.despesa;

import dev.java21.UbsExpenseManager.dtos.despesa.DespesaRequest;
import dev.java21.UbsExpenseManager.dtos.despesa.DespesaResponse;
import dev.java21.UbsExpenseManager.models.Despesa;

import java.util.List;
import java.util.UUID;

public interface IDespesaService {

    public DespesaResponse createDespesa(DespesaRequest despesaRequest);
    public List<DespesaResponse> getAllDespesas();
    public DespesaResponse getDespesaById(UUID id);
    public DespesaResponse toDespesaResponse(Despesa despesa);
}
