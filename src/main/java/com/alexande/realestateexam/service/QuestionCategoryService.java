package com.alexande.realestateexam.service;

import com.alexande.realestateexam.entity.Question;
import com.alexande.realestateexam.entity.QuestionCategory;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionCategoryService {
    QuestionCategory findByCategoryName(String category);
}
