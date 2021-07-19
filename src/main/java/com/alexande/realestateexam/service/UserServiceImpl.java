package com.alexande.realestateexam.service;

import com.alexande.realestateexam.dao.DictionaryRepository;
import com.alexande.realestateexam.dao.QuestionRepository;
import com.alexande.realestateexam.dao.UserRepository;
import com.alexande.realestateexam.entity.Dictionary;
import com.alexande.realestateexam.entity.Question;
import com.alexande.realestateexam.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private DictionaryRepository dictionaryRepository;

    @Override
    public User findUser(String uid) {
        return userRepository.findByUid(uid);
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
        user.setRegisterDate(new Date());
        user.setMembership(false);

        userRepository.save(user);
        return user;
    }

    @Override
    public User updateTargetPractice(String uid, int targetPractice) {
        User user = userRepository.findByUid(uid);
        user.setTargetPractice(targetPractice);
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
    public User setNullPracticeStartDate(String uid) {
        User user = userRepository.findByUid(uid);
        user.setPracticeStartDate(null);
        return user;
    }

    @Override
    public User updateExamStartDate(String uid, String examStartDate) {
        User user = userRepository.findByUid(uid);
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
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
    public User setNullExamStartDate(String uid) {
        User user = userRepository.findByUid(uid);
        user.setExamStartDate(null);
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

    @Override
    public List<Question> getSavedQuestion(String uid) {
        User user = userRepository.findByUid(uid);
        return user.getSaveList();
    }

    @Override
    public List<Long> getSavedQuestionId(String uid) {
        User user = userRepository.findByUid(uid);
        List<Question> questionList = user.getSaveList();
        List<Long> questionID = new LinkedList<>();
        for(Question question: questionList) {
            questionID.add(question.getId());
        }
        return questionID;
    }

    @Override
    public User saveDictionary(String uid, Long did) {
        User user = userRepository.findByUid(uid);
        Dictionary dictionary = dictionaryRepository.findDictionaryById(did);
        if (!user.getDictionaryList().contains(dictionary)) {
            user.getDictionaryList().add(dictionary);
        }
        userRepository.save(user);
        return user;
    }

    @Override
    public User deleteDictionary(String uid, Long did) {
        User user = userRepository.findByUid(uid);
        Dictionary dictionary = dictionaryRepository.findDictionaryById(did);
        user.getDictionaryList().remove(dictionary);
        userRepository.save(user);
        return user;
    }

    @Override
    public List<Dictionary> getSavedDictionary(String uid) {
        User user = userRepository.findByUid(uid);
        return user.getDictionaryList();
    }

    @Override
    public List<Long> getSavedDictionaryId(String uid) {
        User user = userRepository.findByUid(uid);
        List<Dictionary> dictionaryList = user.getDictionaryList();
        List<Long> dictionaryId = new LinkedList<>();
        for(Dictionary dictionary: dictionaryList) {
            dictionaryId.add(dictionary.getId());
        }
        return dictionaryId;
    }

    @Override
    public String addPractice(String uid) {
        try {
            User user = userRepository.findByUid(uid);
            user.setDailyPractice(user.getDailyPractice() + 1);
            user.setTotalPractice(user.getTotalPractice() + 1);
            userRepository.save(user);
        } catch (Exception e) {
            return "add Practice fail!";
        }

        return "add Practice successful!";
    }
}
