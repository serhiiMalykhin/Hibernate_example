package com.concretepage.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book {

    @Id
    Integer id;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "books")
    private Set<Author> authors;
    @Column(name = "name")
    private String name;
    
    @OneToMany(fetch = FetchType.LAZY)
    private Set<Employee> employees;
    
    public Book() {
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Set<Author> getAuthors() {
        return authors;
    }
    
    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }
    
    public Set<Employee> getEmployees() {
        return employees;
    }
    
    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
    
    @Override
    public String toString() {
        return "Book{" +
                "author=" + authors +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}