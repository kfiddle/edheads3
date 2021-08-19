package com.example.demo.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String email;
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
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }



    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
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
