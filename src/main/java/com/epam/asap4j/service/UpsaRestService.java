package com.epam.asap4j.service;

import com.epam.asap4j.client.UpsaRestClient;
import com.epam.asap4j.client.token.CredentialTypes;
import com.epam.asap4j.client.token.Credentials;
import com.epam.asap4j.conf.MessageStorage;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service("restService")
public class UpsaRestService {

    private MessageStorage config;

    @Autowired
    private UpsaRestClient restClient;

    private Credentials CREDENTIALS;

    @Autowired
    public UpsaRestService(MessageStorage config) {
        this.config = config;
        CREDENTIALS = new Credentials(config.getMessage("upsa.rest.username"), config.getMessage("upsa.rest.password"), CredentialTypes.PMC);
    }

    public String getLocation(BigInteger employeeId) {
        StringBuilder sb = new StringBuilder(config.getMessage("upsa.rest.base.url"));
        sb.append("/employees/");
        sb.append(employeeId.toString());
        sb.append("/location");
        JSONObject loc = restClient.get(sb.toString(), null, CREDENTIALS);
        return loc.getString("name");
    }
}
