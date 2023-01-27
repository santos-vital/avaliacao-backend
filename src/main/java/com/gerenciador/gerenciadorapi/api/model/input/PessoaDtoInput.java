package com.gerenciador.gerenciadorapi.api.model.input;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaDtoInput {

  @NotBlank
  private String nome;

  @NotNull
  private LocalDate dataNascimento;
}
