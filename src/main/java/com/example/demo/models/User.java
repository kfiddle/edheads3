package com.example.demo.models;


import com.example.demo.models.enums.USAState;
import org.springframework.context.annotation.Bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.*;
import java.time.LocalDate;


@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String role;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

    private LocalDate dateCreated;
    private LocalDate dateUpdate;
    private boolean subscribeToNewsInd;

    private String schoolOrganization;
    private String district;
    private String country;
    private String state;
    private String city;

    private String gradeRange;
    private String schoolType;
    private String numberOfStudents;
    private String percentOfFreeLunches;

    private String description;



    public User() {}

    public User(String email) {
        this.email = email;
    }

    public User(String email, String firstName, String lastName) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(Long id, String role, String email, String password, String firstName, String lastName,
                LocalDate dateCreated, LocalDate dateUpdate, boolean subscribeToNewsInd, String schoolOrganization,
                String district, String country, String state, String city, String gradeRange, String schoolType,
                String numberOfStudents, String percentOfFreeLunches, String description) {
        this.id = id;
        this.role = role;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateCreated = dateCreated;
        this.dateUpdate = dateUpdate;
        this.subscribeToNewsInd = subscribeToNewsInd;
        this.schoolOrganization = schoolOrganization;
        this.district = district;
        this.country = country;
        this.state = state;
        this.city = city;
        this.gradeRange = gradeRange;
        this.schoolType = schoolType;
        this.numberOfStudents = numberOfStudents;
        this.percentOfFreeLunches = percentOfFreeLunches;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDate getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(LocalDate dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public boolean isSubscribeToNewsInd() {
        return subscribeToNewsInd;
    }

    public void setSubscribeToNewsInd(boolean subscribeToNewsInd) {
        this.subscribeToNewsInd = subscribeToNewsInd;
    }

    public String getSchoolOrganization() {
        return schoolOrganization;
    }

    public void setSchoolOrganization(String schoolOrganization) {
        this.schoolOrganization = schoolOrganization;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGradeRange() {
        return gradeRange;
    }

    public void setGradeRange(String gradeRange) {
        this.gradeRange = gradeRange;
    }

    public String getSchoolType() {
        return schoolType;
    }

    public void setSchoolType(String schoolType) {
        this.schoolType = schoolType;
    }

    public String getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(String numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public String getPercentOfFreeLunches() {
        return percentOfFreeLunches;
    }

    public void setPercentOfFreeLunches(String percentOfFreeLunches) {
        this.percentOfFreeLunches = percentOfFreeLunches;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }





}
