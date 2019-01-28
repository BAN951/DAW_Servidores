/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reghours.beans;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class UserList {
    
    ArrayList<User> listaUsuarios;
    
    public UserList() {
        listaUsuarios = new ArrayList<User>();
    }
    
    public void addUser(User user) {
        listaUsuarios.add(user);
    }
    
    public ArrayList<User> getListaUsuarios() {
        return this.listaUsuarios;
    }
    
}
