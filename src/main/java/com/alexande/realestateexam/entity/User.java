package com.alexande.realestateexam.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "membership")
    private boolean membership;

    @Column(name = "daily_practice")
    private int dailyPractice;

    @Column(name = "target_practice")
    private int targetPractice;

    @Column(name = "total_practice")
    private int totalPractice;

    @Column(name = "exam_start_date")
    @JsonFormat(timezone = "EST+8", pattern = "yyyy-MM-dd")
    private Date examStartDate;

    @Column(name = "practice_start_date")
    @JsonFormat(timezone = "EST+8", pattern = "yyyy-MM-dd")
    private Date practiceStartDate;

    @Column(name = "uid", nullable = false)
    private String uid;

    @ManyToMany
    @JoinTable(
            name = "question_saved",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "question_id")
    )
    private Set<Question> saveList;

//    public void saveQuestion(Question questionSaved) {
//        if (saveList == null) {
//            saveList = new HashSet<>();
//        }
//        saveList.add(questionSaved);
//        questionSaved.setUser(this);
//    }
}
