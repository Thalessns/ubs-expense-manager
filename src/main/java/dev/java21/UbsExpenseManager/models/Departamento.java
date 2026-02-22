package dev.java21.UbsExpenseManager.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="departamentos")
public class Departamento {

    @Id
    @Column(nullable = false, unique = true, length = 36)
    private UUID id;
    @Column(nullable = false, length = 50)
    private String nome;
    @Column(nullable = false)
    private BigDecimal orcamentoMensal;
    @Column(nullable = false)
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
