package org.example;
import java.util.LinkedList;
import java.util.List;

public class PontoColeta {
    private int id;
    private String tipo;
    private String endereco;

    public PontoColeta(int id, String tipo, String endereco) {
        this.id = id;
        this.tipo = tipo;
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getEndereco() {
        return endereco;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | " + tipo + " | " + endereco;
    }
}


