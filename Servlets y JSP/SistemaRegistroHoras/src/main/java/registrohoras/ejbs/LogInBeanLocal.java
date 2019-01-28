/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrohoras.ejbs;

import registrohoras.validators.Password;
import registrohoras.validators.Username;
import javax.ejb.Local;
import javax.validation.constraints.NotNull;

/**
 *
 * @author admin
 */
@Local
public interface LogInBeanLocal {
 
    @NotNull(message="El nombre de usuario no puede ser null.")
    @Username(message="Nombre de usuario incorrecto.")
    public String getNombreUsuario();
    
    @NotNull(message="La contraseña no puede ser null.")
    @Password(message="Formato de la contraseña incorrecta.")
    public String getPasswordUsuario();
    
    public void setNombreUsuario(String nombreUsuario);
    public void setPasswordUsuario(String passwordUsuario); 
    
}
