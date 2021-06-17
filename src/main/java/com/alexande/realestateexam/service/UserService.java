package com.alexande.realestateexam.service;

import com.alexande.realestateexam.entity.User;

public interface UserService {
    User findUser(String uid);
    User createUser(String uid);
    User updatePractice(String uid, int dailyPractice);
    User updatePracticeStartDate(String uid, String practiceStartDate);
    User updateExamStartDate(String uid, String examStartDate);
}
