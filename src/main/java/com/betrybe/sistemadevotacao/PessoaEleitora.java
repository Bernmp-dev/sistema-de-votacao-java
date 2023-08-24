package com.betrybe.sistemadevotacao;

/** PessoaEleitora. */
public class PessoaEleitora extends Pessoa {
  private String cpf;

  /** Construtor. */
  public PessoaEleitora(String nome, String cpf) {
    super();
    super.nome = nome;
    this.cpf = cpf;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }
}
