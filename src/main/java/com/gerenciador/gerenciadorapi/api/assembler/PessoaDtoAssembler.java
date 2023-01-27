package com.gerenciador.gerenciadorapi.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gerenciador.gerenciadorapi.api.model.PessoaDTO;
import com.gerenciador.gerenciadorapi.domain.model.Pessoa;

@Component
public class PessoaDtoAssembler {
  
  @Autowired
  private ModelMapper modelMapper;

  public PessoaDTO toDTO(Pessoa pessoa) {
    return modelMapper.map(pessoa, PessoaDTO.class);
  }

  public List<PessoaDTO> toCollectionDTO(List<Pessoa> pessoas) {

    return pessoas.stream()
            .map(pessoa -> toDTO(pessoa))
            .collect(Collectors.toList());
  }
}
