package com.barbearia_api.dto.agendamento;

import java.util.List;

public class AgendamentoServicoDto {
    private Integer agendamentoId;
    private List<Integer> servicoIds;

    public Integer getAgendamentoId() {
        return agendamentoId;
    }

    public void setAgendamentoId(Integer agendamentoId) {
        this.agendamentoId = agendamentoId;
    }

    public List<Integer> getServicoIds() {
        return servicoIds;
    }

    public void setServicoIds(List<Integer> servicoIds) {
        this.servicoIds = servicoIds;
    }
}
