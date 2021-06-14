package com.alexande.realestateexam.service;

import com.alexande.realestateexam.dao.UserRepository;
import com.alexande.realestateexam.entity.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        // set up the default firstName and lastName
        user.setFirstName("Best");
        user.setLastName("Guy");
        // set up the default question and Date
        int dailyPractice = 150;
        user.setDailyPractice(dailyPractice);
        Date date = new Date();
        user.setExamDate(date);
        user.setPracticeStartDate(date);
        // set up default membership

        userRepository.save(user);
        return user;
    }

    @Override
    public User updatePractice(String email, int dailyPractice) {
        User user = userRepository.findByEmail(email);
        user.setDailyPractice(dailyPractice);
        userRepository.save(user);
        return user;
    }

    @Override
    public User updatePracticeStartDate(String email, String practiceStartDate) {
        User user = userRepository.findByEmail(email);
        DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
            date = fmt.parse(practiceStartDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setPracticeStartDate(date);
        userRepository.save(user);
        return user;
    }

    @Override
    public User updateExamStartDate(String email, String examStartDate) {
        User user = userRepository.findByEmail(email);
        DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
            date = fmt.parse(examStartDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setExamDate(date);
        userRepository.save(user);
        return user;
    }
}
