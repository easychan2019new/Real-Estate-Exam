package com.alexande.realestateexam.dto;

import com.alexande.realestateexam.entity.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class DoExam {

    private String uid;

    private int score;

    private List<RecordQuestion> recordQuestions;
}
