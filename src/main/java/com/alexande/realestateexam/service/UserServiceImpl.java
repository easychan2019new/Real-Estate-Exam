package com.alexande.realestateexam.service;

import com.alexande.realestateexam.dao.QuestionRepository;
import com.alexande.realestateexam.dao.UserRepository;
import com.alexande.realestateexam.entity.Question;
import com.alexande.realestateexam.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public User findUser(String uid) {
        User theUser = userRepository.findByUid(uid);
        return theUser;
    }

    @Override
    @Transactional
    public User createUser(String uid) {
        User user = new User();
        user.setUid(uid);
        // set up the default value
        user.setDailyPractice(0);
        user.setTargetPractice(150);
        user.setTotalPractice(0);
        user.setExamStartDate(new Date());
        user.setPracticeStartDate(new Date());
        user.setMembership(false);

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
        user.setExamStartDate(date);
        userRepository.save(user);
        return user;
    }

    @Override
    public User saveQuestion(String uid, int qid) {
        User user = userRepository.findByUid(uid);
        Question question = questionRepository.getQuestion(qid);
        if (!user.getSaveList().contains(question)) {
            user.getSaveList().add(question);
        }
        userRepository.save(user);
        return user;
    }

    @Override
    public User deleteQuestion(String uid, int qid) {
        User user = userRepository.findByUid(uid);
        Question question = questionRepository.getQuestion(qid);
        user.getSaveList().remove(question);
        userRepository.save(user);
        return user;
    }
}
