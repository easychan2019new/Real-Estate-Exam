package com.alexande.realestateexam.controller;


import com.alexande.realestateexam.entity.Question;
import com.alexande.realestateexam.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public Question findById(@RequestParam("id") int id) {
        return questionService.findById(id);
    }

    @GetMapping("/findForQuiz")
    public List<Question> findForQuiz() {
        return questionService.findForQuiz();
    }

    @GetMapping("/findForExam")
    public List<Question> findForExam() {
        return questionService.findForExam();
    }

    @GetMapping("/findByCategoryId")
    public List<Question> findByCategoryId(@RequestParam("id") int id) {
        return questionService.findByCategoryId(id);
    }

    @GetMapping("/findForCategory")
    public List<Question> findForCategory(@RequestParam("id") int id) {
        return questionService.findForCategory(id);
    }
}
