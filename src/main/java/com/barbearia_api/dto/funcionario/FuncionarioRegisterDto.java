package com.barbearia_api.dto.funcionario;

public class FuncionarioRegisterDto {
    private String nome;


    public FuncionarioRegisterDto(){}

    public FuncionarioRegisterDto(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
