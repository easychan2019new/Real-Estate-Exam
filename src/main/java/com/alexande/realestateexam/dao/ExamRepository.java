package com.alexande.realestateexam.dao;

import com.alexande.realestateexam.dto.DoExam;
import com.alexande.realestateexam.entity.Exam;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface ExamRepository {
    void saveExam(DoExam doExam);
    List<Exam> findByUid(String uid);
}
