package com.alexande.realestateexam.service;

import com.alexande.realestateexam.entity.User;

public interface UserService {
    User findUser(String email);
    User createUser(String email);
    User updatePractice(String email, int date);
}
