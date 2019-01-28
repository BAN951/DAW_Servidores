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
public class LogInBean implements LogInBeanLocal {

    private String nombreUsuario; 
    private String passwordUsuario; 

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
    
    
}
