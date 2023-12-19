package com.example.demo.dto;

import java.time.LocalDate;
import java.util.List;

public class CursoDTO {

    private Long id;
    private String curso;
    private LocalDate data;
    private Double horas;
    private List<AlunoDTO> alunos;

    public CursoDTO() {
    }

    public CursoDTO(Long id, String curso, LocalDate data, Double horas) {
        this.id = id;
        this.curso = curso;
        this.data = data;
        this.horas = horas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Double getHoras() {
        return horas;
    }

    public void setHoras(Double horas) {
        this.horas = horas;
    }

    public List<AlunoDTO> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<AlunoDTO> alunos) {
        this.alunos = alunos;
    }
}
