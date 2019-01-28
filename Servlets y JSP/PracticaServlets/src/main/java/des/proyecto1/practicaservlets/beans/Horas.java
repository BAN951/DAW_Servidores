/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package des.proyecto1.practicaservlets.beans;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author admin
 */
public class Horas {
    
    private Hashtable<String, ArrayList<RegistroHora>> horas; 
    private ArrayList<RegistroHora> registros; 
    private String clave;

    public Horas() {
        horas = new Hashtable<String, ArrayList<RegistroHora>>(); 
    }
    
    public void addRegistro(String clave, ArrayList<RegistroHora> registros) {
        horas.put(clave, registros); 
    }
    
    public void addRegistro(String clave, RegistroHora registro) {
        ArrayList<RegistroHora> temp = (ArrayList<RegistroHora>) horas.get(clave);
        
    }
    
    public Hashtable<String, ArrayList<RegistroHora>> getHoras() {
        return horas;
    }

    public void setHoras(Hashtable<String, ArrayList<RegistroHora>> horas) {
        this.horas = horas;
    }
    
    
    
    
}
