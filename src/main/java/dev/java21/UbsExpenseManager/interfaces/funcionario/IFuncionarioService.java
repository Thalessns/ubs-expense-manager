package dev.java21.UbsExpenseManager.interfaces.funcionario;

import java.util.List;
import java.util.UUID;

import dev.java21.UbsExpenseManager.dtos.funcionario.FuncionarioRequest;
import dev.java21.UbsExpenseManager.dtos.funcionario.FuncionarioResponse;
import dev.java21.UbsExpenseManager.models.Funcionario;

public interface IFuncionarioService {
    
    public FuncionarioResponse createFuncionario(FuncionarioRequest funcionarioRequest);
    public List<FuncionarioResponse> getAll();
    public FuncionarioResponse getFuncionarioById(UUID id);
    public FuncionarioResponse toFuncionarioResponse(Funcionario funcionario);
}
