package com.barbearia_api.dto.funcionario;

public class FuncionarioEditDto {
    private Integer id;
    private boolean isAtivo;
    private String horarioInicio;
    private String horarioFinal;

    public FuncionarioEditDto() {}

    public FuncionarioEditDto(Integer id, boolean isAtivo, String horarioInicio, String horarioFinal) {
        this.id = id;
        this.isAtivo = isAtivo;
        this.horarioInicio = horarioInicio;
        this.horarioFinal = horarioFinal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isAtivo() {
        return isAtivo;
    }

    public void setAtivo(boolean ativo) {
        isAtivo = ativo;
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
}
