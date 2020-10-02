package com.julieandco.bookservice.controller;

import com.julieandco.bookservice.entities.Book;
import com.julieandco.bookservice.entities.User;
import com.julieandco.bookservice.entities.dto.OrderDTO;
import com.julieandco.bookservice.entities.dto.SubmitOrderDTO;
import com.julieandco.bookservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bookorders")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Void> createOrder(@RequestBody SubmitOrderDTO submitOrder){
        User user = submitOrder.getUser();
        Book book = submitOrder.getBook();
        orderService.addOrder(book, user);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public @ResponseBody
    OrderDTO getAllOrders(){
        OrderDTO ordersDTO = new OrderDTO();
        ordersDTO.setOrders(orderService.getAllOrders());
        return ordersDTO;
    }
}
