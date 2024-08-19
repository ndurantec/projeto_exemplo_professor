package com.colegio.projeto_exemplo_professor.controller;

public class LoginController {
    
    private String usuario;
    private String password;
    
    
    public boolean logar_3() {

        if (!usuario.equals("ngduran") && !password.equals("123456")) {
            return false;
        } 

        return true;
    } 



    public boolean logar_2() {

        if (usuario.equals("ngduran") && password.equals("123456")) {
            return true;
        } else {
            return false;
        }
    }


    public void logar_1() {

    }
    

}
