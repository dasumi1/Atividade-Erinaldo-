package org.example;

public class Rotas {
    private String id;
    private String nomeLinha;
    private String tipoTransporte;
    private String regiao;
    private Rotas proximo;
    private Rotas anterior;

    public Rotas(String id, String nomeLinha, String tipoTransporte, String regiao) {
        this.id = id;
        this.nomeLinha = nomeLinha;
        this.tipoTransporte = tipoTransporte;
        this.regiao = regiao;
        this.proximo = null;
        this.anterior = null;
    }

    public String getId() {
        return id;
    }

    public String getNomeLinha() {
        return nomeLinha;
    }

    public String getTipoTransporte() {
        return tipoTransporte;
    }

    public String getRegiao() {
        return regiao;
    }

    public Rotas getProximo() {
        return proximo;
    }

    public Rotas getAnterior() {
        return anterior;
    }

    public void setProximo(Rotas proximo) {
        this.proximo = proximo;
    }

    public void setAnterior(Rotas anterior) {
        this.anterior = anterior;
    }
}

