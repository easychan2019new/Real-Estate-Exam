package com.alexande.realestateexam.controller;


import com.alexande.realestateexam.dao.QuestionRepository;
import com.alexande.realestateexam.entity.Question;
import com.alexande.realestateexam.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RequestMapping("/api/questions")
@RestController
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/findAll")
    public List<Question> findAll() {
        return questionService.findAll();
    }

    @GetMapping("/findForExam")
    public List<Question> findForExam() {
        return questionService.findForExam();
    }
}
