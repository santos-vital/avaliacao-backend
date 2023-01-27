package com.gerenciador.gerenciadorapi.domain.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciador.gerenciadorapi.domain.exception.PessoaNaoEncontradaException;
import com.gerenciador.gerenciadorapi.domain.model.Pessoa;
import com.gerenciador.gerenciadorapi.domain.repository.PessoaRepository;

@Service
public class CadastroPessoaService {
  
  @Autowired
  private PessoaRepository pessoaRepository;

  @Transactional
  public Pessoa salvar(Pessoa pessoa) {
    
    return pessoaRepository.save(pessoa);
  }

  public Pessoa buscarOuFalhar(Long pessoaId) {

    return pessoaRepository.findById(pessoaId)
                .orElseThrow(() -> new PessoaNaoEncontradaException(pessoaId));
  }
}
