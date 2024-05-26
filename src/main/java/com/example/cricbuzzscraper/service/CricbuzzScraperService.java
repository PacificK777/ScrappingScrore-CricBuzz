package com.example.cricbuzzscraper.service;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CricbuzzScraperService {

    public String getMatchScore(String matchUrl) {
        try {
            // Fetch the HTML content from the URL
            Connection.Response response = Jsoup.connect(matchUrl).execute();

            if (response.statusCode() == 200) {
                Document document = response.parse();

                // Parse the HTML to find the score element
                Element scoreElement = document.selectFirst(".cb-col.cb-col-67.cb-scrs-wrp");

                // Extract and return the text content
                return scoreElement != null ? scoreElement.text() : "Score not found";
            } else {
                return "Failed to fetch score: HTTP error fetching URL. Status=" + response.statusCode();
            }
        } catch (IOException e) {
            return "Failed to fetch score: " + e.getMessage();
        }
    }
}
/*
USE below url to check the cricket score (not live)-
http://localhost:8080/match-score?url=https://www.cricbuzz.com/cricket-scores/<Match-id>
 */