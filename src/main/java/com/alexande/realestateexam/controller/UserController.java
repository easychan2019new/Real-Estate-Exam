package com.alexande.realestateexam.controller;

import com.alexande.realestateexam.entity.Dictionary;
import com.alexande.realestateexam.entity.Question;
import com.alexande.realestateexam.entity.User;
import com.alexande.realestateexam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/users")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/findUser")
    public User findUser(@RequestParam("uid") String uid) {

        return userService.findUser(uid);
    }

    @PutMapping("/updateTargetPractice")
    public User updateTargetPractice(@RequestParam("uid") String uid,
                               @RequestParam("practice") int targetPractice) {
        return userService.updateTargetPractice(uid, targetPractice);
    }

    @PutMapping("/updatePracticeStartDate")
    public User updatePracticeStartDate(@RequestParam("uid") String uid,
                               @RequestParam("date") String practiceDate) {
        return userService.updatePracticeStartDate(uid, practiceDate);
    }

    @PutMapping("/setNullPracticeStartDate")
    public User setNullPracticeStartDate(@RequestParam("uid") String uid) {
        return userService.setNullPracticeStartDate(uid);
    }

    @PutMapping("/updateExamStartDate")
    public User updateExamStartDate(@RequestParam("uid") String uid,
                                        @RequestParam("date") String examDate) {
        return userService.updateExamStartDate(uid, examDate);
    }

    @PutMapping("/updateUserMembership")
    public User updateUserMembership(@RequestParam("uid") String uid,
                                        @RequestParam("membership") String membership) {
        return userService.updateUserMembership(uid, membership);
    }

    @PutMapping("/setNullExamStartDate")
    public User setNullExamStartDate(@RequestParam("uid") String uid) {
        return userService.setNullExamStartDate(uid);
    }

    @PutMapping("/setUserNotification")
    public User setUserNotification(@RequestParam("uid") String uid,
                                        @RequestParam("token") String token) {
        return userService.setUserNotification(uid, token);
    }

    @PostMapping("/addPractice")
    public User addDailyPractice(@RequestParam("uid") String uid) {
        return userService.addPractice(uid);
    }

    @PostMapping("/createUser")
    public User createUser(@RequestParam("uid") String uid) {
        return userService.createUser(uid);
    }

    @PostMapping("/saveQuestion")
    public User saveQuestion(@RequestParam("uid") String uid,
                                @RequestParam("qid") int qid) {
        return userService.saveQuestion(uid, qid);
    }

    @PostMapping("/deleteQuestion")
    public User deleteQuestion(@RequestParam("uid") String uid,
                             @RequestParam("qid") int qid) {
        return userService.deleteQuestion(uid,qid);
    }

    @GetMapping("/getSavedQuestion")
    public List<Question> getSavedQuestion(@RequestParam("uid") String uid) {
        return userService.getSavedQuestion(uid);
    }

    @GetMapping("/getSavedQuestionId")
    public List<Long> getSavedQuestionId(@RequestParam("uid") String uid) {
        return userService.getSavedQuestionId(uid);
    }

    @PostMapping("/saveDictionary")
    public List<Long> saveDictionary(@RequestParam("uid") String uid,
                             @RequestParam("did") Long did) {
        userService.saveDictionary(uid, did);
        return userService.getSavedDictionaryId(uid);
    }

    @PostMapping("/deleteDictionary")
    public List<Long> deleteDictionary(@RequestParam("uid") String uid,
                               @RequestParam("did") Long did) {
        userService.deleteDictionary(uid, did);
        return userService.getSavedDictionaryId(uid);
    }

    @GetMapping("/getSavedDictionary")
    public List<Dictionary> getSavedDictionary(@RequestParam("uid") String uid) {
        return userService.getSavedDictionary(uid);
    }

    @GetMapping("/getSavedDictionaryId")
    public List<Long> getSavedDictionaryId(@RequestParam("uid") String uid) {
        return userService.getSavedDictionaryId(uid);
    }
}
