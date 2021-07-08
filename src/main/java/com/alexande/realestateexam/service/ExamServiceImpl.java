package com.alexande.realestateexam.service;

import com.alexande.realestateexam.dao.ExamRepository;
import com.alexande.realestateexam.dao.QuestionRepository;
import com.alexande.realestateexam.dao.UserRepository;
import com.alexande.realestateexam.dto.DoExam;
import com.alexande.realestateexam.dto.RecordQuestion;
import com.alexande.realestateexam.entity.Exam;
import com.alexande.realestateexam.entity.ExamQuestion;
import com.alexande.realestateexam.entity.Question;
import com.alexande.realestateexam.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ExamRepository examRepository;

    @Override
    @Transactional
    public void saveExam(DoExam doExam) {
        User user = userRepository.findByUid(doExam.getUid());
        List<Exam> examList = user.getExamList();
        // create new exam
        Exam exam = new Exam();
        exam.setExamDate(new Date());
        exam.setExamScore(doExam.getScore());
        exam.setExamOwner(user);
        // populate the record to our exam
        List<RecordQuestion> questionList = doExam.getRecordQuestions();
        Set<ExamQuestion> questionSet = exam.getExamQuestions();

        for (RecordQuestion rq: questionList) {
            Question q = questionRepository.getQuestion(rq.getQid());
            String usersChoice = rq.getChoice();
            ExamQuestion eq = new ExamQuestion(exam, q, usersChoice);
            questionSet.add(eq);
        }

        examList.add(exam);
        userRepository.save(user);
    }

    @Override
    public List<Exam> findExam(String uid) {
        User user = userRepository.findByUid(uid);
        return user.getExamList();
    }

    @Override
    public Set<ExamQuestion> findExamDetail(int eid) {
        Exam exam = examRepository.getExam(eid);
        return exam.getExamQuestions();
    }
}
