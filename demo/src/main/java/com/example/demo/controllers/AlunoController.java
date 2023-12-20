package com.example.demo.controllers;

import com.example.demo.model.Aluno;
import com.example.demo.services.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoController {

    @Autowired
    private AlunoService service;

    @GetMapping
    public List<Aluno> findAll(){
        return service.findAll();
    }

    @GetMapping(value = "/{id}")
    public Aluno findById(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping
    public Aluno create(@RequestBody @Valid Aluno aluno){
        return service.create(aluno);
    }
    @PutMapping(value = "/{id}")
    public Aluno update(@RequestBody @Valid Aluno aluno, @PathVariable Long id){
        return service.update(aluno, id);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
