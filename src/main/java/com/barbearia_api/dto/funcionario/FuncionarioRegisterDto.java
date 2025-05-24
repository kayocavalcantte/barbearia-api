package com.barbearia_api.dto.funcionario;

import com.barbearia_api.model.Usuario;

import java.sql.Time;

public class FuncionarioRegisterDto {
    private String horarioInicio;
    private String horarioFinal;
    private String nome;
    private String email;
    private String senha;
    private String telefone;


    public FuncionarioRegisterDto(){}

    public FuncionarioRegisterDto(String horarioInicio, String horarioFinal, String nome, String email, String senha, String telefone) {
        this.horarioInicio = horarioInicio;
        this.horarioFinal = horarioFinal;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
    }

    public String getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(String horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public String getHorarioFinal() {
        return horarioFinal;
    }

    public void setHorarioFinal(String horarioFinal) {
        this.horarioFinal = horarioFinal;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
