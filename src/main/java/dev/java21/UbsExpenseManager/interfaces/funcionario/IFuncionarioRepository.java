package dev.java21.UbsExpenseManager.interfaces.funcionario;

import dev.java21.UbsExpenseManager.models.Funcionario;

import java.util.List;
import java.util.UUID;

public interface IFuncionarioRepository {

    public Funcionario createFuncionario(Funcionario funcionario);
    public List<Funcionario> getAllFuncionarios();
    public Funcionario getFuncionarioById(UUID id);

}

