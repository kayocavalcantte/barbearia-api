package com.barbearia_api.controller;

import com.barbearia_api.dto.funcionario.FuncionarioEditDto;
import com.barbearia_api.dto.funcionario.FuncionarioRegisterDto;
import com.barbearia_api.service.FuncionarioService;
import com.barbearia_api.viewmodel.FuncionarioVmGeral;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<FuncionarioVmGeral>> listAll(){
        return ResponseEntity.ok(funcionarioService.listAll());
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<FuncionarioVmGeral> listById(@PathVariable Integer id){
        return ResponseEntity.ok(funcionarioService.listById(id));
    }

    @PostMapping("/register")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<FuncionarioVmGeral> register(@RequestBody FuncionarioRegisterDto funcionarioRegisterDto){
        return ResponseEntity.ok(funcionarioService.register(funcionarioRegisterDto));
    }

    @PutMapping("/edit")
    @PreAuthorize("hasAnyRole('ADMIN', 'FUNCIONARIO')")
    public ResponseEntity<FuncionarioVmGeral> edit (@RequestBody FuncionarioEditDto funcionarioEditDto){
        return ResponseEntity.ok(funcionarioService.update(funcionarioEditDto));
    }
}
