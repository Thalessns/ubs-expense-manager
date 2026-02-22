package dev.java21.UbsExpenseManager.interfaces.departamento;

import dev.java21.UbsExpenseManager.models.Departamento;

import java.util.List;
import java.util.UUID;

public interface IDepartamentoRepository {

    public Departamento createDepartamento(Departamento departamento);
    public List<Departamento> getAllDepartamentos();
    public Departamento getDepartamentoById(UUID id);
}
