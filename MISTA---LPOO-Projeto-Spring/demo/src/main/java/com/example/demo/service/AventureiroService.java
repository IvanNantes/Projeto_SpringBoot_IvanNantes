package com.example.demo.service;

import com.example.demo.model.Aventureiro;
import com.example.demo.model.Empregado;
import com.example.demo.repository.AventureiroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AventureiroService implements PessoaService<Aventureiro>{

    @Autowired
    AventureiroRepository aventureiroRepository;

    @Override
    public List<Aventureiro> listar() {
        return aventureiroRepository.findAll();
    }

    @Override
    public Aventureiro criar(Aventureiro aventureiro) {
        return aventureiroRepository.save(aventureiro);
    }

    @Override
    public Aventureiro atualizar(Aventureiro aventureiro, Long na) {
        if(verificaNA(na)) {

            aventureiro.setNa(na);
            return aventureiroRepository.save(aventureiro);
        }
        return null;
    }

    private boolean verificaNA(Long na) {
        return aventureiroRepository.existsById(na);
    }

    @Override
    public boolean deletar(Long na) {
        if(verificaNA(na)) {
            aventureiroRepository.deleteById(na);
            return true;
        } else {
            return false;
        }
    }

    public int qtdAventureiros() {
        return aventureiroRepository.findAll().size();
    }

    public Optional<Aventureiro> buscaPorNA(Long na) {
        return aventureiroRepository.findById(na);
    }

    public List<Aventureiro> buscaPorSexo(String sexo) {
        return aventureiroRepository.findBySexo(sexo);
    }

    public List<Aventureiro> buscaPorNome(String nome) {
        return aventureiroRepository.findByNome(nome);
    }
}

