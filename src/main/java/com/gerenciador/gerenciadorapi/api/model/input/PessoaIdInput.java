package com.gerenciador.gerenciadorapi.api.model.input;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PessoaIdInput {
  
  @NotNull
  private Long id;
}
