package com.alexande.realestateexam.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
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

    @Column(name = "score")
    private int examScore;

//    @ManyToOne()
//    @JoinColumn(name = "user_id")
//    //@JsonIgnoreProperties({"examList"})
//    @JsonIgnore
//    private User examOwner;

    @ManyToOne()
    @JoinColumn(name = "exam_data_id")
    //@JsonIgnoreProperties({"examList"})
    @JsonIgnore
    private ExamData examDataOwner;

    @OneToMany(mappedBy = "exam", cascade = CascadeType.ALL)
    @JsonIgnore
    Set<ExamQuestion> examQuestions = new HashSet<ExamQuestion>();
}
