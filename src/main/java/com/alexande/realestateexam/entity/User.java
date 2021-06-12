package com.alexande.realestateexam.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
@Data
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "uid")
    private Long uid;

    @Column(name = "membership")
    private boolean membership;

    @Column(name = "daily_practice")
    private int dailyPractice;

    @Column(name = "exam_date")
    private Date examDate;

    @Column(name = "start_date")
    private Date startDate;
}
