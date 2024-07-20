package com.colegio.projeto_exemplo_professor.model;

import java.io.Serializable;

public class Professor implements Serializable {
    
    private static final Long serialVersionUID = 1L;   

    private Long pk;
    private String nome;
    
    @Deprecated
    public Professor() {
    }

    public Professor(Long pk, String nome) {
        this.pk = pk;
        this.nome = nome;
    }

    public static Long getSerialversionuid() {
        return serialVersionUID;
    }

    public Long getPk() {
        return pk;
    }

    public void setPk(Long pk) {
        this.pk = pk;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }    
    
}
