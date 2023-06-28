package com.dw.futebol.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pagamento")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_pagamento")
    private long idPagamento;

    @Column(length = 60, columnDefinition = "SMALLINT")
    private int ano;

    @Column(length = 60, columnDefinition = "SMALLINT")
    private int mes;

    @Column(length = 60, columnDefinition = "NUMERIC")
    private float valor;

    @ManyToOne
    @JoinColumn(name = "cod_jogador")
    private Jogador idJogador;

    public Pagamento(int ano, int mes, float valor, Jogador idJogador){
        this.ano = ano;
        this.mes = mes;
        this.valor = valor;
        this.idJogador = idJogador;
    }

    public Jogador getIdPagamento() {
        return idJogador;
    }

    public void setIdPagamento(long idPagamento) {
        this.idPagamento = idPagamento;
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

    public Jogador getIdJogador() {
        return idJogador;
    }

    public void setIdJogador(Jogador idJogador) {
        this.idJogador = idJogador;
    }

    @Override
    public String toString(){
        return "Pagamento{ id=" + idPagamento + " ano=" + ano + " mes=" + mes + " valor=" + valor + " jogador=" + idJogador + "}";
    }
}
