package com.alexande.realestateexam.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "exam")
@Data
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date")
    @JsonFormat(timezone = "EST+8", pattern = "yyyy-MM-dd")
    private Date examDate;

    @Column(name = "score")
    private int examScore;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    //@JsonIgnoreProperties({"examList"})
    @JsonIgnore
    private User examOwner;

    @OneToMany(mappedBy = "exam", cascade = CascadeType.ALL)
    @JsonIgnore
    Set<ExamQuestion> examQuestions = new HashSet<ExamQuestion>();
}
