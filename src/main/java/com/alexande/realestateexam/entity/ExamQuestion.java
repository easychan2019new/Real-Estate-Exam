package com.alexande.realestateexam.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "exam_question")
@Getter
@Setter
public class ExamQuestion {

    public ExamQuestion() {};

    public ExamQuestion(Exam e, Question q, String s) {
        this.exam = e;
        this.question = q;
        this.userChoice = s;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "exam_id")
    @JsonIgnore
    private Exam exam;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @Column(name = "user_choice")
    private String userChoice;

}
