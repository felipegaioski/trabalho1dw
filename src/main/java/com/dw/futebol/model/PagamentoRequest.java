package com.dw.futebol.model;

public class PagamentoRequest {
    private int ano;
    private int mes;
    private float valor;
    private long idJogador;

    public PagamentoRequest(int ano, int mes, float valor, long idJogador) {
        this.ano = ano;
        this.mes = mes;
        this.valor = valor;
        this.idJogador = idJogador;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public long getIdJogador() {
        return idJogador;
    }

    public void setIdJogador(long idJogador) {
        this.idJogador = idJogador;
    }
}