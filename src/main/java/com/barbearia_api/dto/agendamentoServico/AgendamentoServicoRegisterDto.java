package com.barbearia_api.dto.agendamentoServico;

import com.barbearia_api.model.Agendamento;
import com.barbearia_api.model.Servico;
import jakarta.validation.constraints.NotNull;

public class AgendamentoServicoRegisterDto {
    @NotNull(message = "Campo invalido.")
    public Agendamento agendamentoId;

    @NotNull(message = "Campo invalido.")
    public Servico servicoId;

    public AgendamentoServicoRegisterDto() {}

    public AgendamentoServicoRegisterDto(Agendamento agendamentoId, Servico servicoId) {
        this.agendamentoId = agendamentoId;
        this.servicoId = servicoId;
    }

    public Agendamento getAgendamentoId() {
        return agendamentoId;
    }

    public void setAgendamentoId(Agendamento agendamentoId) {
        this.agendamentoId = agendamentoId;
    }

    public Servico getServicoId() {
        return servicoId;
    }

    public void setServicoId(Servico servicoId) {
        this.servicoId = servicoId;
    }
}
