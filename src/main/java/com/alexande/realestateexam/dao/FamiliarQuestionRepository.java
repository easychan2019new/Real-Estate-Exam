package com.alexande.realestateexam.dao;

import com.alexande.realestateexam.entity.FamiliarQuestion;
import com.alexande.realestateexam.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface FamiliarQuestionRepository extends JpaRepository<FamiliarQuestion, Long> {
    List<FamiliarQuestion> findByUserIdAndCategoryId(Long uid, Long cid);
    FamiliarQuestion findByUserIdAndCategoryIdAndQuestionId(Long uid, Long cid, Long qid);
}
