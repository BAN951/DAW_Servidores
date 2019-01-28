/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restfultest.webservice;

import javax.ws.rs.Path;
import restfultest.datamodel.entities.Book; 
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import restfultest.datamodel.HibernateUtil;
import org.hibernate.Query;

/**
 * 
 * @author admin
 */
@Path("/book")
public class BooksService {
    
    /* Service para obtener libros, añadir libros, etc... */
    
    // Get de todos los libros.
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getAll() {
        
        SessionFactory sf = HibernateUtil.getSessionFactory();
     
        Session session = sf.openSession();
        
        String hql = "FROM Book b";
        Query query = session.createQuery(hql);
           
        List<Book> books = query.list();
        
        session.close();
        
        return books;

    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Book book) {
        
        SessionFactory sf = HibernateUtil.getSessionFactory();
       
        Session session = sf.openSession(); 
        session.beginTransaction();
        
        session.save(book);
        
        session.getTransaction().commit();
        
        session.close(); 
        
    }
   
}
