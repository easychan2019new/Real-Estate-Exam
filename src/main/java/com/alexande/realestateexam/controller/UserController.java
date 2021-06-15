package com.alexande.realestateexam.controller;

import com.alexande.realestateexam.entity.User;
import com.alexande.realestateexam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/users")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/findUser")
    public User findUser(@RequestParam("uid") String uid) {
        return userService.findUser(uid);
    }

    @PutMapping("/updateDailyPractice")
    public User updatePractice(@RequestParam("uid") String uid,
                               @RequestParam("practice") int dailyPractice) {
        return userService.updatePractice(uid, dailyPractice);
    }

    @PutMapping("/updatePracticeStartDate")
    public User updatePracticeStartDate(@RequestParam("uid") String uid,
                               @RequestParam("date") String practiceDate) {
        return userService.updatePracticeStartDate(uid, practiceDate);
    }

    @PutMapping("/updateExamStartDate")
    public User updateExamStartDate(@RequestParam("uid") String uid,
                                        @RequestParam("date") String examDate) {
        return userService.updateExamStartDate(uid, examDate);
    }
}
