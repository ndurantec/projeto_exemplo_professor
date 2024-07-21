package com.colegio.projeto_exemplo_professor.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colegio.projeto_exemplo_professor.dto.ProfessorDTO;
import com.colegio.projeto_exemplo_professor.model.Professor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @PersistenceContext
    private EntityManager manager;

    @GetMapping
    public List<Professor> listar() {

        Professor prof1 = new Professor(1L, "Norberto");
        Professor prof2 = new Professor(2L, "Vinicius");

        List<Professor> listaDeProfessores = new ArrayList<>();
        listaDeProfessores.add(prof1);
        listaDeProfessores.add(prof2);

        return listaDeProfessores;
    }

    @PostMapping(value = "/novo")
    @Transactional
    public void insert(@RequestBody ProfessorDTO novoProfessorDTO) {
        Professor novoProfessor = novoProfessorDTO.novoProfessor();
        manager.persist(novoProfessor);
    }
    
}
