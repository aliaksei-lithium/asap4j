package com.epam.asap4j.service;

import org.json.JSONObject;

import java.math.BigInteger;

public interface UpsaRestService {

    String getLocation(BigInteger employeeId);

    JSONObject getUserByName(String name);
}
