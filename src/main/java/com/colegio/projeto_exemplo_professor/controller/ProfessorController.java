package com.colegio.projeto_exemplo_professor.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    private ProfessorRepository professorRepository;

    @GetMapping(value = "/imprimir")
    public String imprimir(){
        return "Chegou até no servidor";
    }


    @GetMapping(value = "/listar")
    public ResponseEntity<List<Professor>> listar() {

        Professor prof1 = new Professor(1L, "Norberto");
        Professor prof2 = new Professor(2L, "Vinicius");

        List<Professor> listaDeProfessores = new ArrayList<>();
        listaDeProfessores.add(prof1);
        listaDeProfessores.add(prof2);

        return ResponseEntity.ok(listaDeProfessores);
    }

    /*
    @PostMapping(value = "/novo", consumes = {"application/json"})    
    //@PostMapping(value = "/novo", consumes = {"application/xml","application/json"} )
    public ResponseEntity<Professor> insert(@RequestBody ProfessorDTO novoProfessorDTO) {

        System.out.println(novoProfessorDTO.toString());

        Professor novoProfessor = novoProfessorDTO.novoProfessor();
        professorRepository.save(novoProfessor);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(novoProfessor.getId()).toUri();

        return ResponseEntity.created(uri).body(novoProfessor);
    }
*/


    @PostMapping(value = "/insert")
    public ResponseEntity<Professor> insert(@RequestBody ProfessorDTO professorDto) {

        Professor professor = professorDto.novoProfessor();
        professorRepository.save(professor);


        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(professor.getId())
                        .toUri();
        
        System.out.println("Chegou no método insert no servidor");        

        return ResponseEntity.created(uri).body(professor);

        
    }



    //primeira versão do método listar todos
    public void lerTodos() {

    }








    
    // segunda versão do método listar todos
    public void findAll_1() {

    }
    
    



    //terceira versão do método listar todos
    @GetMapping(value = "/findAll_2")
    public String findAll_2() {
        return "Terceira versão do método...";
    }
    

    //terceira versão do método listar todos
    @GetMapping(value = "/findAll_3")
    public ResponseEntity findAll_3() {
        return ResponseEntity.ok().build();
    }
    

    //quarta versão do método listar todos
    @GetMapping(value = "/findAll")
    public List<Professor> findAll() {  
        return professorRepository.findAll();
    }

    

    //Primeira versão do método buscar um registro somente
    public void buscarUmRegistro_1() {
    }
    
    //Segunda versão do método bucar um registro somente
    //@GetMapping(value = "/{id}")
    public void buscarUmRegistro_2() {
    }
    
    //Terceira versão do método bucar um registro somente
    //@GetMapping(value = "/{id}")
    public void buscarUmRegistro_3(@PathVariable Long id) {
    }

    //Quarta versão do método bucar um registro somente
    @GetMapping(value = "/{id}")
    public ResponseEntity<Professor> findById(@PathVariable Long id) {
        System.out.println( "chegou no método findById");
        return professorRepository.findById(id)
            .map(registro -> ResponseEntity.ok().body(registro))
            .orElse(ResponseEntity.notFound().build());
    } 
    
}
