package dev.java21.UbsExpenseManager.interfaces.departamento;

import dev.java21.UbsExpenseManager.dtos.departamento.DepartamentoRequest;
import dev.java21.UbsExpenseManager.dtos.departamento.DepartamentoResponse;
import dev.java21.UbsExpenseManager.models.Departamento;

import java.util.List;
import java.util.UUID;

public interface IDepartamentoService {

    public DepartamentoResponse createDepartamento(DepartamentoRequest departamentoRequest);
    public List<DepartamentoResponse> getAllDepartamentos();
    public DepartamentoResponse getDepartamentoById(UUID id);
    public DepartamentoResponse toDepartamentoResponse(Departamento departamento);
}
