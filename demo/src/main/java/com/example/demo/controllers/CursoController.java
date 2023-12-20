package com.example.demo.controllers;

import com.example.demo.dto.CursoDTO;
import com.example.demo.exception.ResourceNotFound;
import com.example.demo.model.Curso;
import com.example.demo.services.CursoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/api/cursos")
public class CursoController {

    @Autowired
    private CursoService service;

    @GetMapping
    public ResponseEntity<List<CursoDTO>> findAll() {
        List<CursoDTO> cursosDTO = service.findAll();
        if (!cursosDTO.isEmpty()) {
            return new ResponseEntity<>(cursosDTO, HttpStatus.OK);
        } else {
            throw new ResourceNotFound("No records found for this id.");
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CursoDTO> findById(@PathVariable(value = "id") Long id){
        CursoDTO cursoDTO = service.findById(id);
        if (cursoDTO != null) {
            return new ResponseEntity<>(cursoDTO, HttpStatus.OK);
        } else {
            throw new ResourceNotFound("No records found for this id.");
        }
    }

    @PostMapping
    public Curso create(@RequestBody @Valid Curso curso){
        curso.setData(LocalDate.now());
        return service.create(curso);
    }

    @PutMapping(value = "/{id}")
    public Curso update(@RequestBody @Valid Curso curso, @PathVariable Long id){
        return service.update(curso, id);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

