package com.gerenciador.gerenciadorapi.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gerenciador.gerenciadorapi.api.model.input.EnderecoDtoInput;
import com.gerenciador.gerenciadorapi.api.model.input.EnderecoPrincipalDtoInput;
import com.gerenciador.gerenciadorapi.domain.model.Endereco;
import com.gerenciador.gerenciadorapi.domain.model.Pessoa;

@Component
public class EnderecoDtoDisassembler {
  
  @Autowired
  private ModelMapper modelMapper;

  public Endereco toDomainObject(EnderecoDtoInput enderecoDtoInput) {
    return modelMapper.map(enderecoDtoInput, Endereco.class);
  }

  public void copyToDomainObject(EnderecoDtoInput enderecoDtoInput, Endereco endereco) {
    endereco.setPessoa(new Pessoa());

    modelMapper.map(enderecoDtoInput, endereco);
  }

  public void copyToDomainObjectMudarEndereco(EnderecoPrincipalDtoInput enderecoPrincipalDtoInput, Endereco endereco) {

    modelMapper.map(enderecoPrincipalDtoInput, endereco);
  }
}
