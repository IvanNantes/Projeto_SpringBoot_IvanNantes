package com.example.demo.controller;


import com.example.demo.model.Empregado;
import com.example.demo.service.EmpregadoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empregados")
public class EmpregadoController {

    @Autowired
    EmpregadoService empregadoService;

    @GetMapping
    public List<Empregado> listarEmpregados() {
        return empregadoService.listar();
    }

    @PostMapping
    public Empregado criar(@Valid @RequestBody Empregado empregado) {
        return empregadoService.criar(empregado);
    }

    @PutMapping("/{na}")
    public ResponseEntity<?> atualizar(@RequestBody Empregado empregado, @PathVariable Long na) {

        if(empregadoService.atualizar(empregado, na) == null) {

            String mensagem = "O empregado com o Número Astral informado não foi encontrado";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        } else {

            return ResponseEntity.ok(empregado);
        }
    }

    @DeleteMapping("/{na}")
    public ResponseEntity<?> deletar(@PathVariable Long na) {
        if(empregadoService.deletar(na)) {
            String mensagem = "O empregado com o Número Astral " + na + " foi removido com sucesso.";
            return ResponseEntity.status(HttpStatus.OK).body(mensagem);
        } else {
            String mensagem = "O empregado com o Número Astral informado não foi encontrado";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        }
    }

    @GetMapping("/qtd")
    public int qtdEmpregados() {
        return empregadoService.qtdEmpregados();
    }

    @GetMapping("/{na}")
    public Optional<Empregado> buscarPorNA(@PathVariable Long na) {
        return empregadoService.buscaPorNA(na);
    }

    @GetMapping("/sexo/{sexo}")
    public ResponseEntity<?> buscarPorSexo(@PathVariable String sexo) {
        switch (sexo){
            case "M":
                if(empregadoService.buscaPorSexo(sexo).isEmpty()){
                    String mensagem = "Nenhum Empregado (Masculino) Encontrado";
                    mensagem += " " + empregadoService.buscaPorSexo(sexo).toString();
                    return ResponseEntity.status(HttpStatus.OK).body(mensagem);
                }
                return ResponseEntity.status(HttpStatus.OK).body(empregadoService.buscaPorSexo(sexo));
            case "F":
                if(empregadoService.buscaPorSexo(sexo).isEmpty()){
                    String mensagem = "Nenhuma Empregada (Feminino) Encontrada";
                    return ResponseEntity.status(HttpStatus.OK).body(mensagem);
                }
                return ResponseEntity.status(HttpStatus.OK).body(empregadoService.buscaPorSexo(sexo));
            case "O":
                if(empregadoService.buscaPorSexo(sexo).isEmpty()){
                    String mensagem = "Nenhum Empregado (Outro) Encontrado";
                    return ResponseEntity.status(HttpStatus.OK).body(mensagem);
                }
                return ResponseEntity.status(HttpStatus.OK).body(empregadoService.buscaPorSexo(sexo));
            default:
                String mensagem = "Sexo Inválido. Tente utilizar M, F ou O";
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        }
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<?> buscarPorNome(@PathVariable String nome) {
        if(empregadoService.buscaPorNome(nome).isEmpty()){
            String mensagem = "Empregado com o nome " + nome + " não encontrado";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(empregadoService.buscaPorNome(nome));
        }
    }


}
