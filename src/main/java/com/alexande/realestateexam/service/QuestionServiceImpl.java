package com.alexande.realestateexam.service;

import com.alexande.realestateexam.dao.QuestionRepository;
import com.alexande.realestateexam.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Set;

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
    public List<Question> findForExam() {
        List<Question> list = questionRepository.findForExam();
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
