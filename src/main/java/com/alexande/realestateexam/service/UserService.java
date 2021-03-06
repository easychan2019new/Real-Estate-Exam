package com.alexande.realestateexam.service;

import com.alexande.realestateexam.entity.Dictionary;
import com.alexande.realestateexam.entity.Question;
import com.alexande.realestateexam.entity.User;

import java.util.List;

public interface UserService {
    User findUser(String uid);
    User createUser(String uid);
    User updateTargetPractice(String uid, int targetPractice);
    User updatePracticeStartDate(String uid, String practiceStartDate);
    User setNullPracticeStartDate(String uid);
    User updateExamStartDate(String uid, String examStartDate);
    User updateUserMembership(String uid, String membership);
    User setNullExamStartDate(String uid);
    User setUserNotification(String uid, String token);

    // handle question
    User saveQuestion(String uid, int qid);
    User deleteQuestion(String uid, int qid);
    List<Question> getSavedQuestion(String uid);
    List<Long> getSavedQuestionId(String uid);

    // handle dictionary
    List<Dictionary> saveDictionary(String uid, Long did);
    List<Dictionary> deleteDictionary(String uid, Long did);
    List<Dictionary> getSavedDictionary(String uid);
    List<Long> getSavedDictionaryId(String uid);

    User addPractice(String uid);
}
