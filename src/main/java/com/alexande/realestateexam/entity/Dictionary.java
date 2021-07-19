package com.alexande.realestateexam.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "dictionary")
@Data
public class Dictionary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "word")
    private String word;

    @Column(name = "value")
    private String value;

    @ManyToMany(mappedBy = "dictionaryList")
    @JsonIgnore
    Set<User> targetUser;

}
