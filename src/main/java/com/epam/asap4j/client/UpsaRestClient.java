package com.epam.asap4j.client;

import com.epam.asap4j.client.cache.ExpirableCache;
import com.epam.asap4j.client.cache.SimpleCache;
import com.epam.asap4j.client.token.Credentials;
import com.epam.asap4j.client.token.Token;
import com.epam.asap4j.client.utils.ClientHelper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import org.apache.commons.codec.binary.Base64;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import java.text.ParseException;

/**
 * Rest clent for UPSA/SPF APIs (authentication styles are the same for both apps).
 * Tokens are expirable elements. If token is in the cache, it returns from cache.
 * Otherwise token would be retrieved via authenticationUrl and put in cache.
 * The cache is {@link com.epam.asap4j.client.cache.ExpirableCache}.
 *
 * @author Aliaksandr_Novik
 */
// todo: add option to ignore untrusted certificates
public class UpsaRestClient implements RestClient {

    private final SimpleCache<Credentials, Token> expirableCache;

    private final Client restClient;

    private final String authenticationUrl;

    private static final String BEARER = "Bearer ";

    private static final String BASIC = "Basic ";

    private static final String DOMAIN_CREDENTIALS = "domain";

    private static final String PMC_CREDENTIALS = "pmc";

    private static final Long MILLISEC_MULTIPLIER = Long.valueOf(1000);

    private final boolean credentialsTypeHeaderAllowed;

    /**
     * Creates rest client.
     *
     * @param authenticationUrl token authentication URL
     *                          (https://upsa.epam.com/workload/rest/oauth/token
     *                          for UPSA prod. instance).
     */
    public UpsaRestClient(String authenticationUrl) {
        restClient = ClientHelper.createClient();
        this.authenticationUrl = authenticationUrl;
        expirableCache = new ExpirableCache<>();
        credentialsTypeHeaderAllowed = false;
    }

    public UpsaRestClient(String authenticationUrl, boolean credentialsTypeHeaderAllowed) {
        restClient = ClientHelper.createClient();
        this.authenticationUrl = authenticationUrl;
        expirableCache = new ExpirableCache<>();
        this.credentialsTypeHeaderAllowed = credentialsTypeHeaderAllowed;
    }

    @Override
    public JSONObject get(String url, MultivaluedMap<String, String> params,
                          Credentials credentials) {
        Token token = getToken(credentials);
        return get(url, params, token.getTokenId());
    }

    @Override
    public JSONObject get(String url, MultivaluedMap<String, String> params, String token) {
        Builder resourceBuilder = getResourceBuilder(url, params, token);
        String response;
        response = resourceBuilder.get(String.class);
        try {
            return new JSONObject(response);
        } catch (ParseException ex) {
            throw new RuntimeException("Error during rest call", ex);
        }
    }

    @Override
    public String getString(String url, MultivaluedMap<String, String> params,
                            Credentials credentials) {
        Token token = getToken(credentials);
        return getString(url, params, token.getTokenId());
    }

    @Override
    public String getString(String url, MultivaluedMap<String, String> params, String token) {
        Builder resourceBuilder = getResourceBuilder(url, params, token);
        String response;
        response = resourceBuilder.get(String.class);
        return response;
    }

    @Override
    public JSONArray getArray(String url, MultivaluedMap<String, String> params,
                              Credentials credentials) {
        Token token = getToken(credentials);
        return getArray(url, params, token.getTokenId());
    }

    @Override
    public JSONArray getArray(String url, MultivaluedMap<String, String> params, String token) {
        Builder resourceBuilder = getResourceBuilder(url, params, token);
        String response;
        response = resourceBuilder.get(String.class);
        try {
            return new JSONArray(response);
        } catch (ParseException ex) {
            throw new RuntimeException("Error during rest call", ex);
        }
    }

    @Override
    public JSONObject post(String url, MultivaluedMap<String, String> params,
                           Credentials credentials) {
        Token token = getToken(credentials);
        return post(url, params, token.getTokenId());
    }

    @Override
    public JSONObject post(String url, MultivaluedMap<String, String> params, String token) {
        Builder resourceBuilder = getResourceBuilder(url, params, token);
        String response;
        response = resourceBuilder.post(String.class);
        try {
            return new JSONObject(response);
        } catch (ParseException ex) {
            throw new RuntimeException("Error during rest call", ex);
        }
    }

    @Override
    public JSONObject put(String url, MultivaluedMap<String, String> params,
                          Credentials credentials) {
        Token token = getToken(credentials);
        return put(url, params, token.getTokenId());
    }

    @Override
    public JSONObject put(String url, MultivaluedMap<String, String> params, String token) {
        Builder resourceBuilder = getResourceBuilder(url, params, token);
        String response;
        response = resourceBuilder.put(String.class);
        try {
            return new JSONObject(response);
        } catch (ParseException ex) {
            throw new RuntimeException("Error during rest call", ex);
        }
    }

    @Override
    public JSONObject delete(String url, MultivaluedMap<String, String> params,
                             Credentials credentials) {
        Token token = getToken(credentials);
        return delete(url, params, token.getTokenId());
    }

    @Override
    public JSONObject delete(String url, MultivaluedMap<String, String> params, String token) {
        Builder resourceBuilder = getResourceBuilder(url, params, token);
        String response;
        response = resourceBuilder.delete(String.class);
        try {
            return new JSONObject(response);
        } catch (ParseException ex) {
            throw new RuntimeException("Error during rest call", ex);
        }
    }

    private Builder getResourceBuilder(String url, MultivaluedMap<String, String> params,
                                       String token) {
        Builder resourceBuilder = getWebResource(url, params)
                .header("Authorization", BEARER + token);
        return resourceBuilder;
    }

    private WebResource getWebResource(String url, MultivaluedMap<String, String> params) {
        WebResource resource = restClient.resource(url);
        resource.accept(MediaType.APPLICATION_JSON_TYPE);
        if (params != null) {
            resource.queryParams(params);
        }
        return resource;
    }

    private Token getToken(Credentials credentials) {
        Token token = expirableCache.get(credentials);
        if (token == null) {
            JSONObject response = postOAuthToken(credentials);
            long expiresAfter = response.getLong("expiresIn") * MILLISEC_MULTIPLIER;
            token = new Token(response.getString("value"), expiresAfter);
            expirableCache.put(credentials, token);
        }
        return token;
    }

    private JSONObject postOAuthToken(Credentials credentials) {
        String basicAuthToken = BASIC + getBase64EncodedCredentials(credentials);
        String credentialsType = PMC_CREDENTIALS;
        if (credentialsTypeHeaderAllowed) {
            switch (credentials.getCredentialType()) {
                case DOMAIN:
                    credentialsType = DOMAIN_CREDENTIALS;
                    break;
                case PMC:
                    credentialsType = PMC_CREDENTIALS;
                    break;
                default:
                    credentialsType = PMC_CREDENTIALS;
            }
        }
        Builder resourceBuilder = getWebResource(authenticationUrl, null)
                .header("Authorization", basicAuthToken);
        if (credentialsTypeHeaderAllowed) {
            resourceBuilder.header("Credentials-Type", credentialsType);
        }
        String response;
        MultivaluedMap formData = new MultivaluedMapImpl();
        formData.putSingle("grant_type", "client_credentials");
        response = resourceBuilder.post(String.class, formData);
        try {
            return new JSONObject(response);
        } catch (ParseException ex) {
            throw new RuntimeException("Error during rest call", ex);
        }
    }

    private String getBase64EncodedCredentials(Credentials credentials) {
        StringBuilder credentialsStringBuilder = new StringBuilder(credentials.getLogin());
        credentialsStringBuilder.append(":");
        credentialsStringBuilder.append(credentials.getPass());
        String unencodedCredentials = credentialsStringBuilder.toString();
        return new String(Base64.encodeBase64(unencodedCredentials.getBytes()));
    }
}
