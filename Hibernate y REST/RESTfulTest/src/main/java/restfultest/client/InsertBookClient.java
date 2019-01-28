/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restfultest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import restfultest.datamodel.entities.Book;

/**
 *
 * @author admin
 */
public class InsertBookClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/RESTfulTest/rest/")
                .path("book");
        
        // Creamos un libro nuevo, para enviar y hacer el insert.
        Book b = new Book();
        b.setAuthor("Cliente WS");
        b.setIsbn("50");
        b.setTitle("Cliente WS Title");
        
        // Aquí usamos a Jackson en vez de GSON.
        // Nuevo constructor de la petición porque necesitamos añadirle una cabecera. 
        Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
        Response res = invocationBuilder.post(Entity.entity(b, MediaType.APPLICATION_JSON));
        
        System.out.println("Status: " + res.getStatus());
    }
    
}
