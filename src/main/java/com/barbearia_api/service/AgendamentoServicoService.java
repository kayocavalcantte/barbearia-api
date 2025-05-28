package com.barbearia_api.service;

import com.barbearia_api.model.AgendamentoServico;
import com.barbearia_api.repositories.AgendamentoServicoRepository;
import com.barbearia_api.viewmodel.ServicoVmGeral;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgendamentoServicoService {

    private final AgendamentoServicoRepository repository;

    public AgendamentoServicoService(AgendamentoServicoRepository repository) {
        this.repository = repository;
    }


    public void salvarServicos(Integer agendamentoId, List<Integer> servicoIds) {
        for (Integer servicoId : servicoIds) {
            AgendamentoServico as = new AgendamentoServico();
            as.setAgendamentoId(agendamentoId);
            as.setServicoId(servicoId);
            repository.save(as);
        }
    }

    public List<ServicoVmGeral> listarPorAgendamento(Integer agendamentoId) {
        return repository.findByAgendamentoId(agendamentoId).stream()
                .map(as -> new ServicoVmGeral(
                        as.getServicoId(),
                        as.getDescricao()
                ))
                .collect(Collectors.toList());
    }
}
