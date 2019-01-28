/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package des.examenservlets.ejbs;

import des.examenservlets.validators.Unidad;
import javax.ejb.Local;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author admin
 */
@Local
public interface ValidarAddProductsLocal {
    
    @Pattern(regexp="", message="^(\\d{4)$")
    public int getId();
    
    @NotNull(message="Tienes que introducir un producto. El campo no puede estar vacío.")
    @Size(max = 32, message="Nombre de producto demasiado largo.")
    public String getProducto();
    
    @Unidad(message="Las unidades tienen que estar entre 0 y 99.")
    public int getCantidad();
    
    public void setId(int id);
    public void setProducto(String producto);
    public void setCantidad(int cantidad); 
    
}
