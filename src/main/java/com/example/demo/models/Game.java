package com.example.demo.models;

import com.example.demo.models.enums.GradeRange;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Game {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String gameDescription;
    private GradeRange targetGradeRange;
    private String gameLink;
    private String guideLink;
    private String quizLink;

    public Game() {
    }

    public Game(String title, String gameLink) {
        this.title = title;
        this.gameLink = gameLink;
    }

    public Game(String title, String gameDescription, GradeRange targetGradeRange, String gameLink, String guideLink, String quizLink) {
        this.title = title;
        this.gameDescription = gameDescription;
        this.targetGradeRange = targetGradeRange;
        this.gameLink = gameLink;
        this.guideLink = guideLink;
        this.quizLink = quizLink;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGameDescription() {
        return gameDescription;
    }

    public GradeRange getTargetGradeRange() {
        return targetGradeRange;
    }

    public String getGameLink() {
        return gameLink;
    }

    public String getGuideLink() {
        return guideLink;
    }

    public String getQuizLink() {
        return quizLink;
    }
}
