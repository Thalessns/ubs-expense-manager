package dev.java21.UbsExpenseManager.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "funcionarios")
public class Funcionario{
        @Id
        private UUID id;
        private String nome;
        private String email;
        private String cargo;
        private UUID departamentoId;
        private UUID gestorId;
        private LocalDateTime dataCriacao;

        public Funcionario() {}

        public Funcionario(UUID id, String nome, String email, String cargo, UUID departamentoId, UUID gestorId, LocalDateTime dataCriacao) {
                this.id = id;
                this.nome = nome;
                this.email = email;
                this.cargo = cargo;
                this.departamentoId = departamentoId;
                this.gestorId = gestorId;
                this.dataCriacao = dataCriacao;
        }

        public UUID getId() {
                return id;
        }

        public String getNome() {
                return nome;
        }

        public String getEmail() {
                return email;
        }

        public String getCargo() {
                return cargo;
        }

        public UUID getDepartamentoId() {
                return departamentoId;
        }

        public UUID getGestorId() {
                return gestorId;
        }

        public LocalDateTime getDataCriacao() {
                return dataCriacao;
        }
}
