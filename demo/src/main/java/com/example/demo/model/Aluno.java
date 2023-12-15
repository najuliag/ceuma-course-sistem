package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Aluno {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private String número;

//    @ManyToOne
//    @JoinColumn(name = "curso_id")
//    private Curso curso;

    public Aluno(Long id, String nome, String email, String cpf, String número) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.número = número;
    }
    public Aluno() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNúmero() {
        return número;
    }

    public void setNúmero(String número) {
        this.número = número;
    }
}
