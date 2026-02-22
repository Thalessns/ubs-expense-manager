package dev.java21.UbsExpenseManager.services;

import dev.java21.UbsExpenseManager.dtos.despesa.DespesaRequest;
import dev.java21.UbsExpenseManager.dtos.despesa.DespesaResponse;
import dev.java21.UbsExpenseManager.enums.DespesaCategoria;
import dev.java21.UbsExpenseManager.enums.DespesaStatus;
import dev.java21.UbsExpenseManager.enums.Moeda;
import dev.java21.UbsExpenseManager.interfaces.despesa.IDespesaRepository;
import dev.java21.UbsExpenseManager.interfaces.despesa.IDespesaService;
import dev.java21.UbsExpenseManager.interfaces.funcionario.IFuncionarioRepository;
import dev.java21.UbsExpenseManager.interfaces.utils.IUtilsService;
import dev.java21.UbsExpenseManager.models.Despesa;
import dev.java21.UbsExpenseManager.models.Funcionario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class DespesaService implements IDespesaService {

    public final IDespesaRepository repository;
    public final IFuncionarioRepository funcionarioRepository;
    public final IUtilsService utilsService;

    public DespesaService(
            IDespesaRepository repository,
            IFuncionarioRepository funcionarioRepository,
            IUtilsService utilsService
    ) {
        this.repository = repository;
        this.funcionarioRepository = funcionarioRepository;
        this.utilsService = utilsService;
    }

    public DespesaResponse createDespesa(DespesaRequest despesaRequest) {
        Funcionario funcionario = funcionarioRepository.getFuncionarioById(despesaRequest.funcionarioId());
        Despesa despesa = new Despesa(
                UUID.randomUUID(),
                funcionario,
                DespesaCategoria.valueOf(despesaRequest.categoria()),
                despesaRequest.valor(),
                Moeda.valueOf(despesaRequest.moeda()),
                despesaRequest.descricao(),
                despesaRequest.data(),
                DespesaStatus.Pendente,
                utilsService.getLocalDateTime()
        );
        return toDespesaResponse(repository.createDespesa(despesa));
    }

    public List<DespesaResponse> getAllDespesas(){
        List<Despesa> rows = repository.getAllDespesas();
        List<DespesaResponse> despesas = new ArrayList<>();
        for (Despesa despesa : rows) {
            despesas.add(toDespesaResponse(despesa));
        }
        return despesas;
    }

    public DespesaResponse getDespesaById(UUID id) {
        return toDespesaResponse(repository.getDespesaById(id));
    }

    public DespesaResponse toDespesaResponse(Despesa despesa) {
        return new DespesaResponse(
                despesa.id(),
                despesa.funcionario().id(),
                despesa.categoria(),
                despesa.valor(),
                despesa.moeda(),
                despesa.descricao(),
                despesa.data(),
                despesa.status(),
                despesa.dataCriacao()
        );
    }
}
