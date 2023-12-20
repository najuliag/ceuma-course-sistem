package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Curso {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String curso;

    @NotBlank
    private LocalDate data;

    @NotBlank
    private Double horas;

    @OneToMany(mappedBy = "curso")
    @JsonIgnore
    private List<Aluno> alunos = new ArrayList<>();

    public Curso(Long id, String curso, LocalDate data, Double horas) {
        this.id = id;
        this.curso = curso;
        this.data = data;
        this.horas = horas;
    }

    public Curso() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Double getHoras() {
        return horas;
    }

    public void setHoras(Double horas) {
        this.horas = horas;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
}
