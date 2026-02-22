package dev.java21.UbsExpenseManager.interfaces.despesa;

import dev.java21.UbsExpenseManager.models.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IDespesaJpaRepository extends JpaRepository<Despesa, UUID> {
}
