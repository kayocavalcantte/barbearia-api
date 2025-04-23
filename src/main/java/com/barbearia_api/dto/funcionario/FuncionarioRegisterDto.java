package com.barbearia_api.dto.funcionario;

import com.barbearia_api.model.Usuario;

import java.sql.Time;

public class FuncionarioRegisterDto {
    private Integer usuarioId;
    private String horarioInicio;
    private String horarioFinal;

    public FuncionarioRegisterDto(){}

    public FuncionarioRegisterDto(Integer usuarioId, String horarioInicio, String horarioFinal) {
        this.usuarioId = usuarioId;
        this.horarioInicio = horarioInicio;
        this.horarioFinal = horarioFinal;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
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
