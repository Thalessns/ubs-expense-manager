package dev.java21.UbsExpenseManager.services;

import dev.java21.UbsExpenseManager.dtos.funcionario.FuncionarioRequest;
import dev.java21.UbsExpenseManager.dtos.funcionario.FuncionarioResponse;
import dev.java21.UbsExpenseManager.models.Funcionario;
import dev.java21.UbsExpenseManager.repositorys.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class FuncionarioService {

    private final FuncionarioRepository repository;

    public FuncionarioService(FuncionarioRepository repository) {
        this.repository = repository;
    }

    public FuncionarioResponse createFuncionario(FuncionarioRequest funcionarioRequest) {
        Funcionario funcionario = new Funcionario(
                UUID.randomUUID(),
                funcionarioRequest.nome(),
                funcionarioRequest.email(),
                funcionarioRequest.cargo(),
                funcionarioRequest.departamentoID(),
                funcionarioRequest.gestorId(),
                LocalDateTime.now(ZoneId.of("America/Sao_Paulo"))
        );
        repository.save(funcionario);
        return toFuncionarioResponse(funcionario);
    }

    public List<FuncionarioResponse> getAll(){
        List<Funcionario> rows = repository.findAll();
        List<FuncionarioResponse> funcionarios = new ArrayList<>();
        for (Funcionario row : rows) {
            funcionarios.add(toFuncionarioResponse(row));
        }
        return funcionarios;
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
