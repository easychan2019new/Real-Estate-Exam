package com.alexande.realestateexam.dao;

import com.alexande.realestateexam.entity.Question;
import com.alexande.realestateexam.entity.QuestionCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RepositoryRestResource
public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findAll();

    List<Question> findByCategoryId(int id);

    //@Query(value = "SELECT u FROM Question u ORDER BY id")
    @Query(value = "SELECT * FROM question ORDER BY RAND() LIMIT 2", nativeQuery = true)
    List<Question> findForExam();
}
