package com.alexande.realestateexam.controller;

import com.alexande.realestateexam.dao.VideoRepository;
import com.alexande.realestateexam.entity.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/videos")
@RestController
public class VideoController {

    @Autowired
    private VideoRepository videoRepository;

    @GetMapping("/findAll")
    public List<Video> findAll() {
        return videoRepository.findAll();
    }
}
