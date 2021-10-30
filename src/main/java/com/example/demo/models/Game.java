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

    private String gameTitle;
    private String gameDescription;
    private String targetGradeRange;
    private String gameLink;
    private String gameGuideLink;
    private String gameQuizLink;
    private String gameImage;

    public Game() {
    }

    public Game(String gameTitle, String targetGradeRange, String gameDescription) {
        this.gameTitle = gameTitle;
        this.targetGradeRange = targetGradeRange;
        this.gameDescription = gameDescription;
    }

    public Game(String gameTitle, String gameDescription, String targetGradeRange, String gameLink, String gameGuideLink, String gameQuizLink, String gameImage) {
        this.gameTitle = gameTitle;
        this.gameDescription = gameDescription;
        this.targetGradeRange = targetGradeRange;
        this.gameLink = gameLink;
        this.gameGuideLink = gameGuideLink;
        this.gameQuizLink = gameQuizLink;
        this.gameImage = gameImage;
    }

    public Long getId() {
        return id;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public String getGameDescription() {
        return gameDescription;
    }

    public String getTargetGradeRange() {
        return targetGradeRange;
    }

    public String getGameLink() {
        return gameLink;
    }

    public String getGameGuideLink() {
        return gameGuideLink;
    }

    public String getGameQuizLink() {
        return gameQuizLink;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public void setGameDescription(String gameDescription) {
        this.gameDescription = gameDescription;
    }

    public void setTargetGradeRange(String targetGradeRange) {
        this.targetGradeRange = targetGradeRange;
    }

    public void setGameLink(String gameLink) {
        this.gameLink = gameLink;
    }

    public void setGameGuideLink(String gameGuideLink) {
        this.gameGuideLink = gameGuideLink;
    }

    public void setGameQuizLink(String gameQuizLink) {
        this.gameQuizLink = gameQuizLink;
    }

    public String getGameImage() {
        return gameImage;
    }

    public void setGameImage(String gameImage) {
        this.gameImage = gameImage;
    }
}
