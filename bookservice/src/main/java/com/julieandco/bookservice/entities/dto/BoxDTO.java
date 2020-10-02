package com.julieandco.bookservice.entities.dto;

import com.julieandco.bookservice.entities.Book;

import java.util.List;
import java.util.UUID;

public class BoxDTO {
    private List<Book> books;
    private UUID id;

    public BoxDTO() {
    }

    public BoxDTO(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public UUID getId() {
        return id;
    }

    public void setID(UUID id) {
        this.id = id;
    }
}
