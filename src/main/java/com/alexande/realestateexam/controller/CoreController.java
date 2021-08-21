package com.alexande.realestateexam.controller;

import com.alexande.realestateexam.entity.FamiliarQuestion;
import com.alexande.realestateexam.service.FamiliarQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.alexande.realestateexam.dto.Familiarity;

import java.util.List;

@RequestMapping("/api/core")
@RestController
public class CoreController {

    @Autowired
    private FamiliarQuestionService familiarQuestionService;

    @PostMapping("/updateFamiliarQuestion")
    public List<FamiliarQuestion> addFamiliarQuestion(@RequestBody Familiarity familiarity) {
        return familiarQuestionService.addFamiliarQuestion(familiarity);
    }

    @GetMapping("/findUserFamiliarQuestion")
    public List<FamiliarQuestion> findUserFamiliarQuestion(@RequestParam("uid") String uid,
                                                           @RequestParam("cid") Long cid) {
        return familiarQuestionService.findUserFamiliarQuestion(uid,cid);
    }

    @PostMapping("/deleteFamiliarQuestion")
    public List<FamiliarQuestion> findUserFamiliarQuestion(@RequestParam("uid") String uid,
                                                           @RequestParam("cid") Long cid,
                                                           @RequestParam("qid") Long qid) {
        return familiarQuestionService.deleteFamiliarQuestion(uid, cid, qid);
    }
}
