package dev.java21.UbsExpenseManager.repositorys;

import dev.java21.UbsExpenseManager.exceptions.ResourceNotFoundException;
import dev.java21.UbsExpenseManager.interfaces.despesa.IDespesaJpaRepository;
import dev.java21.UbsExpenseManager.interfaces.despesa.IDespesaRepository;
import dev.java21.UbsExpenseManager.models.Despesa;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class DespesaRepository implements IDespesaRepository {

    private final IDespesaJpaRepository jpaRepo;

    public DespesaRepository(IDespesaJpaRepository jpaRepo) {
        this.jpaRepo = jpaRepo;
    }

    public Despesa createDespesa(Despesa despesa) {
        return  jpaRepo.save(despesa);
    }

    public List<Despesa> getAllDespesas(){
        return jpaRepo.findAll();
    }

    public Despesa getDespesaById(UUID id) {
        var row = jpaRepo.findById(id).orElse(null);
        if (row == null){
            throw new ResourceNotFoundException("Despesa with id: '" + id + "' was not found");
        }
        return row;
    }
}
