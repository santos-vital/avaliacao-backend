package com.gerenciador.gerenciadorapi.domain.exception;

public class PessoaNaoEncontradaException extends EntidadeNaoEncontradaException {

  public PessoaNaoEncontradaException(String mensagem) {
    super(mensagem);
  }
  
  public PessoaNaoEncontradaException(Long pessoaId) {
    this(String.format("Não existe um cadastro de pessoa com código %d", pessoaId));
  }
}
