package com.julieandco.bookservice.service;

import com.julieandco.bookservice.entities.Book;
import com.julieandco.bookservice.entities.Bookorder;
import com.julieandco.bookservice.entities.User;
import com.julieandco.bookservice.repo.BookRepository;
import com.julieandco.bookservice.repo.OrderRepository;
import com.julieandco.bookservice.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private final BookRepository bookRepository;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    @Autowired
    public OrderService(BookRepository bookRepository, OrderRepository orderRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void addOrder(Book orderedBook, User user){
        Book bookel=bookRepository.findBookByTitle(orderedBook.getTitle());
        Bookorder newOrder;
        newOrder = new Bookorder();
        if(bookel==null){
            System.out.println("The book doesn't exist. Cannot create an order\n");
            orderRepository.delete(newOrder);
        }

        else if(orderedBook.getAvailability()) {
            newOrder = new Bookorder(bookel, user);
            orderRepository.save(newOrder);
        }

        else{
            newOrder.setSubmitted(false);
            System.out.println("You are in waiting list \n");
        }
    }
    //@Transactional


    @Transactional(readOnly = true)
    public List<Bookorder> getAllOrders() {
        return orderRepository.findAll();
    }
}
