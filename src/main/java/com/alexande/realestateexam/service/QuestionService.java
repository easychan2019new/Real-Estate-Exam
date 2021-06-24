package com.alexande.realestateexam.service;

import com.alexande.realestateexam.entity.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionService {
    List<Question> findAll();

    Optional<Question> findById(Long id);

    List<Question> findByCategoryId(int id);

    List<Question> findForQuiz();
}
