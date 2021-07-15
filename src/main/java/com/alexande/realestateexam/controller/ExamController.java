package com.alexande.realestateexam.controller;

import com.alexande.realestateexam.dto.DoExam;
import com.alexande.realestateexam.entity.ExamQuestion;
import com.alexande.realestateexam.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RequestMapping("/api/exams")
@RestController
public class ExamController {

    @Autowired
    private ExamService examService;

    @PostMapping("/saveExam")
    public void placeOrder(@RequestBody DoExam doExam) {
        examService.saveExam(doExam);
    }

    @GetMapping("/findExamDetail")
    public Set<ExamQuestion> findExamDetail(@RequestParam("eid") Long eid) {
        return examService.findExamDetail(eid);
    }

}
