package com.alexande.realestateexam.dto;

import com.alexande.realestateexam.entity.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Data
public class DoExam {

    private String uid;
    private int score;
    @JsonFormat(timezone = "EST+8", pattern = "yyyy-MM-dd")
    private String date;
    private List<RecordQuestion> recordQuestions;
}
