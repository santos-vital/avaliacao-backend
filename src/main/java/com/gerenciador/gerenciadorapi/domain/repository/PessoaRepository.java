package com.gerenciador.gerenciadorapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.gerenciador.gerenciadorapi.domain.model.Pessoa;

@Component
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
  
}
