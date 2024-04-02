package com.example.demo.repository;


import com.example.demo.model.Aventureiro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Spliterator;

public interface AventureiroRepository extends JpaRepository<Aventureiro, Long> {
    List<Aventureiro> findBySexo(String sexo);

    List<Aventureiro> findByNome(String nome);
}