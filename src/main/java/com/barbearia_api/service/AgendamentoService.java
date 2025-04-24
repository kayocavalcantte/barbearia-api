package com.barbearia_api.service;

import com.barbearia_api.dto.agendamento.AgendamentoEditDto;
import com.barbearia_api.dto.agendamento.AgendamentoEditStatusDto;
import com.barbearia_api.dto.agendamento.AgendamentoRegisterDto;
import com.barbearia_api.model.Agendamento;
import com.barbearia_api.model.Funcionario;
import com.barbearia_api.model.Usuario;
import com.barbearia_api.repositories.AgendamentoRepository;
import com.barbearia_api.repositories.FuncionarioRepository;
import com.barbearia_api.viewmodel.AgendamentoVmGeral;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgendamentoService {
    private final AgendamentoRepository agendamentoRepository;
    private final FuncionarioRepository funcionarioRepository;

    public AgendamentoService(AgendamentoRepository agendamentoRepository, FuncionarioRepository funcionarioRepository){
        this.agendamentoRepository = agendamentoRepository;
        this.funcionarioRepository = funcionarioRepository;
    }

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

        Funcionario funcionario = funcionarioRepository.findById(agendamentoRegisterDto.getFuncionarioId())
                .orElseThrow(() -> new RuntimeException("Funcionario não encontrado."));


        LocalTime horarioAgendamento = LocalTime.parse(agendamentoRegisterDto.getHorario());
        LocalTime horarioInicioFuncionario = LocalTime.parse(funcionario.getHorarioInicio());
        LocalTime horarioFinalFuncionario = LocalTime.parse(funcionario.getHorarioFinal());

        if (horarioAgendamento.isBefore(horarioInicioFuncionario) || horarioAgendamento.isAfter(horarioFinalFuncionario) ) {
            throw  new RuntimeException("Horario não disponível.");
        }

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

    public AgendamentoVmGeral update(AgendamentoEditDto agendamentoEditDto){

        String crc = "f"+ agendamentoEditDto.getFuncionarioId() + "-" +
                "h" + agendamentoEditDto.getHorario() + "-" +
                "d" + agendamentoEditDto.getDataAgendamento();

        Agendamento agendamento = agendamentoRepository.findById(agendamentoEditDto.getId())
                .orElseThrow(() -> new RuntimeException("Agendamento não encontrado com o ID: " + agendamentoEditDto.getId()));

        agendamento.setFuncionarioId(agendamentoEditDto.getFuncionarioId());
        agendamento.setHorario(agendamentoEditDto.getHorario());
        agendamento.setDataAgendamento(agendamentoEditDto.getDataAgendamento());
        agendamento.setStatusAgendamento(agendamentoEditDto.getStatusAgendamento());
        agendamento.setCrc(crc);

        Agendamento newAgendamento = agendamentoRepository.save(agendamento);

        return new AgendamentoVmGeral(
                newAgendamento.getId(),
                newAgendamento.getFuncionarioId(),
                newAgendamento.getUsuarioId(),
                newAgendamento.getHorario(),
                newAgendamento.getDataAgendamento(),
                newAgendamento.getStatusAgendamento(),
                newAgendamento.getCrc()
        );
    }

    public AgendamentoVmGeral updateStatusAgendamento(AgendamentoEditStatusDto agendamentoEditStatusDto){

        Agendamento agendamento = agendamentoRepository.findById(agendamentoEditStatusDto.getId())
                .orElseThrow(() -> new RuntimeException("Agendamento não encontrado com o ID: "  + agendamentoEditStatusDto.getId()));

        agendamento.setStatusAgendamento(agendamentoEditStatusDto.getStatusAgendamento());

        Agendamento newAgendamento = agendamentoRepository.save(agendamento);

        return new AgendamentoVmGeral(
                newAgendamento.getId(),
                newAgendamento.getFuncionarioId(),
                newAgendamento.getUsuarioId(),
                newAgendamento.getHorario(),
                newAgendamento.getDataAgendamento(),
                newAgendamento.getStatusAgendamento(),
                newAgendamento.getCrc()
        );
    }
}
