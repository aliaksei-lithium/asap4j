package com.epam.asap4j.service;

import com.epam.asap4j.client.UpsaRestClient;
import com.epam.asap4j.client.token.CredentialTypes;
import com.epam.asap4j.client.token.Credentials;
import com.epam.asap4j.conf.MessageStorage;
import com.epam.asap4j.dto.Person;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.UriBuilder;
import java.math.BigInteger;
import java.util.List;

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
    public JSONArray getProjectTeam(String projectId) {
        String uri = BASE_URI + "/projects/" + projectId + "/team";
        return restClient.getArray(uri, null, CREDENTIALS);
    }

    @Override
    public JSONObject getUserByName(String name) {
        UriBuilder uriBuilder = UriBuilder.fromUri(BASE_URI + "/employees?compose=workloads");
        uriBuilder.queryParam("name", name);
        JSONArray array = restClient.getArray(uriBuilder.build().toString(), null, CREDENTIALS);
        return array.getJSONObject(0);
    }

    @Override
    public JSONArray getUnitEmployees(String unitId) {
        String uri = BASE_URI + "/units/" + unitId +"/employees?depth=1&subordinationType=solid&start=1&size=1000";
        return restClient.getArray(uri, null, CREDENTIALS);
    }
}
