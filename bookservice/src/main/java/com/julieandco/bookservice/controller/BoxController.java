package com.julieandco.bookservice.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.julieandco.bookservice.entities.Book;
import com.julieandco.bookservice.entities.Box;
import com.julieandco.bookservice.entities.User;
import com.julieandco.bookservice.entities.dto.*;
import com.julieandco.bookservice.repo.BoxRepository;
import com.julieandco.bookservice.service.BoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/boxes")
public class BoxController {
    private final BoxService boxService;
    private final BoxRepository boxRepository;


    @Autowired
    public BoxController(BoxService boxService, BoxRepository boxRepository) {
        this.boxService = boxService;
        this.boxRepository=boxRepository;
    }

    @PostMapping("/save")
    public ResponseEntity<Void> saveBox(@RequestBody String addressJson){
        Box newBox=new Box();
        newBox.setAddress(addressJson);
        boxService.addBox(newBox);

        return ResponseEntity.ok().build();
    }

    /*@PostMapping("/deliver")
    public ResponseEntity<Void> deliverToBox(@RequestBody String deliverJson){
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        BookDTO deliverBook = gson.fromJson(deliverJson, BookDTO.class);
        Book newBook = new Book();
        newBook.setTitle(deliverBook.getTitle());
        newBook.setAuthor(deliverBook.getAuthor());
        newBook.setGenre(deliverBook.getGenre());
        newBook.setYear(deliverBook.getYear());
        newBook.setRating(deliverBook.getRating());
        newBook.setAvailable(deliverBook.getAvailability());
        newBook.setNeedRepair(deliverBook.getRepair());
        boxService.addBook(boxTo, bookAdd);
        return ResponseEntity.ok().build();


    }*/
}
