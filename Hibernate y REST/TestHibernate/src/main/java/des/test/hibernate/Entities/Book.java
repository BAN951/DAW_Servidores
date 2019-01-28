/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package des.test.hibernate.Entities;

import javax.persistence.*;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "BOOK")
public class Book {
    
    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;
    
    @Column(name = "title")
    private String title; 
    
    @ManyToOne // Relación 
    @JoinColumn(name = "author") // JoinColumn es foreign key
    private Author author; 

    public Book() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
    
    
}
