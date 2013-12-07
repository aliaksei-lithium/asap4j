package com.epam.asap4j.client.token;

/**
 * USPA credentials type. By default PMC is used (
 * no need to put PMC in 'Credentials-Type' header).
 * DOMAIN is used to obtain access token by domain credentials.
 *
 * @author Aliaksandr_Novik
 */
public enum CredentialTypes {

    PMC, DOMAIN;
}
