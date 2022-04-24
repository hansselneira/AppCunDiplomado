package com.example.backend.models.requests;

import java.time.LocalDate;

//Convierte el JSON en una clase de JAVA que podamos utilizar
//Se utiliza para crear un usuario

public class UserDetailRequestModel {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private LocalDate date;


    public LocalDate getdate() {
        return this.date;
    }

    public void setdate(LocalDate date) {
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

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    // {
    //     "firstname": "hanssel",
    //     "lastname": "neira",
    //     "email": "hanssel.neira@cun.edu.co",
    //     "password": "hans185"
    // }
}
