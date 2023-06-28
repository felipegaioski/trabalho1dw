package com.dw.futebol.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dw.futebol.model.Jogador;
import com.dw.futebol.repository.JogadorRepository;

@RestController
@RequestMapping("/api/jogador")
public class JogadorController {

    @Autowired
    JogadorRepository rep;

    @PostMapping("/")
    public ResponseEntity<Jogador> createJogador(@RequestBody Jogador jog) {
        try {
            Jogador _jogador = rep.save(new Jogador(jog.getNome(), jog.getEmail(),
                    jog.getDatanasc()));

            return new ResponseEntity<>(_jogador, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Jogador>> listJogadores() {
        try {
            List<Jogador> jogadores = new ArrayList<Jogador>();

            rep.findAll().forEach(jogadores::add);

            if (jogadores.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(jogadores, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}