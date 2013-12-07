package com.epam.asap4j.client.token;

import java.io.Serializable;
import java.util.Objects;

/**
 * OAuth token implementation. If expiration is -1 than element will be unexpirable
 * in cache.
 *
 * @author Aliaksandr_Novik
 */
public final class Token implements Serializable, Expirable {

    private final String tokenId;

    /**
     * Time before token expiration (in milliseconds)
     */
    private final long expiresAfter;

    public Token(String tokenId, long expiresAfter) {
        this.tokenId = tokenId;
        this.expiresAfter = expiresAfter;
    }

    public Token(String tokenId) {
        this.tokenId = tokenId;
        expiresAfter = -1;
    }

    public String getTokenId() {
        return tokenId;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        if(getClass() != obj.getClass()) {
            return false;
        }
        Token token = (Token) obj;
        if(this.getTokenId() == null) {
            if(token.getTokenId() == null) {
                return true;
            }
        } else if(!this.getTokenId().equals(token.getTokenId())) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.tokenId);
        return hash;
    }

    @Override
    public long expiresAfter() {
        return expiresAfter;
    }
}
