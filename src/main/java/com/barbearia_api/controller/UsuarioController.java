package com.barbearia_api.controller;

import com.barbearia_api.dto.usuario.UsuarioRegisterDto;
import com.barbearia_api.service.UsuarioService;
import com.barbearia_api.viewmodel.UsuarioVmGeral;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioVmGeral>> listAll(){
        try {
            return ResponseEntity.ok(usuarioService.listAll());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<UsuarioVmGeral> listById(Integer id){
        try {
            return ResponseEntity.ok(usuarioService.listById(id));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<UsuarioVmGeral> register(@RequestBody UsuarioRegisterDto usuarioRegisterDto){
        try {
            return ResponseEntity.ok(usuarioService.register(usuarioRegisterDto));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
