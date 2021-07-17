package com.alexande.realestateexam.service;

import com.alexande.realestateexam.entity.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionService {
    List<Question> findAll();

    Question findById(int id);

    List<Question> findByCategoryId(int id);

    List<Question> findForQuiz();

    List<Question> findForExam();
}
