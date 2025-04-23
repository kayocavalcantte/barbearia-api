package com.barbearia_api.controller;

import com.barbearia_api.dto.agendamento.AgendamentoRegisterDto;
import com.barbearia_api.service.AgendamentoService;
import com.barbearia_api.viewmodel.AgendamentoVmGeral;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("agendamento")
public class AgendamentoController {
    private AgendamentoService agendamentoService;

    public AgendamentoController(AgendamentoService agendamentoService) {
        this.agendamentoService = agendamentoService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<AgendamentoVmGeral>> listAll(){
        return ResponseEntity.ok(agendamentoService.listAll());
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<AgendamentoVmGeral> listById(Integer id){
        return ResponseEntity.ok(agendamentoService.listById(id));
    }

    @PostMapping("/register")
    public ResponseEntity<AgendamentoVmGeral> register(@RequestBody AgendamentoRegisterDto agendamentoRegisterDto){
        return ResponseEntity.ok(agendamentoService.register(agendamentoRegisterDto));
    }
}
