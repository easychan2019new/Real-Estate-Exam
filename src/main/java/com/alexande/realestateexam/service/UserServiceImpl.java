package com.alexande.realestateexam.service;

import com.alexande.realestateexam.dao.UserRepository;
import com.alexande.realestateexam.entity.User;
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
    public User findUser(String uid) {
        User theUser = userRepository.findByUid(uid);
        if (theUser == null) {
            return createUser(uid);
        }
        return theUser;
    }

    @Override
    public User createUser(String uid) {
        User user = new User();
        user.setUid(uid);
        // set up the default firstName and lastName
        user.setName("BestGuy");
        // set up the default question and Date
        int dailyPractice = 150;
        user.setDailyPractice(dailyPractice);
        user.setEmail("sample@mail.com");
        Date date = new Date();
        user.setExamDate(date);
        user.setPracticeStartDate(date);
        // set up default membership

        userRepository.save(user);
        return user;
    }

    @Override
    public User updatePractice(String uid, int dailyPractice) {
        User user = userRepository.findByUid(uid);
        user.setDailyPractice(dailyPractice);
        userRepository.save(user);
        return user;
    }

    @Override
    public User updatePracticeStartDate(String uid, String practiceStartDate) {
        User user = userRepository.findByUid(uid);
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
    public User updateExamStartDate(String uid, String examStartDate) {
        User user = userRepository.findByUid(uid);
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
