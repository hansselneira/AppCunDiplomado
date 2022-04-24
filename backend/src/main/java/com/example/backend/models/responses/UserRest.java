package com.example.backend.models.responses;

import java.time.LocalDate;

public class UserRest {
    private String firstName;
    private String lastName;
    private String email;
    //private String password;
    private String userId;
    private LocalDate date;

    public LocalDate date() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getuserId() {
        return this.userId;
    }

    public void setuserId(String userId) {
        this.userId = userId;
    }
}
