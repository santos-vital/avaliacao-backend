package com.gerenciador.gerenciadorapi.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gerenciador.gerenciadorapi.api.assembler.EnderecoDtoAssembler;
import com.gerenciador.gerenciadorapi.api.assembler.EnderecoDtoDisassembler;
import com.gerenciador.gerenciadorapi.api.model.EnderecoDTO;
import com.gerenciador.gerenciadorapi.api.model.input.EnderecoDtoInput;
import com.gerenciador.gerenciadorapi.api.model.input.EnderecoPrincipalDtoInput;
import com.gerenciador.gerenciadorapi.domain.exception.EnderecoNaoEncontradoException;
import com.gerenciador.gerenciadorapi.domain.exception.NegocioException;
import com.gerenciador.gerenciadorapi.domain.exception.PessoaNaoEncontradaException;
import com.gerenciador.gerenciadorapi.domain.model.Endereco;
import com.gerenciador.gerenciadorapi.domain.repository.EnderecoRepository;
import com.gerenciador.gerenciadorapi.domain.service.CadastroEnderecoService;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
  
  @Autowired
  private EnderecoRepository enderecoRepository;

  @Autowired
  private CadastroEnderecoService cadastroEndereco;

  @Autowired
  private EnderecoDtoAssembler enderecoDtoAssembler;

  @Autowired
  private EnderecoDtoDisassembler enderecoDtoDisassembler;

  @GetMapping
  public List<EnderecoDTO> listar() {

    return enderecoDtoAssembler.toCollectionDTO(enderecoRepository.findAll());
  }

  @GetMapping("/{id}")
  public EnderecoDTO buscar(@PathVariable Long id) {
    Endereco endereco = cadastroEndereco.buscarOuFalhar(id);

    return enderecoDtoAssembler.toDTO(endereco);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public EnderecoDTO adicionar(@RequestBody @Valid EnderecoDtoInput enderecoDtoInput) {

    try {
      Endereco endereco = enderecoDtoDisassembler.toDomainObject(enderecoDtoInput);
      endereco = cadastroEndereco.salvar(endereco);

      return enderecoDtoAssembler.toDTO(endereco);
    } catch (EnderecoNaoEncontradoException e) {
      throw new NegocioException(e.getMessage(), e);
    }
  }

  @PutMapping("/{enderecoId}")
	public EnderecoDTO atualizarEnderecoPrincipal(@PathVariable Long enderecoId, @RequestBody @Valid EnderecoPrincipalDtoInput enderecoPrincipalDtoInput) {
		try {
			Endereco enderecoAtual = cadastroEndereco.buscarOuFalhar(enderecoId);
			
			enderecoDtoDisassembler.copyToDomainObjectMudarEndereco(enderecoPrincipalDtoInput, enderecoAtual);
      enderecoAtual = cadastroEndereco.salvar(enderecoAtual);
			
			return enderecoDtoAssembler.toDTO(enderecoAtual);
		} catch (PessoaNaoEncontradaException e) {
			throw new NegocioException(e.getMessage());
		}
	}
}
