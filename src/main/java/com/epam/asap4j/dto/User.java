package com.epam.asap4j.dto;

import javax.persistence.*;

@Entity
public class User {

    private String userId;
    private Person person;

    @Id
    @GeneratedValue
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @OneToOne(cascade = CascadeType.ALL)
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
