package com.barbearia_api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "servicos")
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100, nullable = false)
    private String descricao;

    public Servico() {}

    public Servico(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
}

