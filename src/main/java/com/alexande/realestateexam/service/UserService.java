package com.alexande.realestateexam.service;

import com.alexande.realestateexam.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User findUser(String uid);
    User createUser(String uid);
    User updatePractice(String uid, int dailyPractice);
    User updatePracticeStartDate(String uid, String practiceStartDate);
    User updateExamStartDate(String uid, String examStartDate);
}
