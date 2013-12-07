package com.epam.asap4j.service;

import org.json.JSONArray;
import org.json.JSONObject;

import java.math.BigInteger;

public interface UpsaRestService {

    String getLocation(BigInteger employeeId);

    JSONArray getProjectTeam(String projectId);

    JSONObject getUserByName(String name);
}
