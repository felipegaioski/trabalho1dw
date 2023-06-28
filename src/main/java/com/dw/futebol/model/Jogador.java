package com.dw.futebol.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "jogador")
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_jogador")
    private long idJogador;

    @Column(length = 60, columnDefinition = "VARCHAR")
    private String nome;

    @Column(length = 60, columnDefinition = "VARCHAR")
    private String email;

    @Column(length = 60, columnDefinition = "DATE")
    private Date datanasc;

    public Jogador() {

	}

    public Jogador(String nome, String email, Date datanasc){
        this.nome = nome;
        this.email = email;
        this.datanasc = datanasc;
    }

    public long getIdJogador() {
        return idJogador;
    }

    public void setIdJogador(long idJogador) {
        this.idJogador = idJogador;
    }

    public String getNome(){
        return nome;
    }

    public String getEmail(){
        return email;
    }

    public Date getDatanasc(){
        return datanasc;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setDatanasc(Date datanasc){
        this.datanasc = datanasc;
    }

    @Override
    public String toString(){
        return "Jogador{ id=" + idJogador + " nome=" + nome + " email=" + email + " datanasc=" + datanasc + "}";
    }
}
