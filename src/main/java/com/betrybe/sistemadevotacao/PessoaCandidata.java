package com.betrybe.sistemadevotacao;

/** Pessoa Candidata. */
public class PessoaCandidata extends Pessoa {
  private int votos;
  private int numero;

  /** Constructor. */
  public PessoaCandidata(String nome, int numero) {
    super();
    super.nome = nome;
    this.numero = numero;
    this.votos = 0;
  }

  public int getVotos() {
    return votos;
  }

  public void setVotos(int votos) {
    this.votos = votos;
  }


  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public void receberVoto() {
    setVotos(1);
  }
}
