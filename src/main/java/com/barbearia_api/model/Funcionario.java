package com.barbearia_api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "funcionarios")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(name = "is_ativo", nullable = false)
    private boolean isAtivo;

    public Funcionario() {}

    public Funcionario(String nome, boolean isAtivo) {
        this.nome = nome;
        this.isAtivo = isAtivo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAtivo() {
        return isAtivo;
    }

    public void setAtivo(boolean ativo) {
        this.isAtivo = ativo;
    }
}
