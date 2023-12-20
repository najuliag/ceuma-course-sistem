package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @Email(message = "Insira um email válido.")
    private String email;

    @Size(min = 11, max = 11, message = "O número telefone deve conter 11 dígitos.")
    private String telefone;

    @Size(min = 11, max = 11, message = "O CPF deve conter 11 dígitos.")
    private String cpf;

    @NotBlank
    private String endereco;

    @NotBlank
    @Size(min = 8, max = 8, message = "O CEP deve conter 8 números.")
    private String cep;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    @JsonIgnoreProperties({"alunos", "hibernateLazyInitializer", "handler"})
    private Curso curso;

    public Aluno(Long id,String nome, String email, String cpf, String telefone, String endereco, String cep, Curso curso) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cep = cep;
        this.curso = curso;
    }

    public Aluno() {}

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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
