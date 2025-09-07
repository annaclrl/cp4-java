package br.com.fiap.view;

import br.com.fiap.dao.AtletaDAO;
import br.com.fiap.dao.TimeDAO;
import br.com.fiap.dao.TreinadorDAO;
import br.com.fiap.model.Atleta;
import br.com.fiap.model.Time;
import br.com.fiap.model.Treinador;

import java.util.Map;
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

    private void gerenciarTimes() {
        int opcao;
        do {
            System.out.println("\n=== GERENCIAR TIMES ===");
            System.out.println("1. Cadastrar Time");
            System.out.println("2. Listar Times");
            System.out.println("3. Buscar Time por Código");
            System.out.println("4. Editar Time");
            System.out.println("5. Remover Time");
            System.out.println("6. Adicionar Atleta ao Time");
            System.out.println("7. Associar Treinador ao Time");
            System.out.println("0. Voltar");

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch(opcao) {
                case 1:
                    cadastrarTime();
                    break;
                case 2:
                    listarTimes();
                    break;
                case 3:
                    buscarTimePorCodigo();
                    break;
                case 4:
                    editarTime();
                    break;
                case 5:
                    removerTime();
                    break;
                case 6:
                    adicionarAtletaAoTime();
                    break;
                case 7:
                    associarTreinadorAoTime();
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while(opcao != 0);
    }

    private void cadastrarTime() {
        System.out.print("Nome do time: ");
        String nome = scanner.nextLine();
        Time time = new Time(nome);
        timeDAO.cadastrar(time);
        System.out.println("Time '" + nome + "' cadastrado com sucesso!");
    }

    private void listarTimes() {
        Map<Integer, Time> times = timeDAO.listar();
        if (times.isEmpty()) {
            System.out.println("Nenhum time cadastrado.");
        } else {
            for (Map.Entry<Integer, Time> entry : times.entrySet()) {
                System.out.println("---");
                System.out.println("Código: " + entry.getKey());
                System.out.println(entry.getValue().exibeInformacoes());
            }
            System.out.println("---");
        }
    }

    private void buscarTimePorCodigo() {
        System.out.print("Código do time: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        Time time = timeDAO.pesquisarPorCodigo(codigo);
        if (time != null) {
            System.out.println(time.exibeInformacoes());
        } else {
            System.out.println("Time não encontrado!");
        }
    }

    private void editarTime() {
        System.out.print("Código do time a ser editado: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        Time timeExistente = timeDAO.pesquisarPorCodigo(codigo);
        if (timeExistente != null) {
            System.out.print("Novo nome do time: ");
            String novoNome = scanner.nextLine();

            Time timeAtualizado = new Time(novoNome);
            timeAtualizado.setTreinador(timeExistente.getTreinador());
            for (Atleta atleta : timeExistente.getAtletas()) {
                timeAtualizado.addAtleta(atleta);
            }

            timeDAO.editar(codigo, timeAtualizado);
            System.out.println("Time atualizado com sucesso!");
        } else {
            System.out.println("Time não encontrado!");
        }
    }

    private void removerTime() {
        System.out.print("Código do time a ser removido: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();
        timeDAO.remover(codigo);
        System.out.println("Time removido com sucesso!");
    }

    private void adicionarAtletaAoTime() {
        System.out.print("Código do time: ");
        int codigoTime = scanner.nextInt();
        scanner.nextLine();

        Time time = timeDAO.pesquisarPorCodigo(codigoTime);

        if (time != null) {
            System.out.print("Código do atleta: ");
            int codigoAtleta = scanner.nextInt();
            scanner.nextLine();

            Atleta atleta = atletaDAO.pesquisarPorCodigo(codigoAtleta);
            if (atleta != null) {
                if (atleta.getTime() == null) {
                    time.addAtleta(atleta);
                    System.out.println("Atleta adicionado ao time com sucesso!");
                } else {
                    System.out.println("Este atleta já pertence a um time.");
                }
            } else {
                System.out.println("Atleta não encontrado!");
            }
        } else {
            System.out.println("Time não encontrado!");
        }
    }

    private void associarTreinadorAoTime() {
        System.out.print("Código do time: ");
        int codigoTime = scanner.nextInt();
        scanner.nextLine();

        Time time = timeDAO.pesquisarPorCodigo(codigoTime);

        if (time != null) {
            System.out.print("Código do treinador: ");
            int codigoTreinador = scanner.nextInt();
            scanner.nextLine();

            Treinador treinador = treinadorDAO.pesquisarPorCodigo(codigoTreinador);
            if (treinador != null) {
                if (treinador.getTime() == null) {
                    time.setTreinador(treinador);
                    System.out.println("Treinador associado ao time com sucesso!");
                } else {
                    System.out.println("Este treinador já comanda um time.");
                }
            } else {
                System.out.println("Treinador não encontrado!");
            }
        } else {
            System.out.println("Time não encontrado!");
        }
    }

    private void gerenciarTreinadores() {
        // ... (lógica de gerenciamento de treinadores, se necessário)
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

    private void listarAtletas() {
        Map<Integer, Atleta> atletas = atletaDAO.listar();
        if(atletas.isEmpty())
            System.out.println("Nenhum atleta cadastrado.");
        else for(Map.Entry<Integer, Atleta> entry : atletas.entrySet())
            System.out.println("Código: " + entry.getKey() + " - " + entry.getValue().exibeInformacoes());
    }

    private void buscarAtletaPorCodigo() {
        System.out.print("Código do atleta: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        Atleta atleta = atletaDAO.pesquisarPorCodigo(codigo);
        if(atleta != null)
            System.out.println(atleta.exibeInformacoes());
        else System.out.println("Atleta não encontrado!");
    }

    private void editarAtleta() {
        System.out.print("Código do atleta: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        Atleta existente = atletaDAO.pesquisarPorCodigo(codigo);
        if(existente != null) {
            System.out.print("Novo nome: ");
            String nome = scanner.nextLine();

            System.out.print("Nova idade: ");
            int idade = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Nova posição: ");
            String posicao = scanner.nextLine();

            Atleta atualizado = new Atleta(nome, idade, posicao);
            atualizado.setTime(existente.getTime());
            atletaDAO.editar(codigo, atualizado);

            System.out.println("Atleta atualizado!");
        } else System.out.println("Atleta não encontrado!");
    }

    private void removerAtleta() {
        System.out.print("Código do atleta: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        atletaDAO.remover(codigo);
        System.out.println("Atleta removido!");
    }
}