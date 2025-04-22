package com.barbearia_api.viewmodel;

import com.barbearia_api.model.Usuario.TipoPerfil;

public class UsuarioVmGeral {
    private Integer id;
    private String nome;
    private String email;
    private String telefone;
    private TipoPerfil tipoPerfil;

    public UsuarioVmGeral() {}

    public UsuarioVmGeral(Integer id, String nome, String email, String telefone, TipoPerfil tipoPerfil) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.tipoPerfil = tipoPerfil;
    }

    // Getters and Setters
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public TipoPerfil getTipoPerfil() {
        return tipoPerfil;
    }

    public void setTipoPerfil(TipoPerfil tipoPerfil) {
        this.tipoPerfil = tipoPerfil;
    }
}