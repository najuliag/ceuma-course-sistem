package com.example.demo.services;

import com.example.demo.exception.RequiredObjectIsNull;
import com.example.demo.exception.ResourceNotFound;
import com.example.demo.model.Aluno;
import com.example.demo.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository repository;

    public Aluno findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFound("No records found for this id."));
    }

    public List<Aluno> findAll(){
        return repository.findAll();
    }

    public Aluno create(Aluno aluno) {
        Aluno entity = new Aluno();

        if (aluno == null) throw new RequiredObjectIsNull();

        entity.setNome(aluno.getNome());
        entity.setEmail(aluno.getEmail());
        entity.setCpf(aluno.getCpf());
        entity.setTelefone(aluno.getTelefone());
        entity.setEndereco(aluno.getEndereco());
        entity.setCep(aluno.getCep());
        entity.setCurso(aluno.getCurso());
        repository.save(entity);
        return entity;

    }

    public Aluno update(Aluno aluno, Long id) {
        Aluno entity = repository.findById(id).orElseThrow(() -> new ResourceNotFound("No records found for this id."));

        if (aluno == null) throw new RequiredObjectIsNull();

        entity.setNome(aluno.getNome());
        entity.setEmail(aluno.getEmail());
        entity.setCpf(aluno.getCpf());
        entity.setTelefone(aluno.getTelefone());
        entity.setEndereco(aluno.getEndereco());
        entity.setCep(aluno.getCep());
        entity.setCurso(aluno.getCurso());
        repository.save(entity);
        return entity;
    }

    public void delete(Long id) {
        Aluno entity = repository.findById(id).orElseThrow(() -> new ResourceNotFound("No records found for this id."));
        repository.delete(entity);
    }

}
