package com.epam.asap4j.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigInteger;

/**
 * Created by Andrei_Akatsyeu on 12/7/13.
 */
@Entity
public class Feature {

    private BigInteger featureId;

    private String featureName;

    @Id
    @GeneratedValue
    public BigInteger getFeatureId() {
        return featureId;
    }

    public void setFeatureId(BigInteger featureId) {
        this.featureId = featureId;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }
}
