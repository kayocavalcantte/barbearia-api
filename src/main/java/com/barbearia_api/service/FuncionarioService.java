package com.barbearia_api.service;

import com.barbearia_api.dto.funcionario.FuncionarioRegisterDto;
import com.barbearia_api.model.Funcionario;
import com.barbearia_api.repositories.FuncionarioRepository;
import com.barbearia_api.viewmodel.FuncionarioVmGeral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<FuncionarioVmGeral> listAll(){
        return funcionarioRepository.findAll()
                .stream().map(f -> new FuncionarioVmGeral(
                        f.getId(),
                        f.isAtivo(),
                        f.getUsuarioId(),
                        f.getHorarioInicio(),
                        f.getHorarioFinal()
                ))
                .collect(Collectors.toList());
    }

    public FuncionarioVmGeral listById(Integer id){
        return funcionarioRepository.findById(id)
                .map(f -> new FuncionarioVmGeral(
                        f.getId(),
                        f.isAtivo(),
                        f.getUsuarioId(),
                        f.getHorarioInicio(),
                        f.getHorarioFinal()
                ))
                .orElse(null);
    }

    public FuncionarioVmGeral register(FuncionarioRegisterDto funcionarioRegisterDto){
        String horarioInicio = funcionarioRegisterDto.getHorarioInicio() != null
                ? funcionarioRegisterDto.getHorarioInicio()
                : "08:00:00";

        String horarioFinal = funcionarioRegisterDto.getHorarioFinal() != null
                ? funcionarioRegisterDto.getHorarioFinal()
                : "19:00:00";

        Funcionario funcionario = new Funcionario(
                null,
                true,
                funcionarioRegisterDto.getUsuarioId(),
                horarioInicio,
                horarioFinal
        );

        funcionario = funcionarioRepository.save(funcionario);

        return new FuncionarioVmGeral(
                funcionario.getId(),
                funcionario.isAtivo(),
                funcionario.getUsuarioId(),
                funcionario.getHorarioInicio(),
                funcionario.getHorarioFinal()
        );
    }

}
