package com.alexande.realestateexam.controller;

import com.alexande.realestateexam.dto.DoExam;
import com.alexande.realestateexam.entity.Exam;
import com.alexande.realestateexam.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/exams")
@RestController
public class ExamController {

    @Autowired
    private ExamService examService;

    @PostMapping("/saveExam")
    public void placeOrder(@RequestBody DoExam doExam) {
        examService.saveExam(doExam);
    }

    @GetMapping("/findExam")
    public List<Exam> findExam(@RequestParam("uid") String uid) {
        return examService.findExam(uid);
    }

}
