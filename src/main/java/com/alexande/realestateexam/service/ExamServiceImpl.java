package com.alexande.realestateexam.service;

import com.alexande.realestateexam.dao.ExamRepository;
import com.alexande.realestateexam.dao.QuestionRepository;
import com.alexande.realestateexam.dao.UserRepository;
import com.alexande.realestateexam.dto.DoExam;
import com.alexande.realestateexam.entity.Exam;
import com.alexande.realestateexam.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private QuestionRepository questionRepository;

//    @Autowired
//    private ExamRepository examRepository;

    @Override
    public void saveExam(DoExam doExam) {
        User user = userRepository.findByUid(doExam.getUid());
        List<Exam> examList = user.getExamList();
        Exam exam = new Exam();
        exam.setExamDate(new Date());
        exam.setExamScore(doExam.getScore());
        exam.setExamOwner(user);
        examList.add(exam);
        userRepository.save(user);
    }

    @Override
    public List<Exam> findExam(String uid) {
        User user = userRepository.findByUid(uid);
        return user.getExamList();
    }
}
