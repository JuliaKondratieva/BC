package com.julieandco.bookservice.controller;

import com.julieandco.bookservice.entities.dto.UserDTO;
import com.julieandco.bookservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public @ResponseBody
    UserDTO getAllCustomers(){
        UserDTO usersDTO = new UserDTO();
        usersDTO.setUsers(userService.getAllUsers());
        return usersDTO;
    }
}
