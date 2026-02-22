package dev.java21.UbsExpenseManager.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="departamento")
public class Departamento {

    @Id
    private UUID id;
    private String nome;
    private BigDecimal orcamentoMensal;
    private LocalDateTime dataCriacao;

    public Departamento() {}

    public Departamento(UUID id, String nome, BigDecimal orcamentoMensal, LocalDateTime dataCriacao) {
        this.id = id;
        this.nome = nome;
        this.orcamentoMensal = orcamentoMensal;
        this.dataCriacao = dataCriacao;
    }

    public UUID id() {
        return id;
    }

    public String nome() {
        return nome;
    }

    public BigDecimal orcamentoMensal() {
        return orcamentoMensal;
    }

    public LocalDateTime dataCriacao() {
            return dataCriacao;
    }
}
