package dev.java21.UbsExpenseManager.services;

import dev.java21.UbsExpenseManager.dtos.funcionario.FuncionarioRequest;
import dev.java21.UbsExpenseManager.dtos.funcionario.FuncionarioResponse;
import dev.java21.UbsExpenseManager.interfaces.departamento.IDepartamentoRepository;
import dev.java21.UbsExpenseManager.interfaces.funcionario.IFuncionarioRepository;
import dev.java21.UbsExpenseManager.interfaces.funcionario.IFuncionarioService;
import dev.java21.UbsExpenseManager.interfaces.utils.IUtilsService;
import dev.java21.UbsExpenseManager.models.Departamento;
import dev.java21.UbsExpenseManager.models.Funcionario;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class FuncionarioService implements IFuncionarioService{

    private final IFuncionarioRepository repository;
    private final IDepartamentoRepository departamentoRepository;
    public final IUtilsService utils;

    public FuncionarioService(
            IFuncionarioRepository repository,
            IDepartamentoRepository departamentoRepository,
            IUtilsService utils){
        this.repository = repository;
        this.departamentoRepository = departamentoRepository;
        this.utils = utils;
    }

    public FuncionarioResponse createFuncionario(FuncionarioRequest funcionarioRequest) {
        Departamento departamento = departamentoRepository.getDepartamentoById(funcionarioRequest.departamentoID());
        Funcionario gestor = null;
        if (funcionarioRequest.gestorId() != null){
            gestor = repository.getFuncionarioById(funcionarioRequest.gestorId());
        }
        Funcionario funcionario = new Funcionario(
                UUID.randomUUID(),
                funcionarioRequest.nome(),
                funcionarioRequest.email(),
                funcionarioRequest.cargo(),
                departamento,
                gestor,
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
        return toFuncionarioResponse(repository.getFuncionarioById(id));
    }

    public FuncionarioResponse toFuncionarioResponse(Funcionario funcionario){
        return new FuncionarioResponse(
                funcionario.id(),
                funcionario.nome(),
                funcionario.email(),
                funcionario.cargo(),
                funcionario.departamento().id(),
                (funcionario.gestor() != null) ? funcionario.gestor().id() : null,
                funcionario.dataCriacao()
        );
    }
}
