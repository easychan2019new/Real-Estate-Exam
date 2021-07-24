package com.alexande.realestateexam.dto;

import lombok.Data;

import java.util.List;

@Data
public class DoExam {

    private String uid;
    private int score;
    private String date;
    private List<RecordQuestion> recordQuestions;
}
