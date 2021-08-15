package com.alexande.realestateexam.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "familiar_question")
@Getter
@Setter
@NoArgsConstructor
public class FamiliarQuestion {


    public FamiliarQuestion(User user, QuestionCategory category, Question question, String status) {
        this.user = user;
        this.category = category;
        this.question = question;
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "status")
    private String status;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnore
    private QuestionCategory category;

    @ManyToOne
    @JoinColumn(name = "question_id")
    //@JsonIgnore
    private Question question;
}
