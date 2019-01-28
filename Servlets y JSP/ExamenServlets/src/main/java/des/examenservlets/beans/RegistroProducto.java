/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package des.examenservlets.beans;

import java.util.GregorianCalendar;

/**
 *
 * @author admin
 */
public class RegistroProducto {
    
    private String id; 
    private String nombre; 
    private int cantidad; 
    private GregorianCalendar fecha; 
    
    public RegistroProducto(String id, String nombre, int cantidad) {
        this.id = id; 
        this.nombre = nombre; 
        this.cantidad = cantidad; 
        this.fecha = new GregorianCalendar(); 
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
    
}
