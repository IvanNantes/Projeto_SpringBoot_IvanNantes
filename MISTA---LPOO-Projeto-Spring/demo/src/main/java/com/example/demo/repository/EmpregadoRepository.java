package com.example.demo.repository;


import com.example.demo.model.Aventureiro;
import com.example.demo.model.Empregado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmpregadoRepository extends JpaRepository<Empregado, Long> {
    List<Empregado> findBySexo(String sexo);

    List<Empregado> findByNome(String nome);
}