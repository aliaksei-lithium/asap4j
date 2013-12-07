package com.epam.asap4j.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Andrei_Akatsyeu on 12/7/13.
 */
@Entity(name = "m_person")
public class Person {

    private String personId;

    private String personName;

    public Person() {
    }

    public Person(String personId, String personName) {
        this.personId = personId;
        this.personName = personName;
    }

    @Id
    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", personName='" + personName + '\'' +
                '}';
    }
}
