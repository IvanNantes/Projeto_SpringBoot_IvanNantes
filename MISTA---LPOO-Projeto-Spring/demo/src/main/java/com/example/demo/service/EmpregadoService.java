package com.example.demo.service;

import com.example.demo.model.Aventureiro;
import com.example.demo.model.Empregado;
import com.example.demo.repository.EmpregadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpregadoService implements PessoaService<Empregado> {

    @Autowired
    EmpregadoRepository empregadoRepository;

    @Override
    public List<Empregado> listar() {
        return empregadoRepository.findAll();
    }

    @Override
    public Empregado criar(Empregado empregado) {
        return empregadoRepository.save(empregado);
    }

    @Override
    public Empregado atualizar(Empregado empregado, Long na) {
        if(verificaNA(na)) {

            empregado.setNa(na);
            return empregadoRepository.save(empregado);
        }
        return null;
    }

    private boolean verificaNA(Long na) {
        if(empregadoRepository.existsById(na)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deletar(Long na) {
        if(verificaNA(na)) {
            empregadoRepository.deleteById(na);
            return true;
        } else {
            return false;
        }
    }

    public int qtdEmpregados() {
        return empregadoRepository.findAll().size();
    }

    public Optional<Empregado> buscaPorNA(Long na) {
        return empregadoRepository.findById(na);
    }

    public List<Empregado> buscaPorSexo(String sexo) {
        return empregadoRepository.findBySexo(sexo);
    }

    public List<Empregado> buscaPorNome(String nome) {
        return empregadoRepository.findByNome(nome);
    }
}
