package com.colegio.projeto_exemplo_professor.dto;

import com.colegio.projeto_exemplo_professor.model.Professor;

public class ProfessorDTO {
    
    private String nome;

    public Professor novoProfessor() {
        return new Professor(null, this.nome);
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    
}
