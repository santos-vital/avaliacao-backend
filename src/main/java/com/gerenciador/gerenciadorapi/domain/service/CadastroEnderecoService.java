package com.gerenciador.gerenciadorapi.domain.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciador.gerenciadorapi.domain.exception.EnderecoNaoEncontradoException;
import com.gerenciador.gerenciadorapi.domain.model.Endereco;
import com.gerenciador.gerenciadorapi.domain.model.Pessoa;
import com.gerenciador.gerenciadorapi.domain.repository.EnderecoRepository;

@Service
public class CadastroEnderecoService {

  @Autowired
  private EnderecoRepository enderecoRepository;

  @Autowired
  private CadastroPessoaService cadastroPessoa;
  
  @Transactional
  public Endereco salvar(Endereco endereco) {
    
    Long pessoaId = endereco.getPessoa().getId();

    Pessoa pessoa = cadastroPessoa.buscarOuFalhar(pessoaId);

    endereco.setPessoa(pessoa);

    return enderecoRepository.save(endereco);
  }

  public Endereco buscarOuFalhar(Long enderecoId) {

    return enderecoRepository.findById(enderecoId)
              .orElseThrow(() -> new EnderecoNaoEncontradoException(enderecoId));
  }
}
