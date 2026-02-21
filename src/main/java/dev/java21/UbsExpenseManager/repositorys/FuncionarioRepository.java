package dev.java21.UbsExpenseManager.repositorys;

import dev.java21.UbsExpenseManager.models.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FuncionarioRepository extends JpaRepository<Funcionario, UUID> {
}
