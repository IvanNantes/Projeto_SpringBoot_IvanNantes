package com.example.demo.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
public class Aventureiro extends Pessoa {

    @NotNull
    @Column(nullable = false)
    private String classe;
    @NotNull
    @Min(value = 0, message = "A Força não pode ser menor que 0")
    @Max(value = 10, message = "A força não pode ser maior que 10")
    @Column(nullable = false)
    private int F; //Força
    @NotNull
    @Min(value = 0, message = "O Vigor não pode ser menor que 0")
    @Max(value = 10, message = "O Vigor não pode ser maior que 10")
    @Column(nullable = false)
    private int V; //Vigor
    @NotNull
    @Min(value = 0, message = "O Poder Mágico não pode ser menor que 0")
    @Max(value = 10, message = "O Poder Mágico não pode ser maior que 10")
    @Column(nullable = false)
    private int P; //Poder Mágico
    @NotNull
    @Min(value = 0, message = "A destreza não pode ser menor que 0")
    @Max(value = 10, message = "A destreza não pode ser maior que 10")
    @Column(nullable = false)
    private int D; //Destreza
    @NotNull
    @Min(value = 0, message = "O Carisma não pode ser menor que 0")
    @Max(value = 10, message = "O Carisma não pode ser maior que 10")
    @Column(nullable = false)
    private int C; //Carisma
    @NotNull
    @Min(value = 0, message = "A Sorte não pode ser menor que 0")
    @Max(value = 10, message = "A Sorte não pode ser maior que 10")
    @Column(nullable = false)
    private int S; //Sorte

    public Aventureiro() {
    }

    public Aventureiro(Long na, String nome, int idade, String sexo, String desc, String classe, int f, int v, int p, int d, int c, int s) {
        super(na, nome, idade, sexo, desc);
        this.classe = classe;
        F = f;
        V = v;
        P = p;
        D = d;
        C = c;
        S = s;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public int getF() {
        return F;
    }

    public void setF(int f) {
        F = f;
    }

    public int getV() {
        return V;
    }

    public void setV(int v) {
        V = v;
    }

    public int getP() {
        return P;
    }

    public void setP(int p) {
        P = p;
    }

    public int getD() {
        return D;
    }

    public void setD(int d) {
        D = d;
    }

    public int getC() {
        return C;
    }

    public void setC(int c) {
        C = c;
    }

    public int getS() {
        return S;
    }

    public void setS(int s) {
        S = s;
    }
}
