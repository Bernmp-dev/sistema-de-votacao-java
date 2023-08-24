package com.betrybe.sistemadevotacao;

import java.util.ArrayList;

/** GerenciamentoVotacao Concrete Class. */
public class GerenciamentoVotacao implements GerenciamentoVotacaoInterface {
  private final ArrayList<PessoaCandidata> pessoasCandidatas = new ArrayList<>();
  private final ArrayList<PessoaEleitora> pessoasEleitoras = new ArrayList<>();
  private final ArrayList<String>   cpfsComputados = new ArrayList<>();

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
    boolean jaVotou = cpfsComputados.contains(cpfPessoaEleitora);

    if (jaVotou) {
      System.out.println("Pessoa eleitora já votou!");
      return;
    }

    PessoaCandidata cadidatoEscolhido = pessoasCandidatas.stream()
        .filter(candidata -> candidata.getNumero() == numeroPessoaCandidata)
        .findFirst()
        .orElse(null);

    if (cadidatoEscolhido == null) {
      System.out.println("Número da pessoa candidata não encontrado!");
    } else {
      cadidatoEscolhido.receberVoto();
      cpfsComputados.add(cpfPessoaEleitora);
    }
  }

  @Override
  public void mostrarResultado() {
    int totalDeVotos = 0;

    for (PessoaCandidata candidata : pessoasCandidatas) {
      totalDeVotos += candidata.getVotos();
    }

    for (PessoaCandidata candidata : pessoasCandidatas) {
      double porcentagemDouble = (double) candidata.getVotos() / totalDeVotos * 100;
      int percentual = (int) Math.round(porcentagemDouble);
      System.out.printf(
          "Nome: %s - %d votos ( %d%% )%n",
          candidata.getNome(), candidata.getVotos(), percentual);
    }

    System.out.println("Total de votos: " + totalDeVotos);
  }

}
