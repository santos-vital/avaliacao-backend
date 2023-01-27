package com.gerenciador.gerenciadorapi.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoDTO {
  
  private Long id;
  private String logradouro;
  private String cep;
  private String numero;
  private String cidade;
  private Boolean enderecoPrincipal = false;
}
