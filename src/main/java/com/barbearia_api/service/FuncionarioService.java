package com.barbearia_api.service;

import com.barbearia_api.dto.funcionario.FuncionarioEditDto;
import com.barbearia_api.dto.funcionario.FuncionarioRegisterDto;
import com.barbearia_api.dto.usuario.UsuarioRegisterDto;
import com.barbearia_api.model.Funcionario;
import com.barbearia_api.model.Usuario;
import com.barbearia_api.repositories.FuncionarioRepository;
import com.barbearia_api.repositories.UsuarioRepository;
import com.barbearia_api.viewmodel.FuncionarioVmGeral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    private final UsuarioRepository usuarioRepository;
    private final UsuarioService usuarioService;

    public FuncionarioService(FuncionarioRepository funcionarioRepository, UsuarioRepository usuarioRepository, UsuarioService usuarioService) {
        this.funcionarioRepository = funcionarioRepository;
        this.usuarioRepository = usuarioRepository;
        this.usuarioService = usuarioService;
    }

    public List<FuncionarioVmGeral> listAll(){
        List<Funcionario> funcionarios = funcionarioRepository.findAll();

        return funcionarios.stream().map(f -> {
            Usuario usuario = usuarioRepository.findById(f.getUsuarioId())
                    .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
            return new FuncionarioVmGeral(
                    f.getId(),
                    f.isAtivo(),
                    f.getUsuarioId(),
                    usuario.getNome(),
                    f.getHorarioInicio(),
                    f.getHorarioFinal()
            );
        }).toList();
    }

    public FuncionarioVmGeral listById(Integer id){

        Optional<Funcionario> funcioanrio = funcionarioRepository.findById(id);

        return funcioanrio.map(f -> {
            Usuario usuario = usuarioRepository.findById(f.getUsuarioId())
                    .orElseThrow(() -> new RuntimeException("Usuario não encontrato."));
            return new FuncionarioVmGeral(
                    f.getId(),
                    f.isAtivo(),
                    f.getUsuarioId(),
                    usuario.getNome(),
                    f.getHorarioInicio(),
                    f.getHorarioFinal()
            );
        }).orElse(null);

    }

    public FuncionarioVmGeral listByUsuario(){
        Usuario usu = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Integer usuarioId = usu.getId();

        Optional<Funcionario> funcioanrio = funcionarioRepository.findById(usuarioId);

        return funcioanrio.map(f -> {
            Usuario usuario = usuarioRepository.findById(f.getUsuarioId())
                    .orElseThrow(() -> new RuntimeException("Usuario não encontrato."));
            return new FuncionarioVmGeral(
                    f.getId(),
                    f.isAtivo(),
                    f.getUsuarioId(),
                    usuario.getNome(),
                    f.getHorarioInicio(),
                    f.getHorarioFinal()
            );
        }).orElse(null);

    }

    public FuncionarioVmGeral register(FuncionarioRegisterDto funcionarioRegisterDto){

        var objUsuario = new UsuarioRegisterDto();
        objUsuario.setId(null);
        objUsuario.setNome(funcionarioRegisterDto.getNome());
        objUsuario.setEmail(funcionarioRegisterDto.getEmail());
        objUsuario.setSenha(funcionarioRegisterDto.getSenha());
        objUsuario.setTelefone(funcionarioRegisterDto.getTelefone());

        var newUsuario = usuarioService.registerUsuarioFuncionario(objUsuario);

        String horarioInicio = funcionarioRegisterDto.getHorarioInicio() != null
                ? funcionarioRegisterDto.getHorarioInicio()
                : "08:00:00";

        String horarioFinal = funcionarioRegisterDto.getHorarioFinal() != null
                ? funcionarioRegisterDto.getHorarioFinal()
                : "19:00:00";


        Funcionario funcionario = new Funcionario(
                null,
                true,
                newUsuario.getId(),
                horarioInicio,
                horarioFinal
        );

        funcionario = funcionarioRepository.save(funcionario);

        return new FuncionarioVmGeral(
                funcionario.getId(),
                funcionario.isAtivo(),
                funcionario.getUsuarioId(),
                newUsuario.getNome(),
                funcionario.getHorarioInicio(),
                funcionario.getHorarioFinal()
        );
    }

    public FuncionarioVmGeral update(FuncionarioEditDto funcionarioEditDto){

        Funcionario funcionario = funcionarioRepository.findById(funcionarioEditDto.getId())
                .orElseThrow(() -> new RuntimeException("Funcionario não encontrado."));

        funcionario.setAtivo(funcionarioEditDto.isAtivo());
        funcionario.setHorarioInicio(funcionarioEditDto.getHorarioInicio());
        funcionario.setHorarioFinal(funcionarioEditDto.getHorarioFinal());

        Funcionario newFuncionrio = funcionarioRepository.save(funcionario);
        Usuario usuario = usuarioRepository.findById(newFuncionrio.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

        return new FuncionarioVmGeral(
                newFuncionrio.getUsuarioId(),
                newFuncionrio.isAtivo(),
                newFuncionrio.getUsuarioId(),
                usuario.getNome(),
                newFuncionrio.getHorarioInicio(),
                newFuncionrio.getHorarioFinal()
        );
    }

}
