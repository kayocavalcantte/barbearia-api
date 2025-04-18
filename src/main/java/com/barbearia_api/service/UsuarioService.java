package com.barbearia_api.service;

import com.barbearia_api.dto.usuario.UsuarioRegisterDto;
import com.barbearia_api.model.Usuario;
import com.barbearia_api.repositories.UsuarioRepository;
import com.barbearia_api.viewmodel.UsuarioVmGeral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioVmGeral> listAll(){
        return usuarioRepository.findAll().stream()
                .map(u -> new UsuarioVmGeral(u.getId(),u.getNome(), u.getEmail(), u.getTelefone()))
                .collect(Collectors.toList());
    }

    public UsuarioVmGeral listById(Integer id){
        return usuarioRepository.findById(id)
                .map(u -> new UsuarioVmGeral(u.getId(), u.getNome(), u.getEmail(), u.getTelefone()))
                .orElse(null);
    }

    public UsuarioVmGeral register(UsuarioRegisterDto usuarioRegisterDto){
        Usuario usuario = new Usuario(usuarioRegisterDto.getNome(), usuarioRegisterDto.getEmail(), usuarioRegisterDto.getSenha(), usuarioRegisterDto.getTelefone());
        usuario = usuarioRepository.save(usuario);

        return new UsuarioVmGeral(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getTelefone());
    }
}
