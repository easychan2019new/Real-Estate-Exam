package com.alexande.realestateexam.service;

import com.alexande.realestateexam.dao.QuestionCategoryRepository;
import com.alexande.realestateexam.entity.Question;
import com.alexande.realestateexam.entity.QuestionCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionCategoryServiceImpl implements QuestionCategoryService{

    @Autowired
    private QuestionCategoryRepository questionCategoryRepository;

    @Override
    public QuestionCategory findByCategoryName(String name) {
        return questionCategoryRepository.findByCategoryName(name);
    }
}
