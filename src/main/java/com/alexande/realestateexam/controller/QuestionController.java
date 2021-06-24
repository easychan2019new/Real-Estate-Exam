package com.alexande.realestateexam.controller;


import com.alexande.realestateexam.entity.Question;
import com.alexande.realestateexam.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/questions")
@RestController
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/findAll")
    public List<Question> findAll() {
        return questionService.findAll();
    }

    @GetMapping("/findById")
    public Optional<Question> findById(@RequestParam("id") Long id) {
        return questionService.findById(id);
    }

    @GetMapping("/findForQuiz")
    public List<Question> findForQuiz() {
        return questionService.findForQuiz();
    }

    @GetMapping("/findByCategoryId")
    public List<Question> findByCategoryId(@RequestParam("id") int id) {
        return questionService.findByCategoryId(id);
    }
}
