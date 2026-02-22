package dev.java21.UbsExpenseManager.services;

import dev.java21.UbsExpenseManager.dtos.departamento.DepartamentoRequest;
import dev.java21.UbsExpenseManager.dtos.departamento.DepartamentoResponse;
import dev.java21.UbsExpenseManager.interfaces.departamento.IDepartamentoRepository;
import dev.java21.UbsExpenseManager.interfaces.departamento.IDepartamentoService;
import dev.java21.UbsExpenseManager.interfaces.utils.IUtilsService;
import dev.java21.UbsExpenseManager.models.Departamento;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class DepartamentoService implements IDepartamentoService {

    public final IDepartamentoRepository repository;
    public final IUtilsService utils;

    public DepartamentoService(IDepartamentoRepository repository, IUtilsService utils) {
        this.repository = repository;
        this.utils = utils;
    }

    public DepartamentoResponse createDepartamento(DepartamentoRequest departamentoRequest){
        Departamento departamento = new Departamento(
                UUID.randomUUID(),
                departamentoRequest.nome(),
                departamentoRequest.orcamentoMensal(),
                utils.getLocalDateTime()
        );
        return toDepartamentoResponse(repository.createDepartamento(departamento));
    }

    public List<DepartamentoResponse> getAllDepartamentos(){
        List<Departamento> rows = repository.getAllDepartamentos();
        List<DepartamentoResponse> departamentos = new ArrayList<>();
        for(Departamento departamento : rows){
            departamentos.add(toDepartamentoResponse(departamento));
        }
        return departamentos;
    }

    public DepartamentoResponse getDepartamentoById(UUID id){
        return toDepartamentoResponse(repository.getDepartamentoById(id));
    }

    public DepartamentoResponse toDepartamentoResponse(Departamento departamento){
        return new DepartamentoResponse(
                departamento.id(),
                departamento.nome(),
                departamento.orcamentoMensal(),
                departamento.dataCriacao()
        );
    }
}
