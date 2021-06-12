package com.alexande.realestateexam.service;

import com.alexande.realestateexam.dao.UserRepository;
import com.alexande.realestateexam.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUser(String email) {
        User theUser = userRepository.findByEmail(email);
        if (theUser == null) {
            return createUser(email);
        }
        return theUser;
    }

    @Override
    public User createUser(String email) {
        User user = new User();
        user.setEmail(email);
        // set up the default question and Date
        int dailyPractice = 150;
        user.setDailyPractice(dailyPractice);

        Date date = new Date();
        user.setExamDate(date);
        user.setStartDate(date);
        userRepository.save(user);
        return user;
    }

    @Override
    public User updatePractice(String email, int date) {
        User user = userRepository.findByEmail(email);
        user.setDailyPractice(date);
        userRepository.save(user);
        return user;
    }
}
