package com.julieandco.bookservice.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Entity
@Table (name="box")
public class Box {
    @Id
    @GeneratedValue
    private UUID id;
    @OneToMany(mappedBy = "boxId")
    private List<Book> books;
    @Column
    private String address;

    public Box() {
        books=new ArrayList<>();
        address="";
    }

    public List<Book> getBooks() {
        return books;
    }

    public UUID getId() {
        return id;
    }

    public void setAddress(String address){
        this.address=address;
    }

    public String getAddress() {
        return address;
    }
}
