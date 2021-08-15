package com.alexande.realestateexam.service;

import com.alexande.realestateexam.entity.QuestionCategory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionCategoryService {
    List<QuestionCategory> findAll();
    QuestionCategory findByCategoryName(String category);
}
