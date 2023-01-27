package com.gerenciador.gerenciadorapi.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gerenciador.gerenciadorapi.api.model.input.PessoaDtoInput;
import com.gerenciador.gerenciadorapi.domain.model.Pessoa;

@Component
public class PessoaDtoDisassembler {
  
  @Autowired
  private ModelMapper modelMapper;

  public Pessoa toDomainObject(PessoaDtoInput pessoaDtoInput) {
    return modelMapper.map(pessoaDtoInput, Pessoa.class);
  }

  public void copyToDomainObject(PessoaDtoInput pessoaDtoInput, Pessoa pessoa) {
    modelMapper.map(pessoaDtoInput, pessoa);
  }
}
