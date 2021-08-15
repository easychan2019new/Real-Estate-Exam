package com.alexande.realestateexam.service;

import com.alexande.realestateexam.dao.FamiliarQuestionRepository;
import com.alexande.realestateexam.dao.QuestionCategoryRepository;
import com.alexande.realestateexam.dao.QuestionRepository;
import com.alexande.realestateexam.dao.UserRepository;
import com.alexande.realestateexam.dto.Familiarity;
import com.alexande.realestateexam.entity.FamiliarQuestion;
import com.alexande.realestateexam.entity.Question;
import com.alexande.realestateexam.entity.QuestionCategory;
import com.alexande.realestateexam.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FamiliarQuestionServiceImpl implements FamiliarQuestionService {

    private static Logger LOGGER = LoggerFactory.getLogger(FamiliarQuestionServiceImpl.class);

    @Autowired
    private FamiliarQuestionRepository familiarQuestionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private QuestionCategoryRepository questionCategoryRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public List<FamiliarQuestion> addFamiliarQuestion(Familiarity familiarity) {
        User user = userRepository.findByUid(familiarity.getUid());
//        LOGGER.info("Hello from so");
//        LOGGER.info(familiarity.getUid());
//        LOGGER.info(familiarity.getStatus());
//        LOGGER.info(familiarity.getCategoryId().toString());
//        LOGGER.info(familiarity.getQuestionId().toString());
        if(user == null) LOGGER.info("Why?");
        Long userId = user.getId();
        QuestionCategory category = questionCategoryRepository.findQuestionCategoryById(familiarity.getCategoryId());
        Long categoryId = category.getId();
        Question question = questionRepository.findQuestionById(familiarity.getQuestionId());
        Long questionId = question.getId();

        FamiliarQuestion fq = familiarQuestionRepository.findByUserIdAndCategoryIdAndQuestionId(
                userId, categoryId, questionId);

        if(fq == null) {
            LOGGER.info("Hello from so");
            fq = new FamiliarQuestion(user, category, question, familiarity.getStatus());
        } else {
            fq.setStatus(familiarity.getStatus());
        }

        familiarQuestionRepository.save(fq);
        return familiarQuestionRepository.findByUserIdAndCategoryId(userId,categoryId);
    }

    @Override
    public List<FamiliarQuestion> findUserFamiliarQuestion(String uid, Long cid) {
        User user = userRepository.findByUid(uid);
        Long userId = user.getId();
        return familiarQuestionRepository.findByUserIdAndCategoryId(userId, cid);
    }

    @Override
    public List<FamiliarQuestion> deleteFamiliarQuestion(String uid, Long cid, Long qid) {
        User user = userRepository.findByUid(uid);
        Long userId = user.getId();
        FamiliarQuestion target = familiarQuestionRepository.findByUserIdAndCategoryIdAndQuestionId(userId, cid, qid);
        familiarQuestionRepository.delete(target);
        return familiarQuestionRepository.findByUserIdAndCategoryId(userId, cid);
    }
}
