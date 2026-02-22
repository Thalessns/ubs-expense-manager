package dev.java21.UbsExpenseManager.models;

import dev.java21.UbsExpenseManager.enums.DespesaCategoria;
import dev.java21.UbsExpenseManager.enums.DespesaStatus;
import dev.java21.UbsExpenseManager.enums.Moeda;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="despesas")
public class Despesa {

    @Id
    @Column(nullable = false, unique = true, length = 36)
    UUID id;
    @ManyToOne
    @JoinColumn(
            name = "funcionarioId",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                name = "FK_DESPESAS_FUNCIONARIOS"
            )
    )
    private Funcionario funcionario;
    @Column(nullable = false, length = 50)
    private DespesaCategoria categoria;
    @Column(nullable = false)
    private BigDecimal valor;
    @Column(nullable = false,  length = 3)
    private Moeda moeda;
    @Column(nullable = false,  length = 100)
    private String descricao;
    @Column(nullable = false)
    private LocalDateTime data;
    @Column(nullable = false, length = 20)
    private DespesaStatus status;
    private LocalDateTime dataCriacao;

    public Despesa() {}

    public Despesa(UUID id, Funcionario funcionario, DespesaCategoria categoria, BigDecimal valor, Moeda moeda, String descricao, LocalDateTime data, DespesaStatus status, LocalDateTime dataCriacao) {
        this.id = id;
        this.funcionario = funcionario;
        this.categoria = categoria;
        this.valor = valor;
        this.moeda = moeda;
        this.descricao = descricao;
        this.data = data;
        this.status = status;
        this.dataCriacao = dataCriacao;
    }

    public UUID id() {
        return id;
    }

    public Funcionario funcionario() { return funcionario; }

    public DespesaCategoria categoria() {
        return categoria;
    }

    public BigDecimal valor() {
        return valor;
    }

    public Moeda moeda() {
        return moeda;
    }

    public String descricao() {
        return descricao;
    }

    public LocalDateTime data() {
        return data;
    }

    public DespesaStatus status() {
        return status;
    }

    public LocalDateTime dataCriacao() {
            return dataCriacao;
    }
}
