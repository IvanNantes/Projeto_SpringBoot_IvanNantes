package com.example.demo.controller;

import com.example.demo.model.Aventureiro;
import com.example.demo.service.AventureiroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aventureiros")
public class AventureiroController {

    @Autowired
    AventureiroService aventureiroService;

    @GetMapping
    public List<Aventureiro> listarAventureiros() {
        return aventureiroService.listar();
    }

    @PostMapping
    public Aventureiro criar(@Valid @RequestBody Aventureiro aventureiro) {
        return aventureiroService.criar(aventureiro);
    }

    @PutMapping("/{na}")
    public ResponseEntity<?> atualizar(@RequestBody Aventureiro aventureiro, @PathVariable Long na) {

        if (aventureiroService.atualizar(aventureiro, na) == null) {

            String mensagem = "O aventureiro com o Número Astral informado não foi encontrado";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        } else {

            return ResponseEntity.ok(aventureiro);
        }
    }

    @DeleteMapping("/{na}")
    public ResponseEntity<?> deletar(@PathVariable Long na) {
        if (aventureiroService.deletar(na)) {
            String mensagem = "O aventureiro com o Número Astral " + na + " foi removido com sucesso.";
            return ResponseEntity.status(HttpStatus.OK).body(mensagem);
        } else {
            String mensagem = "O aventureiro com o Número Astral informado não foi encontrado";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        }
    }

    @GetMapping("/qtd")
    public int qtdAventureiros() {
        return aventureiroService.qtdAventureiros();
    }

    @GetMapping("/{na}")
    public Optional<Aventureiro> buscarPorNA(@PathVariable Long na) {
        return aventureiroService.buscaPorNA(na);
    }

    @GetMapping("/sexo/{sexo}")
    public ResponseEntity<?> buscarPorSexo(@PathVariable String sexo) {
        switch (sexo) {
            case "M":
                if (aventureiroService.buscaPorSexo(sexo).isEmpty()) {
                    String mensagem = "Nenhum Aventureiro (Masculino) Encontrado";
                    mensagem += " " + aventureiroService.buscaPorSexo(sexo).toString();
                    return ResponseEntity.status(HttpStatus.OK).body(mensagem);
                }
                return ResponseEntity.status(HttpStatus.OK).body(aventureiroService.buscaPorSexo(sexo));
            case "F":
                if (aventureiroService.buscaPorSexo(sexo).isEmpty()) {
                    String mensagem = "Nenhuma Aventureira (Feminino) Encontrada";
                    return ResponseEntity.status(HttpStatus.OK).body(mensagem);
                }
                return ResponseEntity.status(HttpStatus.OK).body(aventureiroService.buscaPorSexo(sexo));
            case "O":
                if (aventureiroService.buscaPorSexo(sexo).isEmpty()) {
                    String mensagem = "Nenhum Aventureiro (Outro) Encontrado";
                    return ResponseEntity.status(HttpStatus.OK).body(mensagem);
                }
                return ResponseEntity.status(HttpStatus.OK).body(aventureiroService.buscaPorSexo(sexo));
            default:
                String mensagem = "Sexo Inválido. Tente utilizar M, F ou O";
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        }
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<?> buscarPorNome(@PathVariable String nome) {
        if (aventureiroService.buscaPorNome(nome).isEmpty()) {
            String mensagem = "Aventureiro com o nome " + nome + " não encontrado";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(aventureiroService.buscaPorNome(nome));
        }
    }
}
