package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GerenciadorRotas {
    private Rotas inicio;
    private Rotas fim;

    public GerenciadorRotas() { //construtor que inicializa a cabeça e o fim da lista como null
        this.inicio = null;
        this.fim = null;
    }

    public void carregarRotasDeArquivos(String nomeArquivo, String filtro, boolean porTipo) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(nomeArquivo));
        String linha;

        while ((linha = br.readLine()) != null) {
            String[] dados = linha.split(";");
            if (dados.length == 4) {
                String id = dados[0];
                String nomeLinha = dados[1];
                String tipoTransporte = dados[2];
                String regiao = dados[3];

                if ((porTipo && tipoTransporte.equalsIgnoreCase(filtro)) ||
                        (!porTipo && regiao.equalsIgnoreCase(filtro))) {
                    inserirNaLista(id, nomeLinha, tipoTransporte, regiao);
                }
            }
        }
        br.close();
    }

    public void inserirNaLista(String id, String nomeLinha, String tipoTransporte, String regiao) {
        Rotas novo = new Rotas(id, nomeLinha, tipoTransporte, regiao);

        if (inicio == null) {
            inicio = novo;
            fim = novo;
        } else {
            fim.setProximo(novo);
            novo.setAnterior(fim);
            fim = novo;
        }
    }

    public void exibirListaOrdem() {
        if (inicio == null) {
            System.out.println("Nenhuma rota encontrada.");
            return;
        }

        System.out.println("\nRotas na ordem normal:");
        Rotas atual = inicio;
        while (atual != null) {
            System.out.println("ID: " + atual.getId());
            System.out.println("Linha: " + atual.getNomeLinha());
            System.out.println("Tipo: " + atual.getTipoTransporte());
            System.out.println("Região: " + atual.getRegiao() + "\n");
            atual = atual.getProximo();
        }
    }

    public void exibirListaEmOrdemInversa() {
        if (fim == null) {
            System.out.println("Nenhuma rota encontrada.");
            return;
        }

        System.out.println("\nRotas na ordem inversa:");
        Rotas atual = fim;
        while (atual != null) {
            System.out.println("ID: " + atual.getId());
            System.out.println("Linha: " + atual.getNomeLinha());
            System.out.println("Tipo: " + atual.getTipoTransporte());
            System.out.println("Região: " + atual.getRegiao() + "\n");
            atual = atual.getAnterior();
        }
    }

    public void liberarLista() {
        Rotas atual = inicio;
        while (atual != null) {
            Rotas proximo = atual.getProximo();
            atual.setProximo(null);
            atual.setAnterior(null);
            atual = proximo;
        }
        inicio = null;
        fim = null;
    }
}