package com.colegio.projeto_exemplo_professor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.colegio.projeto_exemplo_professor.model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long>{
    
}
