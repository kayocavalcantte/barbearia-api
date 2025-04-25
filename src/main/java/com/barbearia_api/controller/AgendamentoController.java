package com.barbearia_api.controller;

import com.barbearia_api.dto.agendamento.AgendamentoEditDto;
import com.barbearia_api.dto.agendamento.AgendamentoEditStatusDto;
import com.barbearia_api.dto.agendamento.AgendamentoRegisterDto;
import com.barbearia_api.service.AgendamentoService;
import com.barbearia_api.viewmodel.AgendamentoVmGeral;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("agendamento")
public class AgendamentoController {
    private final AgendamentoService agendamentoService;

    public AgendamentoController(AgendamentoService agendamentoService) {
        this.agendamentoService = agendamentoService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<AgendamentoVmGeral>> listAll(){
        return ResponseEntity.ok(agendamentoService.listAll());
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<AgendamentoVmGeral> listById(@PathVariable Integer id){
        return ResponseEntity.ok(agendamentoService.listById(id));
    }

    @PostMapping("/register")
    public ResponseEntity<AgendamentoVmGeral> register(@Valid @RequestBody AgendamentoRegisterDto agendamentoRegisterDto){
        return ResponseEntity.ok(agendamentoService.register(agendamentoRegisterDto));
    }

    @PutMapping("/edit")
    public ResponseEntity<AgendamentoVmGeral> edit(@Valid @RequestBody AgendamentoEditDto agendamentoEditDto){
        return ResponseEntity.ok(agendamentoService.update(agendamentoEditDto));
    }

    @PutMapping("/edit/status")
    public ResponseEntity<AgendamentoVmGeral> edit(@Valid @RequestBody AgendamentoEditStatusDto agendamentoEditStatusDto){
        return ResponseEntity.ok(agendamentoService.updateStatusAgendamento(agendamentoEditStatusDto));
    }
}
