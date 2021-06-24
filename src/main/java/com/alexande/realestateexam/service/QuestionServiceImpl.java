package com.alexande.realestateexam.service;

import com.alexande.realestateexam.dao.QuestionRepository;
import com.alexande.realestateexam.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public List<Question> findAll() {
        List<Question> list = questionRepository.findAll();
        return list;
    }

    @Override
    public Question findById(int id) {

        Question q = questionRepository.getQuestion(id);
        return q;
    }

    @Override
    public List<Question> findForQuiz() {
        List<Question> list = questionRepository.findForQuiz();
        return list;
    }

    @Override
    public List<Question> findByCategoryId(int id) {
        List<Question> list = questionRepository.findByCategoryId(id);
        return list;
    }

//    @Override
//    public List<Question> findByCategoryName(String category) {
//        List<Question> list = questionRepository.findByQuestionCategoryName(category);
//        return list;
//    }
}
