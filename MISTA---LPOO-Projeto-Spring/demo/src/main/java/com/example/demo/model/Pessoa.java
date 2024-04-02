package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.UniqueElements;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoa {

        @Id
        @NotNull(message = "Informe um Número Astral")
        @Column(nullable = false)
        @Min(value = 1)
        private Long na; //Número astral
        @NotNull
        private String nome;
        @NotNull
        @Min(value = 0)
        @Column(nullable = false)
        private int idade;
        @NotNull
        @Pattern(regexp = "^[MFO]$", message = "Apenas M (Masculino), F (Feminino) e O (Outro) são aceitos") //Só vai aceitar M F ou O como resposta
        @Column(nullable = false)
        private String sexo;
        private String Desc; // Descrição do personagem, pode ser nulo

        public Pessoa() {
        }

        public Pessoa(Long na, String nome, int idade, String sexo, String desc) {
                this.na = na;
                this.nome = nome;
                this.idade = idade;
                this.sexo = sexo;
                Desc = desc;
        }

        public Long getNa() {
                return na;
        }

        public void setNa(Long na) {
                this.na = na;
        }

        public String getNome() {
                return nome;
        }

        public void setNome(String nome) {
                this.nome = nome;
        }

        public int getIdade() {
                return idade;
        }

        public void setIdade(int idade) {
                this.idade = idade;
        }

        public String getSexo() {
                return sexo;
        }

        public void setSexo(String sexo) {
                this.sexo = sexo;
        }

        public String getDesc() {
                return Desc;
        }

        public void setDesc(String desc) {
                Desc = desc;
        }
}


