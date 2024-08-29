package com.colegio.projeto_exemplo_professor.dto;

import com.colegio.projeto_exemplo_professor.model.Professor;

public class ProfessorDTO {
    
    private String nome;

    @Deprecated    
    public ProfessorDTO() {
    }

    public ProfessorDTO(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Professor novoProfessor() {
        return new Professor(null, this.nome);
    }

    @Override
    public String toString() {
        return "ProfessorDTO [nome=" + nome + "]";
    }   
    
}
