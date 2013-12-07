package com.epam.asap4j.client.token;

import java.io.Serializable;

/**
 * Credentials object is used to obtain OAuth2 access token.
 *
 * @author Aliaksandr_Novik
 */
public class Credentials implements Serializable {

    private String login;

    private String pass;

    private CredentialTypes credentialType;

    public Credentials() {}

    public Credentials(String login, String password) {
        this.login = login;
        this.pass = password;
    }

    public Credentials(String login, String password, CredentialTypes credentialType) {
        this.login = login;
        this.pass = password;
        this.credentialType = credentialType;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * @return the credentialType
     */
    public CredentialTypes getCredentialType() {
        return credentialType;
    }

    /**
     * @param credentialType the credentialType to set
     */
    public void setCredentialType(CredentialTypes credentialType) {
        this.credentialType = credentialType;
    }
}
