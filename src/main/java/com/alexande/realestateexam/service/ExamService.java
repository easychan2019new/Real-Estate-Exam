package com.alexande.realestateexam.service;

import com.alexande.realestateexam.dto.DoExam;
import com.alexande.realestateexam.entity.Exam;

import java.util.List;

public interface ExamService {
    void saveExam(DoExam doExam);
    List<Exam> findExam(String uid);
}
