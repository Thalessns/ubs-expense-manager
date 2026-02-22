package dev.java21.UbsExpenseManager.services;

import dev.java21.UbsExpenseManager.dtos.funcionario.FuncionarioRequest;
import dev.java21.UbsExpenseManager.dtos.funcionario.FuncionarioResponse;
import dev.java21.UbsExpenseManager.exceptions.ResourceNotFoundException;
import dev.java21.UbsExpenseManager.interfaces.funcionario.IFuncionarioRepository;
import dev.java21.UbsExpenseManager.interfaces.funcionario.IFuncionarioService;
import dev.java21.UbsExpenseManager.interfaces.utils.IUtilsService;
import dev.java21.UbsExpenseManager.models.Funcionario;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class FuncionarioService implements IFuncionarioService{

    private final IFuncionarioRepository repository;
    public final IUtilsService utils;

    public FuncionarioService(IFuncionarioRepository repository, IUtilsService utils) {
        this.repository = repository;
        this.utils = utils;
    }

    public FuncionarioResponse createFuncionario(FuncionarioRequest funcionarioRequest) {
        Funcionario funcionario = new Funcionario(
                UUID.randomUUID(),
                funcionarioRequest.nome(),
                funcionarioRequest.email(),
                funcionarioRequest.cargo(),
                funcionarioRequest.departamentoID(),
                funcionarioRequest.gestorId(),
                utils.getLocalDateTime()
        );
        return toFuncionarioResponse(repository.createFuncionario(funcionario));
    }

    public List<FuncionarioResponse> getAll(){
        List<Funcionario> rows = repository.getAllFuncionarios();
        List<FuncionarioResponse> funcionarios = new ArrayList<>();
        for (Funcionario row : rows) {
            funcionarios.add(toFuncionarioResponse(row));
        }
        return funcionarios;
    }

    public FuncionarioResponse getFuncionarioById(UUID id){
        var row =  repository.getFuncionarioById(id);
        if (row == null){
            throw new ResourceNotFoundException("Funcionario with id '" + id + "' was not found.");
        }
        return toFuncionarioResponse(row);
    }

    public FuncionarioResponse toFuncionarioResponse(Funcionario funcionario){
        return new FuncionarioResponse(
                funcionario.getId(),
                funcionario.getNome(),
                funcionario.getEmail(),
                funcionario.getCargo(),
                funcionario.getDepartamentoId(),
                funcionario.getGestorId(),
                funcionario.getDataCriacao()
        );
    }
}
