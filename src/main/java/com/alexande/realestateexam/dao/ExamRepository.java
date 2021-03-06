package com.alexande.realestateexam.dao;

import com.alexande.realestateexam.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface ExamRepository extends JpaRepository<Exam, Long> {
    Exam findExamById(Long eid);
}
