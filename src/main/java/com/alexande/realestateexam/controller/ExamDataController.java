package com.alexande.realestateexam.controller;

import com.alexande.realestateexam.entity.Exam;
import com.alexande.realestateexam.entity.ExamData;
import com.alexande.realestateexam.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RequestMapping("/api/examData")
@RestController
public class ExamDataController {

    @Autowired
    private ExamService examService;

    @GetMapping("/getExamData")
    public List<ExamData> getExamData(@RequestParam("uid") String uid) {
        return examService.getExamData(uid);
    }

    @GetMapping("/getExamListById")
    public List<Exam> getExamListById(@RequestParam("id") Long id) {
        return examService.getExamListById(id);
    }
}
