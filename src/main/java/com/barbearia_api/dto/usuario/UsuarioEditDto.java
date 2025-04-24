package com.barbearia_api.dto.usuario;

import com.barbearia_api.model.Usuario;

public class UsuarioEditDto {
    private Integer id;
    private String nome;
    private String telefone;
    private Usuario.TipoPerfil tipoPerfil;

    public UsuarioEditDto(){}

    public UsuarioEditDto(Integer id, String nome, String telefone, Usuario.TipoPerfil tipoPerfil) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.tipoPerfil = tipoPerfil;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Usuario.TipoPerfil getTipoPerfil() {
        return tipoPerfil;
    }

    public void setTipoPerfil(Usuario.TipoPerfil tipoPerfil) {
        this.tipoPerfil = tipoPerfil;
    }
}
