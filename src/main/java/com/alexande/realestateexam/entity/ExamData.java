package com.alexande.realestateexam.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "exam_data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date examDate;

    @Column(name = "score_low")
    private int lowestScore;

    @Column(name = "score_high")
    private int highestScore;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User examOwner;

    @OneToMany(mappedBy = "examDataOwner", cascade = CascadeType.ALL)
    //@JsonIgnore
    private List<Exam> examList = new ArrayList<>();
}
