package com.barbearia_api.dto.agendamento;

import com.barbearia_api.model.Agendamento;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AgendamentoEditStatusDto {

    @NotNull(message = "Campo invalido.")
    private Integer id;

    @NotNull(message = "O status do agendamento é obrigatório.")
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
