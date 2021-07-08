package com.alexande.realestateexam.dao;

import com.alexande.realestateexam.entity.Exam;
import com.alexande.realestateexam.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface ExamRepository extends JpaRepository<Exam, Long> {

    @Query(value = "SELECT * FROM exam WHERE id = :#{#id}", nativeQuery = true)
    Exam getExam(@Param("id") int id);
}
