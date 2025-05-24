package com.barbearia_api.service;

import com.barbearia_api.dto.servico.ServicoRegisterDto;
import com.barbearia_api.model.Servico;
import com.barbearia_api.repositories.ServicoRepository;
import com.barbearia_api.viewmodel.ServicoVmGeral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    public List<ServicoVmGeral> listAll() {
        return servicoRepository.findAll().stream()
                .map(s -> new ServicoVmGeral(s.getId(), s.getDescricao()))
                .collect(Collectors.toList());
    }

    public ServicoVmGeral listById(Integer id) {
        Optional<Servico> servico = servicoRepository.findById(id);
        return servico.map(s -> new ServicoVmGeral(s.getId(), s.getDescricao()))
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado."));
    }

    public ServicoVmGeral register(ServicoRegisterDto dto) {
        Servico servico = new Servico(null, dto.getDescricao());
        servico = servicoRepository.save(servico);
        return new ServicoVmGeral(servico.getId(), servico.getDescricao());
    }

    public ServicoVmGeral update(Integer id, ServicoRegisterDto dto) {
        Servico servico = servicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado para atualização."));

        servico.setDescricao(dto.getDescricao());
        Servico atualizado = servicoRepository.save(servico);

        return new ServicoVmGeral(atualizado.getId(), atualizado.getDescricao());
    }

    public void delete(Integer id) {
        if (!servicoRepository.existsById(id)) {
            throw new RuntimeException("Serviço não encontrado para exclusão.");
        }
        servicoRepository.deleteById(id);
    }
}
