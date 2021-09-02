package com.alexande.realestateexam.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "video")
@Data
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", unique = true)
    private String title;

    @Column(name = "address", unique = true)
    private String address;
}
