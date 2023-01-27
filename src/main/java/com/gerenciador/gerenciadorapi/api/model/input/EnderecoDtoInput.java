package com.gerenciador.gerenciadorapi.api.model.input;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoDtoInput {

  @NotBlank
  private String logradouro;

  @NotBlank
  private String cep;

  @NotBlank
  private String numero;

  @NotBlank
  private String cidade;

  @Valid
  @NotNull
  private PessoaIdInput pessoa;
}
