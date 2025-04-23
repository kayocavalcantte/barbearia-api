package com.barbearia_api.viewmodel;

import com.barbearia_api.model.Agendamento;

public class AgendamentoVmGeral {
    private Integer id;
    private Integer funcionarioId;
    private Integer usuarioId;
    private String horario;
    private String dataAgendamento;
    private Agendamento.StatusAgendamento statusAgendamento;
    private String crc;

    public AgendamentoVmGeral() {}

    public AgendamentoVmGeral(Integer id, Integer funcionarioId, Integer usuarioId, String horario, String dataAgendamento, Agendamento.StatusAgendamento statusAgendamento, String crc) {
        this.id = id;
        this.funcionarioId = funcionarioId;
        this.usuarioId = usuarioId;
        this.horario = horario;
        this.dataAgendamento = dataAgendamento;
        this.statusAgendamento = statusAgendamento;
        this.crc = crc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(Integer funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(String dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public Agendamento.StatusAgendamento getStatusAgendamento() {
        return statusAgendamento;
    }

    public void setStatusAgendamento(Agendamento.StatusAgendamento statusAgendamento) {
        this.statusAgendamento = statusAgendamento;
    }

    public String getCrc() {
        return crc;
    }

    public void setCrc(String crc) {
        this.crc = crc;
    }
}
