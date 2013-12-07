package com.epam.asap4j.dto;

public class Employee extends Entity {
    Long id;

    public Employee(Long id, String name, Long id1) {
        super(id, name);
        id = id1;
    }
}
