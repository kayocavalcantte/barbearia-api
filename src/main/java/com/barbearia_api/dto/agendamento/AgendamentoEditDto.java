package com.barbearia_api.dto.agendamento;

import com.barbearia_api.model.Agendamento;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class AgendamentoEditDto {
    @NotNull(message = "Campo invalido.")
    private Integer id;

    @NotNull(message = "Campo invalido.")
    private Integer funcionarioId;

    @Pattern(regexp = "^\\d{2}:\\d{2}$", message = "Formato de horário inválido. Use HH:mm")
    private String horario;

    @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$", message = "Formato de horário inválido. Use dd/mm/aaaa")
    private String dataAgendamento;

    public AgendamentoEditDto(){}

    public AgendamentoEditDto(Integer id, Integer funcionarioId, String horario, String dataAgendamento) {
        this.id = id;
        this.funcionarioId = funcionarioId;
        this.horario = horario;
        this.dataAgendamento = dataAgendamento;
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

}
