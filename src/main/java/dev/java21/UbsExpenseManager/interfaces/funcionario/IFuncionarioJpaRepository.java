package dev.java21.UbsExpenseManager.interfaces.funcionario;

import dev.java21.UbsExpenseManager.models.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IFuncionarioJpaRepository extends JpaRepository<Funcionario, UUID> {
    
}
