package com.gerenciador.gerenciadorapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.gerenciador.gerenciadorapi.domain.model.Endereco;

@Component
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
  
}
