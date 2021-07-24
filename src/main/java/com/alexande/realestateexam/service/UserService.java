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
    User setNullExamStartDate(String uid);

    // handle question
    User saveQuestion(String uid, int qid);
    User deleteQuestion(String uid, int qid);
    List<Question> getSavedQuestion(String uid);
    List<Long> getSavedQuestionId(String uid);

    // handle dictionary
    User saveDictionary(String uid, Long did);
    User deleteDictionary(String uid, Long did);
    List<Dictionary> getSavedDictionary(String uid);
    List<Long> getSavedDictionaryId(String uid);

    User addPractice(String uid);
}
