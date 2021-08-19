package com.example.demo.models;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Teacher extends User {

    private String description;
    private String schoolOrganization;
    private String district;
    private String city;

    private GradeRange gradeRange;
    private CommunityType communityType;
    private StudentCount studentCount;
    private StudentLunchPct studentLunchPct;


    public Teacher() {
    }

    public Teacher(String email, String firstName, String lastName, USAState usaState, LocalDate dateCreated) {
        super(email, firstName, lastName, usaState, dateCreated);
    }

    public Teacher(String email, String firstName, String lastName, USAState usaState, String city,
                   GradeRange gradeRange, CommunityType communityType, StudentCount studentCount, StudentLunchPct studentLunchPct,
                   LocalDate dateCreated) {
        super(email, firstName, lastName, usaState, dateCreated);
        this.city = city;
        this.gradeRange = gradeRange;
        this.communityType = communityType;
        this.studentCount = studentCount;
        this.studentLunchPct = studentLunchPct;

    }

    public String getDescription() {
        return description;
    }

    public String getSchoolOrganization() {
        return schoolOrganization;
    }

    public String getDistrict() {
        return district;
    }

    public String getCity() {
        return city;
    }

    public CommunityType getCommunityType() {
        return communityType;
    }

    public StudentCount getStudentCount() {
        return studentCount;
    }

    public StudentLunchPct getStudentLunchPct() {
        return studentLunchPct;
    }

    public GradeRange getGradeRange() {
        return this.gradeRange;
    }







}
