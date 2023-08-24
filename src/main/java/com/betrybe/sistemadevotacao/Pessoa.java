package com.betrybe.sistemadevotacao;

/** Pessoa abstract. */
public abstract class Pessoa {
  protected String nome;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
}
