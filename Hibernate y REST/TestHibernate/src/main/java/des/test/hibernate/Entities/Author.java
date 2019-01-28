/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package des.test.hibernate.Entities;

//import javax.persistence.Entity; // También se puede importar con lo de hibernate. (org.hibernate.etc...)
// el de persistence daba error, mejor con hibernate. 
// Si definimos el id de la tabla ya no da error lo de persistence. 

import java.util.List;
import javax.persistence.*;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "AUTHOR")
public class Author {
    
    @Id
    @Column(name = "id")
    @GeneratedValue // Esto es básicamente decirle: auto_increment
    private Long id; 
     
    @Column(name = "name")
    private String name; 

    @OneToMany(mappedBy = "author")
    private List<Book> books; 
    
    public Author() {}

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
