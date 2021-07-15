package com.alexande.realestateexam.service;

import com.alexande.realestateexam.dao.ExamDataRepository;
import com.alexande.realestateexam.dao.ExamRepository;
import com.alexande.realestateexam.dao.QuestionRepository;
import com.alexande.realestateexam.dao.UserRepository;
import com.alexande.realestateexam.dto.DoExam;
import com.alexande.realestateexam.dto.RecordQuestion;
import com.alexande.realestateexam.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Logger;

@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private ExamDataRepository examDataRepository;

    Logger log = Logger.getLogger("test_log");

    @Override
    @Transactional
    public void saveExam(DoExam doExam) {
        User user = userRepository.findByUid(doExam.getUid());
        List<ExamData> examDataList = user.getExamDataList();
        ExamData today = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" );
        String s = doExam.getDate();

        // convert input String to Date
        Date targetDate = null;
        try {
            targetDate = sdf.parse(s);
        } catch (Exception e) {
            return;
        }

        // check if we already have the record on that day
        // unstable version 1
        if (examDataList.size() == 0 ||
            !examDataList.get(examDataList.size() - 1).getExamDate().toString().substring(0, 10).equals(doExam.getDate()))
        {
            today = new ExamData();
            today.setExamDate(targetDate);
            today.setExamOwner(user);
            today.setLowestScore(doExam.getScore());
            today.setHighestScore(doExam.getScore());
            examDataList.add(today);
        } else {
            today = examDataList.get(examDataList.size() - 1);
            // update the lowest and highest score of that day
            if (today.getLowestScore() > doExam.getScore()) today.setLowestScore(doExam.getScore());
            if (today.getHighestScore() < doExam.getScore()) today.setHighestScore(doExam.getScore());
        }
//
//
//        // stable version 2
//        for (int i = 0; i < examDataList.size(); i++) {
//            ExamData tempDay = examDataList.get(i);
//            String a = tempDay.getExamDate().toString().substring(0,10);
//            String b = doExam.getDate();
////            log.info(a);
////            log.info(b);
////            if (a.equals(b)) {
////                log.info("true");
////            } else {
////                log.info("false");
////            }
//            if(a.equals(b)) {
//                today = tempDay;
//                // update the lowest and highest score of that day
//                if (today.getLowestScore() > doExam.getScore()) today.setLowestScore(doExam.getScore());
//                if (today.getHighestScore() < doExam.getScore()) today.setHighestScore(doExam.getScore());
//                break;
//            }
//        }
//
//        if (today == null) {
//            today = new ExamData();
//            today.setExamDate(targetDate);
//            today.setExamOwner(user);
//            today.setLowestScore(doExam.getScore());
//            today.setHighestScore(doExam.getScore());
//            examDataList.add(today);
//        }


        List<Exam> examList = today.getExamList();
        // create new exam
        Exam exam = new Exam();
        exam.setExamScore(doExam.getScore());
        exam.setExamDataOwner(today);
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
    public List<ExamData> getExamData(String uid) {
        User user = userRepository.findByUid(uid);
        return user.getExamDataList();
    }

    @Override
    public List<Exam> getExamListById(Long id) {
        ExamData curDate = examDataRepository.findExamDataById(id);
        return curDate.getExamList();
    }

    @Override
    public Set<ExamQuestion> findExamDetail(Long eid) {
        Exam exam = examRepository.findExamById(eid);
        return exam.getExamQuestions();
    }

}

