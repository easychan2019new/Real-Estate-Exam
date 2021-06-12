package com.alexande.realestateexam.controller;

import com.alexande.realestateexam.entity.User;
import com.alexande.realestateexam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/findUser")
    public User findUser(@RequestParam("email") String theEmail) {
        return userService.findUser(theEmail);
    }

    @PutMapping("/updatePractice")
    public User updatePractice(@RequestParam("email") String email,
                               @RequestParam("date") int date) {
        return userService.updatePractice(email, date);
    }
}
