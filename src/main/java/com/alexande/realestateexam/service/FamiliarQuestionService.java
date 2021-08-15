package com.alexande.realestateexam.service;

import com.alexande.realestateexam.dto.Familiarity;
import com.alexande.realestateexam.entity.FamiliarQuestion;
import com.alexande.realestateexam.entity.Question;

import java.util.List;

public interface FamiliarQuestionService {
    List<FamiliarQuestion> addFamiliarQuestion(Familiarity familiarity);
    List<FamiliarQuestion> findUserFamiliarQuestion(String uid, Long cid);
    List<FamiliarQuestion> deleteFamiliarQuestion(String uid, Long cid, Long qid);
}
