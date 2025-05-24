package com.barbearia_api.repositories;

import com.barbearia_api.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {
}
