package com.barbearia_api.controller;

import com.barbearia_api.dto.servico.ServicoRegisterDto;
import com.barbearia_api.service.ServicoService;
import com.barbearia_api.viewmodel.ServicoVmGeral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servico")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @GetMapping("/listar")
    public ResponseEntity<List<ServicoVmGeral>> listAll() {
        return ResponseEntity.ok(servicoService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicoVmGeral> listById(@PathVariable Integer id) {
        return ResponseEntity.ok(servicoService.listById(id));
    }

    @PostMapping("/register")
    public ResponseEntity<ServicoVmGeral> register(@RequestBody ServicoRegisterDto dto) {
        return ResponseEntity.ok(servicoService.register(dto));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<ServicoVmGeral> update(@PathVariable Integer id, @RequestBody ServicoRegisterDto dto) {
        return ResponseEntity.ok(servicoService.update(id, dto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        servicoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}