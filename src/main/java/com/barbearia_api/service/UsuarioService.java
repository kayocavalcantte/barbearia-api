package com.barbearia_api.service;

import com.barbearia_api.dto.usuario.UsuarioEditAdminDto;
import com.barbearia_api.dto.usuario.UsuarioEditDto;
import com.barbearia_api.dto.usuario.UsuarioRegisterDto;
import com.barbearia_api.model.Usuario;
import com.barbearia_api.repositories.UsuarioRepository;
import com.barbearia_api.viewmodel.UsuarioVmGeral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<UsuarioVmGeral> listAll() {
        return usuarioRepository.findAll().stream()
                .map(u -> new UsuarioVmGeral(u.getId(), u.getNome(), u.getEmail(), u.getTelefone(), u.getTipoPerfil()))
                .collect(Collectors.toList());
    }

    public UsuarioVmGeral listById(Integer id) {
        return usuarioRepository.findById(id)
                .map(u -> new UsuarioVmGeral(u.getId(), u.getNome(), u.getEmail(), u.getTelefone(), u.getTipoPerfil()))
                .orElse(null);
    }
    public UsuarioVmGeral listByUsuario() {
        Usuario usuarioLogado = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Integer usuarioId = usuarioLogado.getId();

        return usuarioRepository.findById(usuarioId)
                .map(u -> new UsuarioVmGeral(u.getId(), u.getNome(), u.getEmail(), u.getTelefone(), u.getTipoPerfil()))
                .orElse(null);
    }

    public UsuarioVmGeral register(UsuarioRegisterDto usuarioRegisterDto) {
        String senhaCriptografada = passwordEncoder.encode(usuarioRegisterDto.getSenha());

        Usuario usuario = new Usuario(
                null,
                usuarioRegisterDto.getNome(),
                usuarioRegisterDto.getEmail(),
                senhaCriptografada,
                usuarioRegisterDto.getTelefone(),
                Usuario.TipoPerfil.CLIENTE
        );

        usuario = usuarioRepository.save(usuario);

        return new UsuarioVmGeral(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getTelefone(),
                usuario.getTipoPerfil()
        );
    }

    public UsuarioVmGeral registerUsuarioFuncionario(UsuarioRegisterDto usuarioRegisterDto) {
        String senhaCriptografada = passwordEncoder.encode(usuarioRegisterDto.getSenha());

        Usuario usuario = new Usuario(
                null,
                usuarioRegisterDto.getNome(),
                usuarioRegisterDto.getEmail(),
                senhaCriptografada,
                usuarioRegisterDto.getTelefone(),
                Usuario.TipoPerfil.FUNCIONARIO
        );

        usuario = usuarioRepository.save(usuario);

        return new UsuarioVmGeral(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getTelefone(),
                usuario.getTipoPerfil()
        );
    }

    public UsuarioVmGeral update(UsuarioEditAdminDto usuarioEditDto) {
        Usuario usuario = usuarioRepository.findById(usuarioEditDto.getId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

        usuario.setNome(usuarioEditDto.getNome());
        usuario.setTelefone(usuarioEditDto.getTelefone());
        usuario.setTipoPerfil(usuarioEditDto.getTipoPerfil());

        Usuario newUsuario = usuarioRepository.save(usuario);

        return new UsuarioVmGeral(
                newUsuario.getId(),
                newUsuario.getNome(),
                newUsuario.getEmail(),
                newUsuario.getTelefone(),
                newUsuario.getTipoPerfil()
        );
    }

    public UsuarioVmGeral updateCliente(UsuarioEditDto usuarioEditDto) {

        Usuario usuarioLogado = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Integer usuarioId = usuarioLogado.getId();

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

        usuario.setNome(usuarioEditDto.getNome());
        usuario.setTelefone(usuarioEditDto.getTelefone());
        usuario.setEmail(usuarioEditDto.getEmail());
        usuario.setSenha(passwordEncoder.encode(usuarioEditDto.getSenha()));

        Usuario newUsuario = usuarioRepository.save(usuario);

        return new UsuarioVmGeral(
                newUsuario.getId(),
                newUsuario.getNome(),
                newUsuario.getEmail(),
                newUsuario.getTelefone(),
                Usuario.TipoPerfil.CLIENTE
        );
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
    }
}
