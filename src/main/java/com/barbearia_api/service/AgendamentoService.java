package com.barbearia_api.service;

import com.barbearia_api.dto.agendamento.AgendamentoRegisterDto;
import com.barbearia_api.model.Agendamento;
import com.barbearia_api.repositories.AgendamentoRepository;
import com.barbearia_api.viewmodel.AgendamentoVmGeral;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgendamentoService {
    private AgendamentoRepository agendamentoRepository;

    public List<AgendamentoVmGeral> listAll(){
        return agendamentoRepository.findAll().stream()
                .map(a -> new AgendamentoVmGeral(a.getId(), a.getFuncionarioId(), a.getUsuarioId(), a.getHorario(),
                        a.getDataAgendamento(), a.getStatusAgendamento(), a.getCrc()))
                .collect(Collectors.toList());
    }

    public AgendamentoVmGeral listById(Integer id) {
        return agendamentoRepository.findById(id).map(a ->
                new AgendamentoVmGeral(a.getId(), a.getFuncionarioId(), a.getUsuarioId(), a.getHorario(),
                        a.getDataAgendamento(), a.getStatusAgendamento(), a.getCrc()))
                .orElse(null);
    }

    public AgendamentoVmGeral register(AgendamentoRegisterDto agendamentoRegisterDto){
        String crc = "f"+ agendamentoRegisterDto.getFuncionarioId() + "-" +
                "h" + agendamentoRegisterDto.getHorario() + "-" +
                "d" + agendamentoRegisterDto.getDataAgendamento();

        Agendamento agendamento = new Agendamento(
                null,
                agendamentoRegisterDto.getFuncionarioId(),
                agendamentoRegisterDto.getUsuarioId(),
                agendamentoRegisterDto.getHorario(),
                agendamentoRegisterDto.getDataAgendamento(),
                Agendamento.StatusAgendamento.ESPERA,
                crc
        );

        agendamento = agendamentoRepository.save(agendamento);

        return new AgendamentoVmGeral(
                agendamento.getId(),
                agendamento.getFuncionarioId(),
                agendamento.getUsuarioId(),
                agendamento.getHorario(),
                agendamento.getDataAgendamento(),
                agendamento.getStatusAgendamento(),
                agendamento.getCrc());
    }

}
