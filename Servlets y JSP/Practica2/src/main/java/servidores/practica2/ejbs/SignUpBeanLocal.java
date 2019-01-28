/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidores.practica2.ejbs;

import servidores.practica2.validators.Email;
import servidores.practica2.validators.Password;
import servidores.practica2.validators.Username;
import javax.ejb.Local;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author admin
 */
@Local
public interface SignUpBeanLocal {

    String datosUsuario();
    
    @NotNull(message="¡El campo de nombre de usuario no puede estar vacío!")
    @Size(min=5, message="Nombre de usuario es demasiado corto. Mínimo 5 carácteres.")
    @Username(message="¡Nombre de usuario incorrecto!")
    public String getNombreUsuario();
    
    @NotNull(message="¡El campo de contraseña no puede estar vacío!")
    @Size(min=5, message="Nombre usuario demasiado corto.")
    @Password(message="¡Contraseña incorrecta!")
    public String getPasswordUsuario();
   
    @NotNull(message="¡El campo de correo electrónico no puede estar vacío!")
    @Email(message="¡Correo electrónico incorrecto!")
    public String getEmailUsuario();
    
    public void setNombreUsuario(String nombreUsuario);
    public void setPasswordUsuario(String passwordUsuario);
    public void setEmailUsuario(String emailUsuario);
    
}
