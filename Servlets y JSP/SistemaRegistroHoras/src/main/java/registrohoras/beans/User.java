/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrohoras.beans;

/**
 *
 * @author admin
 */
public class User {
 
    private String nombreUsuario;
    private String passwordUsuario;
    private String emailUsuario; 

    public User(String username, String password, String email) {
        this.nombreUsuario = username;
        this.passwordUsuario = password;
        this.emailUsuario = email;
    }
    
    public User(String username, String password) {
        this.nombreUsuario = username; 
        this.passwordUsuario = password; 
    }   
    
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
}
