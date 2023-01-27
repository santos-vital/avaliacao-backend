package com.gerenciador.gerenciadorapi.api.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaDTO {
  
  private Long id;
  private String nome;
  private LocalDate dataNascimento;
  private List<EnderecoDTO> enderecos = new ArrayList<>();
}
