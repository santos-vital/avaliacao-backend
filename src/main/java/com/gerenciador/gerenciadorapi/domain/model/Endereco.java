package com.gerenciador.gerenciadorapi.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Endereco {

  @EqualsAndHashCode.Include
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(name = "endereco_logradouro")
  private String logradouro;

  @Column(name = "endereco_cep")
  private String cep;
  
  @Column(name = "endereco_numero")
  private String numero;

  @Column(name = "endereco_cidade")
  private String cidade;

  @Column(name = "endereco_principal")
  private Boolean enderecoPrincipal = false;

  @ManyToOne
  @JoinColumn(name = "pessoa_id", nullable = false)
  private Pessoa pessoa;
}
