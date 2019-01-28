/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restfultest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.List;
import restfultest.datamodel.entities.Book;

/**
 *
 * @author admin
 */
public class ShowBooksClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /* Construye un client http. 
        Utilizando este cliente podemos montar una petición hacia el web service. */
        Client client = ClientBuilder.newClient();
        
        // Es el objetivo, aqçuí indicamos la URL.
        WebTarget target = client.target("http://localhost:8080/RESTfulTest/rest/book");
        
        // Tiene que invocar una petición del tipo que yo quiero.
        // En este caso un GET.
        Invocation invocation = target.request().buildGet(); 
        
        Response respuesta = invocation.invoke(); 
        
        String booksJSON = respuesta.readEntity(String.class);
        System.out.println("Respuesta:\n" + booksJSON + "\n");
        
        // Usaremos GSON de Google para parsear el JSON recibido. 
        Gson gson = new Gson();
        List<Book> books = gson.fromJson(booksJSON, new TypeToken<List<Book>>(){}.getType());
        
        for(Book b : books) {
            System.out.print("\n" + b.toString() + ", ");
            System.out.print(b.getTitle() + ", ");
            System.out.print(b.getAuthor());
        }
    }
    
}
