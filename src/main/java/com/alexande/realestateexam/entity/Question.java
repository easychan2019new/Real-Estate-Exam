package com.alexande.realestateexam.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "question")
@Data
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "question")
    private String question;

    @Column(name = "answer_1")
    private String answer_1;

    @Column(name = "answer_2")
    private String answer_2;

    @Column(name = "answer_3")
    private String answer_3;

    @Column(name = "answer_4")
    private String answer_4;

    @Column(name = "correct_answer")
    private String correct_ans;

    @Column(name = "lock_status")
    private boolean lockStatus;

    @Column(name = "category_id", insertable = false, updatable = false)
    private int categoryId;

    @ManyToOne()
    @JoinColumn(name = "category_id")
    //@JsonIgnoreProperties({"questionList"})
    @JsonIgnore
    private QuestionCategory questionCategory;

}