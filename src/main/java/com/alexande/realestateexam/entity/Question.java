package com.alexande.realestateexam.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "question")
@Data
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "question_type")
    private String questionType;

    @Column(name = "question_name")
    private String questionName;

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

    @ManyToMany(mappedBy = "saveList")
    @JsonIgnore
    Set<User> targetUser;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    @JsonIgnore
    Set<ExamQuestion> examQuestions  = new HashSet<ExamQuestion>();

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<FamiliarQuestion> familiarQuestionList = new ArrayList<>();
}
