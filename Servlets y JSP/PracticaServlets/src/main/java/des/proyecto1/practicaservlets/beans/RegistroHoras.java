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
public class RegistroHoras {
 
    private User user; 
    private EntradaSalida tipo; 
    private GregorianCalendar date; 
    
    public RegistroHoras(User user, EntradaSalida tipo, GregorianCalendar date) {
        this.user = user; 
        this.tipo = tipo; 
        this.date = date; 
    }
    
}
