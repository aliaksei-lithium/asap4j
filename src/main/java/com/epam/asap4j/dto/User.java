package com.epam.asap4j.dto;

import javax.persistence.*;

@Entity(name = "m_user")
public class User {

    private String userId;
    private Person person;
    
    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
