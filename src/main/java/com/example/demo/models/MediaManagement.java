package com.example.demo.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class MediaManagement {

    @Id
    @GeneratedValue
    private Long id;

    private String adTagUrl;
    private String imageUrl;

    private String pageTitle;

    private String columnPositionA;
    private String columnPositionB;
    private String columnPositionC;

    public MediaManagement() {
    }

    public MediaManagement(String adTagUrl, String pageTitle, String columnPositionA, String columnPositionB, String columnPositionC) {
        this.adTagUrl = adTagUrl;
        this.columnPositionA = columnPositionA;
        this.columnPositionB = columnPositionB;
        this.columnPositionC = columnPositionC;
    }


    public Long getId() {
        return id;
    }

    public String getAdTagUrl() {
        return adTagUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public String getColumnPositionA() {
        return columnPositionA;
    }

    public String getColumnPositionB() {
        return columnPositionB;
    }

    public String getColumnPositionC() {
        return columnPositionC;
    }
}
