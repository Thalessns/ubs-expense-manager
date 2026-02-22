package dev.java21.UbsExpenseManager.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "funcionarios")
public class Funcionario{
        @Id
        @Column(nullable = false, unique = true, length = 36)
        private UUID id;
        @Column(nullable = false, length = 50)
        private String nome;
        @Column(nullable = false, length = 50)
        private String email;
        @Column(nullable = false, length = 50)
        private String cargo;
        @ManyToOne
        @JoinColumn(
                name = "departamentoId",
                nullable = false,
                referencedColumnName = "id",
                foreignKey = @ForeignKey(
                        name = "FK_FUNCIONARIOS_DEPARTAMENTOS"
                )
        )
        private Departamento departamento;
        @ManyToOne
        @JoinColumn(
                name = "gestorId",
                nullable = true,
                referencedColumnName = "id",
                foreignKey = @ForeignKey(
                        name = "FK_FUNCIONARIOS_FUNCIONARIOS"
                )
        )
        private Funcionario gestor;
        @Column(nullable = false)
        private LocalDateTime dataCriacao;

        public Funcionario() {}

        public Funcionario(
                UUID id,
                String nome,
                String email,
                String cargo,
                Departamento departamento,
                Funcionario gestor,
                LocalDateTime dataCriacao
        ){
                this.id = id;
                this.nome = nome;
                this.email = email;
                this.cargo = cargo;
                this.departamento = departamento;
                this.gestor = gestor;
                this.dataCriacao = dataCriacao;
        }

        public UUID id() {
                return id;
        }

        public String nome() {
                return nome;
        }

        public String email() {
                return email;
        }

        public String cargo() {
                return cargo;
        }

        public Departamento departamento() {
                return departamento;
        }

        public Funcionario gestor() {
                return gestor;
        }

        public LocalDateTime dataCriacao() {
                return dataCriacao;
        }
}
