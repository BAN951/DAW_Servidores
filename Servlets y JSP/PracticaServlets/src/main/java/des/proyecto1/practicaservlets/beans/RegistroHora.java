/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package des.proyecto1.practicaservlets.beans;

import des.proyecto1.practicaservlets.types.EntradaSalida;
import java.util.GregorianCalendar;

/**
 *
 * @author Benjamin Adam Nagy
 */
public class RegistroHora {
 
    private User user; 
    private EntradaSalida tipo; 
    private GregorianCalendar date; 
    
    public RegistroHora(User user, EntradaSalida tipo, GregorianCalendar date) {
        this.user = user; 
        this.tipo = tipo; 
        this.date = date; 
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public EntradaSalida getTipo() {
        return tipo;
    }

    public void setTipo(EntradaSalida tipo) {
        this.tipo = tipo;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }
    
}
