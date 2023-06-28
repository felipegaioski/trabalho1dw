package com.dw.futebol.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dw.futebol.model.Jogador;

public interface JogadorRepository extends JpaRepository<Jogador, Long> {

    List<Jogador> findByIdJogador(long idJogador);

}
