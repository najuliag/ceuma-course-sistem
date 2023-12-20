package com.example.demo.services;


import com.example.demo.dto.AlunoDTO;
import com.example.demo.dto.CursoDTO;
import com.example.demo.exception.RequiredObjectIsNull;
import com.example.demo.exception.ResourceNotFound;

import com.example.demo.model.Curso;
import com.example.demo.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CursoService {

    @Autowired
    private CursoRepository repository;

    public CursoDTO findById(Long id) {
        Curso curso = repository.findById(id).orElseThrow(() -> new ResourceNotFound("No records found for this id."));

        if (curso == null) throw new RequiredObjectIsNull();

        List<AlunoDTO> alunosDTO = curso.getAlunos()
                .stream()
                .map(aluno -> new AlunoDTO(aluno.getId(), aluno.getNome()))
                .collect(Collectors.toList());

        CursoDTO cursoDTO = new CursoDTO();
        cursoDTO.setId(curso.getId());
        cursoDTO.setCurso(curso.getCurso());
        cursoDTO.setData(curso.getData());
        cursoDTO.setHoras(cursoDTO.getHoras());
        cursoDTO.setAlunos(alunosDTO);
        return cursoDTO;
    }

    public List<CursoDTO> findAll() {
        List<Curso> cursos = repository.findAll();

        return cursos.stream()
                .map(curso -> {
                    List<AlunoDTO> alunosDTO = curso.getAlunos()
                            .stream()
                            .map(aluno -> new AlunoDTO(aluno.getId(), aluno.getNome()))
                            .collect(Collectors.toList());

                    CursoDTO cursoDTO = new CursoDTO();
                    cursoDTO.setId(curso.getId());
                    cursoDTO.setCurso(curso.getCurso());
                    cursoDTO.setData(curso.getData());
                    cursoDTO.setHoras(curso.getHoras());
                    cursoDTO.setAlunos(alunosDTO);

                    return cursoDTO;
                })
                .collect(Collectors.toList());
    }

    public Curso create(Curso curso) {
        Curso entity = new Curso();

        if (curso == null) throw new RequiredObjectIsNull();

        entity.setCurso(curso.getCurso());
        entity.setData(curso.getData());
        entity.setAlunos(curso.getAlunos());
        repository.save(entity);
        return entity;

    }

    public Curso update(Curso curso, Long id) {
        Curso entity = repository.findById(id).orElseThrow(() -> new ResourceNotFound("No records found for this id."));

        if (curso == null) throw new RequiredObjectIsNull();

        entity.setCurso(curso.getCurso());
        entity.setData(curso.getData());
        entity.setAlunos(curso.getAlunos());
        repository.save(entity);
        return entity;
    }

    public void delete(Long id) {
        repository.findById(id).orElseThrow(() -> new ResourceNotFound("No records found for this id."));
        repository.deleteById(id);
    }

}
