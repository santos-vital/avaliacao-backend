package com.gerenciador.gerenciadorapi.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gerenciador.gerenciadorapi.api.model.EnderecoDTO;
import com.gerenciador.gerenciadorapi.domain.model.Endereco;

@Component
public class EnderecoDtoAssembler {
  
  @Autowired
  private ModelMapper modelMapper;

  public EnderecoDTO toDTO(Endereco endereco) {
    return modelMapper.map(endereco, EnderecoDTO.class);
  }

  public List<EnderecoDTO> toCollectionDTO(List<Endereco> enderecos) {

    return enderecos.stream()
            .map(endereco -> toDTO(endereco))
            .collect(Collectors.toList());
  }
}
