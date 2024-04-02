package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
public class Empregado extends Pessoa{
    @NotNull
    @Column(nullable = false)
    private String cargo;
    @NotNull
    @Column(nullable = false)
    @Min(value = 0)
    private int salario; //int pois é feito por moedas de outro.


    public Empregado() {
    }

    public Empregado(Long na, String nome, int idade, String sexo, String desc, String cargo, int salario) {
        super(na, nome, idade, sexo, desc);
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }
}
