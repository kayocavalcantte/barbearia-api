package com.barbearia_api.dto.agendamento;

import com.barbearia_api.model.Agendamento;

public class AgendamentoEditDto {
    private Integer id;
    private Integer funcionarioId;
    private String horario;
    private String dataAgendamento;
    private Agendamento.StatusAgendamento statusAgendamento;

    public AgendamentoEditDto(){}

    public AgendamentoEditDto(Integer id, Integer funcionarioId, String horario, String dataAgendamento, Agendamento.StatusAgendamento statusAgendamento) {
        this.id = id;
        this.funcionarioId = funcionarioId;
        this.horario = horario;
        this.dataAgendamento = dataAgendamento;
        this.statusAgendamento = statusAgendamento;
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
}
