package dev.java21.UbsExpenseManager.repositorys;

import java.util.List;
import java.util.UUID;

import dev.java21.UbsExpenseManager.exceptions.ResourceNotFoundException;
import dev.java21.UbsExpenseManager.interfaces.funcionario.IFuncionarioJpaRepository;
import org.springframework.stereotype.Repository;

import dev.java21.UbsExpenseManager.interfaces.funcionario.IFuncionarioRepository;
import dev.java21.UbsExpenseManager.models.Funcionario;

@Repository
public class FuncionarioRepository implements IFuncionarioRepository{ 
    
    private final IFuncionarioJpaRepository jpaRepo;

    public FuncionarioRepository(IFuncionarioJpaRepository jpaRepo) {
        this.jpaRepo = jpaRepo;
    }

    public Funcionario createFuncionario(Funcionario funcionario) {
        this.jpaRepo.save(funcionario);
        return funcionario;
    }

    public List<Funcionario> getAllFuncionarios() {
        return this.jpaRepo.findAll();
    }

    public Funcionario getFuncionarioById(UUID id) {
        var row = this.jpaRepo.findById(id).orElse(null);
        if (row == null){
            throw new ResourceNotFoundException("Funcionario with id '" + id + "' was not found.");
        }
        return row;
    }

}
