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

    @PutMapping("/updateDailyPractice")
    public User updatePractice(@RequestParam("email") String email,
                               @RequestParam("practice") int dailyPractice) {
        return userService.updatePractice(email, dailyPractice);
    }

    @PutMapping("/updatePracticeStartDate")
    public User updatePracticeStartDate(@RequestParam("email") String email,
                               @RequestParam("date") String practiceDate) {
        return userService.updatePracticeStartDate(email, practiceDate);
    }

    @PutMapping("/updateExamStartDate")
    public User updateExamStartDate(@RequestParam("email") String email,
                                        @RequestParam("date") String examDate) {
        return userService.updateExamStartDate(email, examDate);
    }
}
