package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GerenciadorRotas gerenciador = new GerenciadorRotas();
        int opcao;
        String filtro;

        System.out.println("Escolha o critério de filtro:");
        System.out.println("1 - Filtrar por tipo de transporte");
        System.out.println("2 - Filtrar por região");
        System.out.print("Opção: ");
        opcao = sc.nextInt();
        sc.nextLine();

        System.out.print("Digite o valor para filtro (ex: Metro, Onibus, Centro, Zona Sul): ");
        filtro = sc.nextLine();

        try {
            switch (opcao) {
                case 1:
                    gerenciador.carregarRotasDeArquivos("rotas_de_transporte.txt", filtro, true);
                    break;
                case 2:
                    gerenciador.carregarRotasDeArquivos("rotas_de_transporte.txt", filtro, false);
                    break;
                default:
                    System.out.println("Opção inválida!");
                    sc.close();
                    return;
            }

            gerenciador.exibirListaOrdem();
            System.out.println("------------------------------------------------------------------------------");
            gerenciador.exibirListaEmOrdemInversa();
            gerenciador.liberarLista();

        } catch (IOException e) {
            System.out.println("Erro ao processar o arquivo: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}