package com.alexande.realestateexam.dao;

import com.alexande.realestateexam.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface VideoRepository extends JpaRepository<Video, Long> {
    List<Video> findAll();
}
