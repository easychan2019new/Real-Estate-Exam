package com.alexande.realestateexam.dao;

import com.alexande.realestateexam.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findAll();

    @Query(value = "SELECT * FROM question ORDER BY RAND() LIMIT 10", nativeQuery = true)
    List<Question> findForQuiz();

    @Query(value = "SELECT * FROM question WHERE category_id = :#{#id} ORDER BY RAND() LIMIT 2", nativeQuery = true)
    List<Question> findByCategoryId(@Param("id") int id);

}
