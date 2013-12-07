package com.epam.asap4j.service;

/**
 * Created by Andrei_Akatsyeu on 12/7/13.
 */
public interface EventService {

    void fillBirthDayEvents();

    void saveEvent(String title, String description, Long featureId, Long groupId);

}
