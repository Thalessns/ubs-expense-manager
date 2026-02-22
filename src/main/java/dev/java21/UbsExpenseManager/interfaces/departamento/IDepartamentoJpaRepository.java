package dev.java21.UbsExpenseManager.interfaces.departamento;

import dev.java21.UbsExpenseManager.models.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IDepartamentoJpaRepository extends JpaRepository<Departamento, UUID> {
}
