package com.gerenciador.gerenciadorapi.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerenciador.gerenciadorapi.api.assembler.PessoaDtoAssembler;
import com.gerenciador.gerenciadorapi.api.assembler.PessoaDtoDisassembler;
import com.gerenciador.gerenciadorapi.api.model.PessoaDTO;
import com.gerenciador.gerenciadorapi.api.model.input.PessoaDtoInput;
import com.gerenciador.gerenciadorapi.domain.model.Pessoa;
import com.gerenciador.gerenciadorapi.domain.repository.PessoaRepository;
import com.gerenciador.gerenciadorapi.domain.service.CadastroPessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

  @Autowired
  private PessoaRepository pessoaRepository;

  @Autowired
  private CadastroPessoaService cadastroPessoa;

  @Autowired
  private PessoaDtoAssembler pessoaDtoAssembler;

  @Autowired
  private PessoaDtoDisassembler pessoaDtoDisassembler;

  @GetMapping
  public List<PessoaDTO> listar() {
    
    return pessoaDtoAssembler.toCollectionDTO(pessoaRepository.findAll());
  }

  @GetMapping("/{id}")
  public PessoaDTO buscar(@PathVariable Long id) {
    Pessoa pessoa = cadastroPessoa.buscarOuFalhar(id);

    return pessoaDtoAssembler.toDTO(pessoa);
  }

  @PostMapping
  public PessoaDTO adicionar(@RequestBody @Valid PessoaDtoInput pessoaDtoInput) {
    Pessoa pessoa = pessoaDtoDisassembler.toDomainObject(pessoaDtoInput);
    pessoa = cadastroPessoa.salvar(pessoa);

    return pessoaDtoAssembler.toDTO(pessoa);
  }

  @PutMapping("/{pessoaId}")
  public PessoaDTO atualizar(@PathVariable Long pessoaId, @RequestBody @Valid PessoaDtoInput pessoaDtoInput) {
    
    Pessoa pessoaAtual = cadastroPessoa.buscarOuFalhar(pessoaId);

    pessoaDtoDisassembler.copyToDomainObject(pessoaDtoInput, pessoaAtual);
    pessoaAtual = cadastroPessoa.salvar(pessoaAtual);

    return pessoaDtoAssembler.toDTO(pessoaAtual);
  }
}
