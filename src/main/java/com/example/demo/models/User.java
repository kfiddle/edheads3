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
    private String email;
    private String password;
    private String firstName;
    private String lastName;


    private USAState usaState;
    private String country;

    private USAState state;

    private LocalDate dateCreated;
    private LocalDate dateUpdate;
    private boolean subscribeToNewsInd;

    public User() {
    }

    public User(String email) {
        this.email = email;
    }

    public User(String email, String firstName, String lastName, USAState usaState, LocalDate dateCreated) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.usaState = usaState;
        this.dateCreated = dateCreated;
    }

    public User(String email, String firstName, String lastName, String state, LocalDate dateCreated) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateCreated = dateCreated;
    }

    public User(String email, String firstName, String lastName) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public Long getId() {
        return id;
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

    public USAState getUsaState() {
        return usaState;
    }

    public String getCountry() {
        return country;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public LocalDate getDateUpdate() {
        return dateUpdate;
    }

    public boolean isSubscribeToNewsInd() {
        return subscribeToNewsInd;
    }

    public USAState getStringState() {
        return state;
    }


}
