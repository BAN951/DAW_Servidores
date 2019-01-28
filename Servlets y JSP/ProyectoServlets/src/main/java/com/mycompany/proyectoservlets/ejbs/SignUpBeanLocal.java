/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectoservlets.ejbs;

import com.mycompany.proyectoservlets.validation.Email;
import com.mycompany.proyectoservlets.validation.Password;
import com.mycompany.proyectoservlets.validation.Username;
import javax.ejb.Local;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author admin
 */
@Local
public interface SignUpBeanLocal {
    
    /*@NotNull*/
    @Username(message="Nombre de usuario incorrecto. ")
    @Size(min=3, max=26, message="Nombre de usuario incorrecto.\n La longitud"
            + "tiene que estar entre 3 y 26 carácteres. ")
    public String getNombreUsuario();
    
    /*@NotNull
    @Password(message="Password incorrecto. ")
    @Size(min=5, message="Contraseña demasiado corta... ")*/
    public String getPasswordUsuario();
    
    /*@NotNull
    @Email(message="Correo electrónico incorrecto. ")*/
    public String getEmailUsuario();
    
    public void setNombreUsuario(String nombreUsuario);
    public void setPasswordUsuario(String passwordUsuario);
    public void setEmailUsuario(String emailUsuario);

    String getDatosUsuario();
    
    
}
