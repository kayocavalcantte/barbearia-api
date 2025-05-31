package com.barbearia_api.controller;

import com.barbearia_api.dto.usuario.UsuarioEditAdminDto;
import com.barbearia_api.dto.usuario.UsuarioEditDto;
import com.barbearia_api.dto.usuario.UsuarioRegisterDto;
import com.barbearia_api.service.UsuarioService;
import com.barbearia_api.viewmodel.UsuarioVmGeral;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioVmGeral>> listAll(){
        return ResponseEntity.ok(usuarioService.listAll());
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<UsuarioVmGeral> listById(@PathVariable Integer id){
        return ResponseEntity.ok(usuarioService.listById(id));
    }
    @GetMapping("/list-usuario")
    public ResponseEntity<UsuarioVmGeral> listByUsuario(){
        return ResponseEntity.ok(usuarioService.listByUsuario());
    }

    @PostMapping("/register")
    public ResponseEntity<UsuarioVmGeral> register(@RequestBody UsuarioRegisterDto usuarioRegisterDto){
        return ResponseEntity.ok(usuarioService.register(usuarioRegisterDto));
    }

    @PutMapping("/edit")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<UsuarioVmGeral> edit(@RequestBody UsuarioEditAdminDto usuarioEditDto){
        return ResponseEntity.ok(usuarioService.update(usuarioEditDto));
    }

    @PutMapping("/edit-cliente")
    public ResponseEntity<UsuarioVmGeral> editCliente(@RequestBody UsuarioEditDto usuarioEditDto){
        return ResponseEntity.ok(usuarioService.updateCliente(usuarioEditDto));
    }
}
