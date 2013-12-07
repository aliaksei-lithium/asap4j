package com.epam.asap4j.service;

import com.epam.asap4j.dto.Event;
import com.epam.asap4j.dto.Person;
import org.json.JSONArray;
import org.json.JSONObject;

import java.math.BigInteger;
import java.util.List;

public interface UpsaRestService {

    String getLocation(BigInteger employeeId);

    JSONArray getProjectTeam(String projectId);

    JSONObject getUserByName(String name);
}
