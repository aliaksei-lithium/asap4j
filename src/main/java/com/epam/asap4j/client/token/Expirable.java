package com.epam.asap4j.client.token;

/**
 * @author Aliaksandr_Novik
 */
public interface Expirable {

    /**
     * Expiration time in milliseconds
     *
     * @return expiration time
     */
    long expiresAfter();
}
