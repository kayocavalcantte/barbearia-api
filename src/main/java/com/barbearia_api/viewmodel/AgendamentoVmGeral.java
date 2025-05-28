package com.barbearia_api.viewmodel;

import com.barbearia_api.viewmodel.ServicoVmGeral;
import com.barbearia_api.model.Agendamento.StatusAgendamento;

import java.util.List;

public class AgendamentoVmGeral {

    private Integer id;
    private Integer funcionarioId;
    private Integer usuarioId;
    private String horario;
    private String dataAgendamento;
    private StatusAgendamento statusAgendamento;
    private String crc;

    private String nomeUsuario;
    private String emailUsuario;
    private String telefoneUsuario;

    private List<ServicoVmGeral> servicos;

    public AgendamentoVmGeral() {}

    public AgendamentoVmGeral(Integer id, Integer funcionarioId, Integer usuarioId, String horario, String dataAgendamento,
                              StatusAgendamento statusAgendamento, String crc,
                              String nomeUsuario, String emailUsuario, String telefoneUsuario) {
        this.id = id;
        this.funcionarioId = funcionarioId;
        this.usuarioId = usuarioId;
        this.horario = horario;
        this.dataAgendamento = dataAgendamento;
        this.statusAgendamento = statusAgendamento;
        this.crc = crc;
        this.nomeUsuario = nomeUsuario;
        this.emailUsuario = emailUsuario;
        this.telefoneUsuario = telefoneUsuario;
    }

    // ✅ Getters e Setters

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getFuncionarioId() { return funcionarioId; }
    public void setFuncionarioId(Integer funcionarioId) { this.funcionarioId = funcionarioId; }

    public Integer getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Integer usuarioId) { this.usuarioId = usuarioId; }

    public String getHorario() { return horario; }
    public void setHorario(String horario) { this.horario = horario; }

    public String getDataAgendamento() { return dataAgendamento; }
    public void setDataAgendamento(String dataAgendamento) { this.dataAgendamento = dataAgendamento; }

    public StatusAgendamento getStatusAgendamento() { return statusAgendamento; }
    public void setStatusAgendamento(StatusAgendamento statusAgendamento) { this.statusAgendamento = statusAgendamento; }

    public String getCrc() { return crc; }
    public void setCrc(String crc) { this.crc = crc; }

    public String getNomeUsuario() { return nomeUsuario; }
    public void setNomeUsuario(String nomeUsuario) { this.nomeUsuario = nomeUsuario; }

    public String getEmailUsuario() { return emailUsuario; }
    public void setEmailUsuario(String emailUsuario) { this.emailUsuario = emailUsuario; }

    public String getTelefoneUsuario() { return telefoneUsuario; }
    public void setTelefoneUsuario(String telefoneUsuario) { this.telefoneUsuario = telefoneUsuario; }

    public List<ServicoVmGeral> getServicos() { return servicos; }
    public void setServicos(List<ServicoVmGeral> servicos) { this.servicos = servicos; }
}
