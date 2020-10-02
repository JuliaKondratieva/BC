package com.julieandco.bookservice.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.julieandco.bookservice.entities.Book;
import com.julieandco.bookservice.entities.Box;
import com.julieandco.bookservice.entities.User;
import com.julieandco.bookservice.entities.dto.BoxDTO;
import com.julieandco.bookservice.entities.dto.OrderDTO;
import com.julieandco.bookservice.entities.dto.SubmitOrderDTO;
import com.julieandco.bookservice.repo.BoxRepository;
import com.julieandco.bookservice.service.BoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("boxes")
public class BoxController {
    private final BoxService boxService;
    private final BoxRepository boxRepository;


    @Autowired
    public BoxController(BoxService boxService, BoxRepository boxRepository) {
        this.boxService = boxService;
        this.boxRepository=boxRepository;
    }

    /*@PostMapping
    public ResponseEntity<Void> deliverToBox(@RequestBody String deliverJson){
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        Book deliverBook = gson.fromJson(deliverJson, Book.class);
        Box deliverBox = gson.fromJson(deliverJson, Box.class);

        boxService.addBook(deliverBox, deliverBook);


        Box box = boxRepository.getOne(boxDTO.getId());
        boxService.addBook(box, book);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public @ResponseBody
    BoxDTO getAllBoxes(){
        BoxDTO boxDTO = new BoxDTO();
        boxDTO.setBooks(boxService.addBook();).setOrders(orderService.getAllOrders());
        return ordersDTO;
    }*/

}
