package com.betrybe.sistemadevotacao;

import java.util.Scanner;

/** Principal. */
public class Principal {
  private static final Scanner scanner = new Scanner(System.in);
  private static final GerenciamentoVotacao gv = new GerenciamentoVotacao();

  private static final String MENU_CADASTRO_CANDIDATO = """
        Cadastrar pessoa candidata?
        1 - Sim
        2 - Não
        Entre com o número correspondente à opção desejada:
        """;

  private static final String MENU_CADASTRO_ELEITOR = """
        Cadastrar pessoa eleitora?
        1 - Sim
        2 - Não
        Entre com o número correspondente à opção desejada:
        """;

  private static final String MENU_VOTACAO = """
        Entre com o número correspondente à opção desejada:
        1 - Votar
        2 - Resultado Parcial
        3 - Finalizar Votação
        """;

  /** Main. */
  public static void main(String[] args) {
    while (desejaCadastrarCandidato()) {
      cadastrarCandidato();
    }

    while (desejaCadastrarEleitor()) {
      cadastrarEleitor();
    }

    while (true) {
      int opcao = Integer.parseInt(obterInput(MENU_VOTACAO));

      switch (opcao) {
        case 1 -> votar();
        case 2 -> gv.mostrarResultado();
        case 3 -> {
          gv.mostrarResultado();
          return;
        }
        default -> System.out.println("Opção inválida.");
      }
    }
  }

  private static boolean desejaCadastrarCandidato() {
    return desejaContinuar(MENU_CADASTRO_CANDIDATO);
  }

  private static boolean desejaCadastrarEleitor() {
    return desejaContinuar(MENU_CADASTRO_ELEITOR);
  }

  private static boolean desejaContinuar(String menu) {
    System.out.print(menu);
    int valorDeEntrada = Integer.parseInt(scanner.nextLine());
    return valorDeEntrada == 1;
  }

  private static void cadastrarCandidato() {
    String nomeDoCandidato = obterInput("Entre com o nome da pessoa candidata:");
    int numeroDoCandidato = Integer.parseInt(obterInput("Entre com o número da pessoa candidata:"));
    gv.cadastrarPessoaCandidata(nomeDoCandidato, numeroDoCandidato);
  }

  private static void cadastrarEleitor() {
    String nomeDoEleitor = obterInput("Entre com o nome da pessoa eleitora:");
    String cpfDoEleitor = obterInput("Entre com o cpf da pessoa eleitora:");
    gv.cadastrarPessoaEleitora(nomeDoEleitor, cpfDoEleitor);
  }

  private static void votar() {
    String cpfDoEleitor = obterInput("Entre com o cpf da pessoa eleitora:");
    int numeroDoCandidato = Integer.parseInt(obterInput("Entre com o número da pessoa candidata:"));
    gv.votar(cpfDoEleitor, numeroDoCandidato);
  }

  private static String obterInput(String mensagem) {
    System.out.println(mensagem);
    return scanner.nextLine();
  }
}
