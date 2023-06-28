package com.dw.futebol.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dw.futebol.model.Jogador;
import com.dw.futebol.model.Pagamento;
import com.dw.futebol.repository.JogadorRepository;
import com.dw.futebol.repository.PagamentoRepository;
import com.dw.futebol.model.PagamentoRequest;

@RestController
@RequestMapping("/api/pagamento")
public class PagamentoController {

    @Autowired
    PagamentoRepository rep;

    @Autowired
    JogadorRepository jogadorRep;

    @PostMapping("/")
    public ResponseEntity<Pagamento> createPagamento(@RequestBody PagamentoRequest pag) {
        try {

            List<Jogador> _jogador = jogadorRep.findByIdJogador(pag.getIdJogador());

            if (_jogador == null)
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

            Jogador jog = _jogador.get(0);

            Pagamento _pagamento = rep.save(new Pagamento(pag.getAno(), pag.getMes(), pag.getValor(), jog));

            return new ResponseEntity<>(_pagamento, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Pagamento>> listPagamento() {
        try {
            List<Pagamento> pagamentos = new ArrayList<Pagamento>();

            rep.findAll().forEach(pagamentos::add);

            if (pagamentos.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(pagamentos, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{codJogador}")
    @ResponseBody
    public ResponseEntity<List<Pagamento>> getPagamentoByEmail(@PathVariable("codJogador") long codJogador) {
        try {
            System.out.println(codJogador);
            List<Jogador> _jogador = jogadorRep.findByIdJogador(codJogador);
            System.out.println(_jogador);

            if (_jogador.isEmpty())
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

            Jogador jog = _jogador.get(0);

            List<Pagamento> pagamentos = new ArrayList<Pagamento>();

            rep.findByIdJogador(jog).forEach(pagamentos::add);

            if (pagamentos.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(pagamentos, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}