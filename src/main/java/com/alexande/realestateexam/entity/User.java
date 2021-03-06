package com.alexande.realestateexam.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "membership")
    private String membership;

    @Column(name = "daily_practice")
    private int dailyPractice;

    @Column(name = "target_practice")
    private int targetPractice;

    @Column(name = "total_practice")
    private int totalPractice;

    @Column(name = "exam_start_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date examStartDate;

    @Column(name = "practice_start_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date practiceStartDate;

    @Column(name = "register_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date registerDate;

    @Column(name = "total_study_day")
    private int totalStudyDay;

    @Column(name = "token")
    private String token;

    @Column(name = "uid", nullable = false)
    private String uid;

    @ManyToMany
    @JoinTable(
            name = "question_saved",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "question_id")
    )
    @JsonIgnore
    private List<Question> saveList;


    @ManyToMany
    @JoinTable(
            name = "dictionary_saved",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "dictionary_id")
    )
    @JsonIgnore
    private List<Dictionary> dictionaryList;

    @OneToMany(mappedBy = "examOwner", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ExamData> examDataList = new ArrayList<>();


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<FamiliarQuestion> familiarQuestionList = new HashSet<>();
}
