package com.epam.asap4j.dao;

import com.epam.asap4j.dto.Employee;
import com.epam.asap4j.dto.Person;
import org.springframework.stereotype.Repository;

/**
 * User: Andrei_Akatsyeu
 * Date: 12/3/13
 */
@Repository
public class PersonDaoImpl extends BaseDaoImpl<Person> implements PersonDao {

    public PersonDaoImpl() {
        super(Person.class);
    }
}
