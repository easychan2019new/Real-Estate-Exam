package com.alexande.realestateexam.dao;

import com.alexande.realestateexam.entity.ExamData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface ExamDataRepository extends JpaRepository<ExamData, Long> {

    ExamData findExamDataById(Long id);
}
