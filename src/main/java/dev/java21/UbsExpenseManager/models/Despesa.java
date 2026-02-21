package dev.java21.UbsExpenseManager.models;

import dev.java21.UbsExpenseManager.enums.DespesaCategoria;
import dev.java21.UbsExpenseManager.enums.DespesaStatus;
import dev.java21.UbsExpenseManager.enums.Moeda;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="despesas")
public class Despesa {
    @Id
    UUID id;
    private UUID funcionarioId;
    private DespesaCategoria categoria;
    private BigDecimal valor;
    private Moeda moeda;
    private String descricao;
    private LocalDateTime data;
    private DespesaStatus status;
    private LocalDateTime dataCriacao;

    public Despesa() {}

    public Despesa(UUID id, UUID funcionarioId, DespesaCategoria categoria, BigDecimal valor, Moeda moeda, String descricao, LocalDateTime data, DespesaStatus status, LocalDateTime dataCriacao) {
        this.id = id;
        this.funcionarioId = funcionarioId;
        this.categoria = categoria;
        this.valor = valor;
        this.moeda = moeda;
        this.descricao = descricao;
        this.data = data;
        this.status = status;
        this.dataCriacao = dataCriacao;
    }

    public UUID getId() {
        return id;
    }

    public UUID getFuncionarioId() {
        return funcionarioId;
    }

    public DespesaCategoria getCategoria() {
        return categoria;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Moeda getMoeda() {
        return moeda;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getData() {
        return data;
    }

    public DespesaStatus getStatus() {
        return status;
    }

    public LocalDateTime getDataCriacao() {
            return dataCriacao;
    }
}
