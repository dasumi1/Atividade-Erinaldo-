package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o tipo de material que deseja buscar: ");
        String tipoMaterial = sc.nextLine();

        LinkedList<PontoColeta> pontos = new LinkedList<>();
        String path = "pontos_de_descartes.txt";

        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha; //var que armazena cada linha do arquivo
        while ((linha = buffRead.readLine()) != null) { //lê linhas do arquivo até readLine() chegar no fim do arq (null)
            String[] dados = linha.split(";"); //divide os dados de cada linha usando ; como delimitador (cada linha se torna um vetor)
            if (dados[1].contains(tipoMaterial)) { //comapara o campo material [1] de cada linha com o texto inserido para busca
                pontos.add(new PontoColeta(Integer.parseInt(dados[0]), dados[1], dados[2])); //add na linkedlist
            }
            linha = buffRead.readLine();
        }
        buffRead.close();

        System.out.println("\nPontos de coleta: ");
        pontos.forEach(System.out::println); //printa todas as linhas correspondentes a busca
    }
}