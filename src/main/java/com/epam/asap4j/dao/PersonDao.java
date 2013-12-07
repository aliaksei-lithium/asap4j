package com.epam.asap4j.dao;

import com.epam.asap4j.dto.Feature;
import com.epam.asap4j.dto.Person;

import java.util.List;

/**
 * User: Andrei_Akatsyeu
 * Date: 12/3/13
 */
public interface PersonDao extends BaseDao<Person, String> {

    List<Person> getPersonsWithSubscribtionOnFeature(Feature feature);

}
