/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session_beans;

import javax.ejb.Local;
import javax.validation.constraints.Min;

/**
 *
 * @author admin
 */
@Local
public interface StatefulBeanLocal {
    
    // LAS VALIDACIONES SE PONEN EN LA INTERFACE. EN EL GETTER; 
    
    @Min(value=18, message="Tienes que ser mayor de edad.")
    public int getEdad();
    
    public void setEdad(String edad); 
    public void setEdad(int edad); 
    
    // queremos que el pattern sea lo mismo en todos los lados. 
    @Password(message="Password incorrecto")
    public String getPassword(); 
    
    public void setPassword(String password); 
    
    @DNI(message = "DNI incorrecto")
    public String getDNI();

    public void setDNI(String dni);
 
    public String print(); 
    
    // Nota: los métodos de la interface (cómo ésta), són los métodos que los servlets pueden utilizar. 
}
