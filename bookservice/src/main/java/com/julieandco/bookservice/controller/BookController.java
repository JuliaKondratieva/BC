package com.julieandco.bookservice.controller;

import com.julieandco.bookservice.entities.dto.BookDTO;
import com.julieandco.bookservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("books")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public @ResponseBody
    BookDTO getAllProducts(){
        BookDTO booksDTO = new BookDTO();
        booksDTO.setBooks(bookService.getAllBooks());
        return booksDTO;
    }
}
