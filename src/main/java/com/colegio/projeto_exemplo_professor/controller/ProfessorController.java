package com.colegio.projeto_exemplo_professor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @GetMapping("/listar")
    public String listar(){
        return "Rest está funcionando";
    }
    
}
