package com.colegio.projeto_exemplo_professor.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colegio.projeto_exemplo_professor.model.Professor;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @GetMapping
    public List<Professor> listar(){

        Professor prof1 = new Professor(null, "Norberto");
        Professor prof2 = new Professor(null, "Vinicius");

        List<Professor> listaDeProfessores = new ArrayList<>();
        listaDeProfessores.add(prof1);
        listaDeProfessores.add(prof2);

        return listaDeProfessores;
    }
    
}
