/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrohoras.ejbs;

import javax.ejb.Stateful;

/**
 *
 * @author admin
 */
@Stateful
public class SignUpBean implements SignUpBeanLocal {

    private String nombreUsuario; 
    private String passwordUsuario; 
    private String emailUsuario;

    @Override
    public String datosUsuario() {
        return "nombreUsuario: " + this.nombreUsuario + 
               ", passwordUsuario: " + this.passwordUsuario + 
               ", emailUsuario: " + this.emailUsuario;
    }

    @Override
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    @Override
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    @Override
    public String getPasswordUsuario() {
        return passwordUsuario;
    }

    @Override
    public void setPasswordUsuario(String passwordUsuario) {
        this.passwordUsuario = passwordUsuario;
    }

    @Override
    public String getEmailUsuario() {
        return emailUsuario;
    }

    @Override
    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }
    
    
    
    
    
}
