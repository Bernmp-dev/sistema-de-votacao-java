package com.betrybe.sistemadevotacao;

import java.util.ArrayList;

/** GerenciamentoVotacao Concrete Class. */
public class GerenciamentoVotacao implements GerenciamentoVotacaoInterface {
  private final ArrayList<PessoaCandidata> pessoasCandidatas = new ArrayList<>();
  private final ArrayList<PessoaEleitora> pessoasEleitoras = new ArrayList<>();
  private final ArrayList<PessoaEleitora> cpfsComputados = new ArrayList<>();

  @Override
  public void cadastrarPessoaCandidata(String nome, int numero) {
    boolean numeroJaUsado = pessoasCandidatas.stream()
        .anyMatch(pessoa -> pessoa.getNumero() == numero);

    if (numeroJaUsado) {
      System.out.println("Número da pessoa candidata já utilizado!");
    } else {
      PessoaCandidata novaPessoaCandidata = new PessoaCandidata(nome, numero);
      pessoasCandidatas.add(novaPessoaCandidata);
    }
  }

  @Override
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    boolean cpfJaCadastrado = pessoasEleitoras.stream()
        .anyMatch(pessoa -> pessoa.getCpf().equals(cpf));

    if (cpfJaCadastrado) {
      System.out.println("Pessoa eleitora já cadastrada!");
    } else {
      PessoaEleitora novaPessoaEleitora = new PessoaEleitora(nome, cpf);
      pessoasEleitoras.add(novaPessoaEleitora);
    }
  }


  @Override
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {

  }

  @Override
  public void mostrarResultado() {

  }
}
