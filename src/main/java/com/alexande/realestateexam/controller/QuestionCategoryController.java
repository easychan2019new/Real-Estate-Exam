package com.alexande.realestateexam.controller;

import com.alexande.realestateexam.entity.QuestionCategory;
import com.alexande.realestateexam.service.QuestionCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/questionCategories")
@RestController
public class QuestionCategoryController {

    @Autowired
    private QuestionCategoryService questionCategoryService;

    @RequestMapping("findByName")
    public QuestionCategory findByName(@RequestParam("name") String name) {
        return questionCategoryService.findByCategoryName(name);
    }
}
