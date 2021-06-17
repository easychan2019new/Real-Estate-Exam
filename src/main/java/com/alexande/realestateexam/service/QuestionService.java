package com.alexande.realestateexam.service;

import com.alexande.realestateexam.entity.Question;

import java.util.List;
import java.util.Set;

public interface QuestionService {
    List<Question> findAll();

    List<Question> findByCategoryId(int id);
}
