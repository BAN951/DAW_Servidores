/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectoservlets.ejbs;

import javax.ejb.Stateful;

/**
 *
 * @author admin
 */
@Stateful
public class SignUpBean implements SignUpBeanLocal {

    String nombreUsuario; 
    String passwordUsuario;
    String emailUsuario; 
    
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPasswordUsuario() {
        return passwordUsuario;
    }

    public void setPasswordUsuario(String passwordUsuario) {
        this.passwordUsuario = passwordUsuario;
    }
    
    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    @Override
    public String getDatosUsuario() {
        return "Nombre de usuario: " + this.nombreUsuario + 
                "\nPassword usuario: " + this.passwordUsuario + 
                "\nEmail usuario: " + this.emailUsuario;
    }

    
    
}
