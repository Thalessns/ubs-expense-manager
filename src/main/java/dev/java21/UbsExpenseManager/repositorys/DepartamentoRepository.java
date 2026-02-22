package dev.java21.UbsExpenseManager.repositorys;

import dev.java21.UbsExpenseManager.exceptions.ResourceNotFoundException;
import dev.java21.UbsExpenseManager.interfaces.departamento.IDepartamentoJpaRepository;
import dev.java21.UbsExpenseManager.interfaces.departamento.IDepartamentoRepository;
import dev.java21.UbsExpenseManager.models.Departamento;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class DepartamentoRepository implements IDepartamentoRepository {

    public final IDepartamentoJpaRepository jpaRepo;

    public DepartamentoRepository(IDepartamentoJpaRepository jpaRepo) {
        this.jpaRepo = jpaRepo;
    }

    public Departamento createDepartamento(Departamento departamento) {
        return jpaRepo.save(departamento);
    }

    public List<Departamento> getAllDepartamentos() {
        return jpaRepo.findAll();
    }

    public Departamento getDepartamentoById(UUID id) {
        var row = jpaRepo.findById(id).orElse(null);
        if (row == null){
            throw new ResourceNotFoundException("Departamento with id '" + id + "' was not found.");
        }
        return row;
    }
}
