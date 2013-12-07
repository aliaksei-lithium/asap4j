package com.epam.asap4j.service;

import com.epam.asap4j.client.UpsaRestClient;
import com.epam.asap4j.client.token.CredentialTypes;
import com.epam.asap4j.client.token.Credentials;
import com.epam.asap4j.conf.MessageStorage;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.UriBuilder;
import java.math.BigInteger;

@Service("restService")
public class UpsaRestServiceImpl implements UpsaRestService {

    private MessageStorage config;

    @Autowired
    private UpsaRestClient restClient;

    private Credentials CREDENTIALS;

    private final String BASE_URI;

    @Autowired
    public UpsaRestServiceImpl(MessageStorage config) {
        this.config = config;
        CREDENTIALS = new Credentials(config.getMessage("upsa.rest.username"), config.getMessage("upsa.rest.password"), CredentialTypes.PMC);
        BASE_URI = config.getMessage("upsa.rest.base.url");
    }

    @Override
    public String getLocation(BigInteger employeeId) {
        StringBuilder sb = new StringBuilder(BASE_URI);
        sb.append("/employees/");
        sb.append(employeeId.toString());
        sb.append("/location");
        JSONObject loc = restClient.get(sb.toString(), null, CREDENTIALS);
        return loc.getString("name");
    }

    @Override
    public JSONObject getUserByName(String name) {
        String url = String.format("%s/employees?compose=workloads", BASE_URI);
        UriBuilder uriBuilder = UriBuilder.fromUri(url);
        uriBuilder.queryParam("name", name);
        return restClient.get(uriBuilder.toString(), null, CREDENTIALS);
    }
}
