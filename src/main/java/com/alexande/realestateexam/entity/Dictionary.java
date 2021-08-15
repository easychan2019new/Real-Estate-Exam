package com.alexande.realestateexam.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "dictionary")
@Data
public class Dictionary {

    @Id
    @Column(name = "id")
    private Long id;

    @ManyToMany(mappedBy = "dictionaryList")
    @JsonBackReference
    Set<User> targetUser;

}
