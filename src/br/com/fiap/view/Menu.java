package br.com.fiap.view;

import br.com.fiap.dao.AtletaDAO;
import br.com.fiap.dao.TimeDAO;
import br.com.fiap.dao.TreinadorDAO;
import br.com.fiap.model.Atleta;

import java.util.Scanner;

public class Menu {

    private AtletaDAO atletaDAO = new AtletaDAO();
    private TreinadorDAO treinadorDAO = new TreinadorDAO();
    private TimeDAO timeDAO = new TimeDAO();

    private Scanner scanner = new Scanner(System.in);

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n=== SISTEMA DE GERENCIAMENTO DE BASQUETE ===");
            System.out.println("1. Gerenciar Atletas");
            System.out.println("2. Gerenciar Treinadores");
            System.out.println("3. Gerenciar Times");
            System.out.println("0. Sair");

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch(opcao) {
                case 1:
                    gerenciarAtletas();
                    break;
                case 2:
                    gerenciarTreinadores();
                    break;
                case 3:
                    gerenciarTimes();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while(opcao != 0);
    }

    private void gerenciarAtletas() {
        int opcao;
        do {
            System.out.println("\n=== GERENCIAR ATLETAS ===");
            System.out.println("1. Cadastrar Atleta");
            System.out.println("2. Listar Atletas");
            System.out.println("3. Buscar Atleta por Código");
            System.out.println("4. Editar Atleta");
            System.out.println("5. Remover Atleta");
            System.out.println("0. Voltar");

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch(opcao) {
                case 1:
                    cadastrarAtleta();
                    break;
                case 2:
                    listarAtletas();
                    break;
                case 3:
                    buscarAtletaPorCodigo();
                    break;
                case 4:
                    editarAtleta();
                    break;
                case 5:
                    removerAtleta();
                    break;
            }
        } while(opcao != 0);
    }

    private void cadastrarAtleta() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Posição: ");
        String posicao = scanner.nextLine();

        Atleta atleta = new Atleta(nome, idade, posicao);
        atletaDAO.cadastrar(atleta);

        System.out.println("Atleta cadastrado!");
    }

}

