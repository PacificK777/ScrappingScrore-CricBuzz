package com.example.cricbuzzscraper.controller;

import com.example.cricbuzzscraper.service.CricbuzzScraperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CricbuzzScraperController {

    @Autowired
    private CricbuzzScraperService cricbuzzScraperService;

    @GetMapping("/match-score")
    public String getMatchScore(@RequestParam String url) {
        return cricbuzzScraperService.getMatchScore(url);
    }
}
