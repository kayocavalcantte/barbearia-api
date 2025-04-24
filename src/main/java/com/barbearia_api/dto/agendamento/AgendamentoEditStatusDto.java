package com.barbearia_api.dto.agendamento;

import com.barbearia_api.model.Agendamento;

public class AgendamentoEditStatusDto {
    private Integer id;
    private Agendamento.StatusAgendamento statusAgendamento;

    public AgendamentoEditStatusDto() {}

    public AgendamentoEditStatusDto(Integer id, Agendamento.StatusAgendamento statusAgendamento) {
        this.id = id;
        this.statusAgendamento = statusAgendamento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Agendamento.StatusAgendamento getStatusAgendamento() {
        return statusAgendamento;
    }

    public void setStatusAgendamento(Agendamento.StatusAgendamento statusAgendamento) {
        this.statusAgendamento = statusAgendamento;
    }
}
