package com.alexande.realestateexam.dto;

import lombok.Data;

@Data
public class Familiarity {

    private String uid;
    private Long categoryId;
    private Long questionId;
    private String status;
}
