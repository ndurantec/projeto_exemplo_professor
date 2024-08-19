package com.colegio.projeto_exemplo_professor.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.colegio.projeto_exemplo_professor.dto.ProfessorDTO;
import com.colegio.projeto_exemplo_professor.model.Professor;
import com.colegio.projeto_exemplo_professor.repository.ProfessorRepository;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private ProfessorRepository ProfessorRepository;

    @GetMapping(value = "listar")
    public ResponseEntity<List<Professor>> listar() {

        Professor prof1 = new Professor(1L, "Norberto");
        Professor prof2 = new Professor(2L, "Vinicius");

        List<Professor> listaDeProfessores = new ArrayList<>();
        listaDeProfessores.add(prof1);
        listaDeProfessores.add(prof2);

        return ResponseEntity.ok(listaDeProfessores);
    }

    @PostMapping(value = "/novo", consumes = {"application/json"})    
    //@PostMapping(value = "/novo", consumes = {"application/xml","application/json"} )
    public ResponseEntity<Professor> insert(@RequestBody ProfessorDTO novoProfessorDTO) {

        System.out.println(novoProfessorDTO.toString());

        Professor novoProfessor = novoProfessorDTO.novoProfessor();
        ProfessorRepository.save(novoProfessor);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(novoProfessor.getId()).toUri();

        return ResponseEntity.created(uri).body(novoProfessor);
    }
    
}
