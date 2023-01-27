package com.gerenciador.gerenciadorapi.domain.exception;

public class EnderecoNaoEncontradoException extends EntidadeNaoEncontradaException {

  public EnderecoNaoEncontradoException(String mensagem) {
    super(mensagem);
  }
  
  public EnderecoNaoEncontradoException(Long enderecoId) {
    this(String.format("Não existe um cadastro de endereco com código %d", enderecoId));
  }
}
