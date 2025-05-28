package com.barbearia_api.repositories;

import com.barbearia_api.model.AgendamentoServico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgendamentoServicoRepository extends JpaRepository<AgendamentoServico, Integer> {
    List<AgendamentoServico> findByAgendamentoId(Integer agendamentoId);
}