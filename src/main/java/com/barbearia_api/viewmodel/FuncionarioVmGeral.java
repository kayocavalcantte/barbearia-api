package com.barbearia_api.viewmodel;

public class FuncionarioVmGeral {
    private Integer id;
    private String nome;
    private boolean isAtivo;

    public FuncionarioVmGeral(){}

    public FuncionarioVmGeral(Integer id, String nome, boolean isAtivo) {
        this.id = id;
        this.nome = nome;
        this.isAtivo = isAtivo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
        isAtivo = ativo;
    }
}
