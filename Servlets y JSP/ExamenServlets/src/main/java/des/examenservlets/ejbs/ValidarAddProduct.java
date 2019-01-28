/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package des.examenservlets.ejbs;

import javax.ejb.Stateful;

/**
 *
 * @author admin
 */
@Stateful
public class ValidarAddProduct implements ValidarAddProductsLocal {

    private int id; 
    private String producto; 
    private int cantidad; 

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getProducto() {
        return producto;
    }

    @Override
    public void setProducto(String producto) {
        this.producto = producto;
    }

    @Override
    public int getCantidad() {
        return cantidad;
    }

    @Override
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
