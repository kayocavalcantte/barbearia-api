package com.barbearia_api.dto.agendamento;


public class AgendamentoRegisterDto {
    private Integer funcionarioId;
    private Integer usuarioId;
    private String horario;
    private String dataAgendamento;

    public  AgendamentoRegisterDto() {}

    public AgendamentoRegisterDto(Integer funcionarioId, Integer usuarioId, String horario, String dataAgendamento) {
        this.funcionarioId = funcionarioId;
        this.usuarioId = usuarioId;
        this.horario = horario;
        this.dataAgendamento = dataAgendamento;
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

}
