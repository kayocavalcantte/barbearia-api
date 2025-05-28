package com.barbearia_api.controller;

import com.barbearia_api.dto.agendamento.AgendamentoServicoDto;
import com.barbearia_api.service.AgendamentoServicoService;
import com.barbearia_api.viewmodel.ServicoVmGeral;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamento-servico")
public class AgendamentoServicoController {

    private final AgendamentoServicoService service;

    public AgendamentoServicoController(AgendamentoServicoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> salvarServicos(@RequestBody AgendamentoServicoDto dto) {
        service.salvarServicos(dto.getAgendamentoId(), dto.getServicoIds());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/por-agendamento/{id}")
    public ResponseEntity<List<ServicoVmGeral>> listarPorAgendamento(@PathVariable Integer id) {
        return ResponseEntity.ok(service.listarPorAgendamento(id));
    }
}
