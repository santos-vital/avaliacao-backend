package com.gerenciador.gerenciadorapi.domain.exception;

public class NegocioException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public NegocioException(String mensagem) {
    super(mensagem);
  }

  public NegocioException(String message, Throwable causa) {
    super(message, causa);
  }
}
