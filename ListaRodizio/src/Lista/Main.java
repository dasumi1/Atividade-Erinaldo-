package Lista;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        GerenciadorRodizio gerenciador = new GerenciadorRodizio();

        System.out.println("Escolha uma opção: ");
        System.out.println("1 - Filtrar por final de placa");
        System.out.println("2 - Filtrar por dia da semana");

        int opcao = scanner.nextInt();
        scanner.nextLine();

        if (opcao == 1 || opcao == 2) {
            if (opcao == 1) {
                System.out.println("Digite o final da placa: ");
            } else {
                System.out.println("Digite o dia da semana: ");
            }

            String filtro = scanner.nextLine();
            gerenciador.carregarDados("rodizio_de_veiculos.txt", filtro, opcao == 1);

            List<Rodizio> veiculos = gerenciador.getVeiculos();
            if (veiculos.isEmpty()) {
                System.out.println("Nenhum veículo encontrado.");
            } else {
                System.out.println("Veículos encontrados:");
                for (Rodizio veiculo : veiculos) {
                    System.out.println(veiculo);
                }
            }
        } else {
            System.out.println("Opção inválida.");
        }

        scanner.close();
    }
}