package com.concretepage.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book {

    @Id
    Integer id;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "books")
    private Set<Author> users;
    @Column(name = "name")
    private String name;

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


    public Set<Author> getUsers() {
        return users;
    }

    public void setUsers(Set<Author> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author=" + users +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}