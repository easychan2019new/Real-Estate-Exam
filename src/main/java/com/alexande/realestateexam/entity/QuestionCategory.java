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
@Table(name = "question_category")
@Data
public class QuestionCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "item_number")
    private int itemNum;

    @Column(name = "lock_status")
    private boolean lockStatus;

    @OneToMany(mappedBy = "questionCategory", cascade = CascadeType.ALL)
    private List<Question> questionList;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<FamiliarQuestion> familiarQuestionList = new HashSet<>();
}