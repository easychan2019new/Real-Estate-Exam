package com.alexande.realestateexam.service;

import com.alexande.realestateexam.dao.QuestionRepository;
import com.alexande.realestateexam.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    @Override
    public Question findById(int id) {

        return questionRepository.getQuestion(id);
    }

    @Override
    public List<Question> findForQuiz() {
        return questionRepository.findForQuiz();
    }

    @Override
    public List<Question> findForExam() {
        return questionRepository.findForExam();
    }

    @Override
    public List<Question> findByCategoryId(int id) {
        return questionRepository.findByCategoryId(id);
    }

//    @Override
//    public List<Question> findByCategoryName(String category) {
//        List<Question> list = questionRepository.findByQuestionCategoryName(category);
//        return list;
//    }
}
