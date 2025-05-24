package com.barbearia_api.viewmodel;

public class ServicoVmGeral {
    private Integer id;
    private String descricao;

    public ServicoVmGeral(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Integer getId() { return id; }
    public String getDescricao() { return descricao; }
}
