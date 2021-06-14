package com.alexande.realestateexam.service;

import com.alexande.realestateexam.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User findUser(String email);
    User createUser(String email);
    User updatePractice(String email, int dailyPractice);
    User updatePracticeStartDate(String email, String practiceStartDate);
    User updateExamStartDate(String email, String examStartDate);
}
