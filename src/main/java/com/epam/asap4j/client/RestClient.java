package com.epam.asap4j.client;

import com.epam.asap4j.client.token.Credentials;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.ws.rs.core.MultivaluedMap;

/**
 * Rest client interface. Client must provide method with {@link Credentials}
 * credentials or with tokenId string.
 *
 * @author Aliaksandr_Novik
 */
public interface RestClient {

    public JSONObject get(String url, MultivaluedMap<String, String> params,
                          Credentials credentials);

    public JSONObject get(String url, MultivaluedMap<String, String> params,
                          String token);

    public String getString(String url, MultivaluedMap<String, String> params,
                            Credentials credentials);

    public String getString(String url, MultivaluedMap<String, String> params,
                            String token);

    public JSONArray getArray(String url, MultivaluedMap<String, String> params,
                              Credentials credentials);

    public JSONArray getArray(String url, MultivaluedMap<String, String> params,
                              String token);

    public JSONObject post(String url, MultivaluedMap<String, String> params,
                           Credentials credentials);

    public JSONObject post(String url, MultivaluedMap<String, String> params,
                           String token);

    public JSONObject put(String url, MultivaluedMap<String, String> params,
                          Credentials credentials);

    public JSONObject put(String url, MultivaluedMap<String, String> params,
                          String token);

    public JSONObject delete(String url, MultivaluedMap<String, String> params,
                             Credentials credentials);

    public JSONObject delete(String url, MultivaluedMap<String, String> params,
                             String token);
}
