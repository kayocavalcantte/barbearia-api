package com.barbearia_api.model;

import jakarta.persistence.*;

import java.sql.Time;

@Entity
@Table(name = "funcionarios")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "is_ativo", nullable = false)
    private boolean isAtivo;

    @Column(name = "usuario_id")
    private Integer usuarioId;

    @Column(name = "horario_inicio")
    private String horarioInicio;

    @Column(name = "horario_final")
    private String horarioFinal;

    public Funcionario(){}

    public Funcionario(Integer id, boolean isAtivo, Integer usuarioId, String horarioInicio, String horarioFinal) {
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
