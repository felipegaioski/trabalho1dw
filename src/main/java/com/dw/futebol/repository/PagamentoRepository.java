package com.dw.futebol.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dw.futebol.model.Jogador;
import com.dw.futebol.model.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

    List<Pagamento> findByIdJogador(Jogador idJogador);

}
