/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package des.test.hibernate;

import des.test.hibernate.Entities.Author;
import des.test.hibernate.Entities.Book;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author admin
 */
public class TestBooks {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /* CRUD --> CREATE, UPDATE, DELETE */
              
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        
        // Iniciando una sesión con base de datos. 
        Session session = sessionFactory.openSession();
        
        // Iniciamos una transacción
        session.beginTransaction();
        
//        // Insert 
//        Author autor2 = new Author();
//        autor2.setName("Autor2");
//        
//        session.save(autor2); // Decimos que haga el insert 
//        
//        // Hacemos insert de un libro para el autor2 
//        Book libro1 = new Book();
//        libro1.setTitle("libro1");
//        libro1.setAuthor(autor2);
//        
//        session.save(libro1); 
        
        
        // Queries
        
        // Query que devuelve todos los autores
        String hql = "FROM Author";
        Query query = session.createQuery(hql);
        List<Author> autores = query.list();
        
        for(Author a : autores) {
            System.out.println("Id: " + a.getId() + " \tName: " + a.getName());
        }

        // Query de un autor en concreto
        hql = "FROM Author A WHERE A.id='2'";
        query = session.createQuery(hql);
        autores = query.list(); 
        
        System.out.println("----------------------------------------------------");
        
        Author segundoAutor = autores.get(0); // Porque solo hay 1 autor en este caso

        // Update del autor ( le cambiamos el nombre )
//        segundoAutor.setName("Autor Actualizado");
//        session.update(segundoAutor); 

        // Query con JOIN (inner join) 
        // sacamos los libros con autor
        // Nada más ponemos el atributo de la tabla de la izquierda que usa la tabla de la derecha como referencia 
        // hacia la otra.
//        String hqlLibrosConAutor = "SELECT b FROM Author a inner join a.books as b";
//        query = session.createQuery(hqlLibrosConAutor); 
//        List<Book> book = query.list();


        // Delete
        String hqlAutor1 = "FROM Author a WHERE a.id = '1'";
        Query queryAuthor = session.createQuery(hqlAutor1);
        List<Author> getAuthor1 = queryAuthor.list();
       
        Author autor1 = getAuthor1.get(0);
        
        session.delete(autor1); 
 
        session.getTransaction().commit(); // Acabamos la transacción con un commit, se insertan los datos.
        
        // Cerramos sesión
        session.close(); 
        
    }
    
}
