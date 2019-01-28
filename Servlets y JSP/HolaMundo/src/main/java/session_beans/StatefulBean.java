/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session_beans;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import javax.ejb.Stateful;

/**
 *
 * @author admin
 */
@Stateful
public class StatefulBean implements StatefulBeanLocal {

    private int edad;
    private String password;
    private String dni;

    /**
     * Get the value of dni
     *
     * @return the value of dni
     */
    public String getDNI() {
        return dni;
    }

    /**
     * Set the value of dni
     *
     * @param dni new value of dni
     */
    public void setDNI(String dni) {
        this.dni = dni;
    }


    /**
     * Get the value of edad
     *
     * @return the value of edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Set the value of edad
     *
     * @param edad new value of edad
     */
    public void setEdad(String edad) {
        
        if(!"".equals(edad)){
            this.edad = Integer.parseInt(edad); 
        } else {
            this.edad = 0; // Valor por defecto. 
        }
    }
    
     @Override
    public void setEdad(int edad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    /**
     * Add PropertyChangeListener.
     *
     * @param listener
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    /**
     * Remove PropertyChangeListener.
     *
     * @param listener
     */
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    @Override
    public String getPassword() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        return this.password;
    }

    @Override
    public void setPassword(String password) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        this.password = password; 
    }

    
    @Override
    public String print() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return "DNI: " + this.dni + "\tPassword: " + this.password + "\tEdad: " + this.edad; 
    }



    
}
