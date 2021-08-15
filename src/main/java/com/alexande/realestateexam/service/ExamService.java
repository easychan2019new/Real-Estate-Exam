package com.alexande.realestateexam.service;

import com.alexande.realestateexam.dto.DoExam;
import com.alexande.realestateexam.entity.Exam;
import com.alexande.realestateexam.entity.ExamData;
import com.alexande.realestateexam.entity.ExamQuestion;

import java.util.List;
import java.util.Set;


public interface ExamService {
    void saveExam(DoExam doExam);
    List<ExamData> getExamData(String uid);
    List<Exam> getExamListById(Long id);
    Set<ExamQuestion> findExamDetail(Long eid);
}
