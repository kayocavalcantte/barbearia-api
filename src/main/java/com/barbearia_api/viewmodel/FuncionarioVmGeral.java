package com.barbearia_api.viewmodel;

import com.barbearia_api.model.Usuario;

import java.sql.Time;

public class FuncionarioVmGeral {
    private Integer id;
    private boolean isAtivo;
    private Integer usuarioId;
    private String horarioInicio;
    private String horarioFinal;

    public FuncionarioVmGeral(){}

    public FuncionarioVmGeral(Integer id, boolean isAtivo, Integer usuarioId, String horarioInicio, String horarioFinal) {
        this.id = id;
        this.isAtivo = isAtivo;
        this.usuarioId = usuarioId;
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
