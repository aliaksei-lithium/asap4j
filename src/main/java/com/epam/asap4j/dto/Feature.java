package com.epam.asap4j.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Andrei_Akatsyeu on 12/7/13.
 */
@Entity(name = "m_feature")
public class Feature {

    private Long featureId;

    private String featureName;

    public Feature() {
    }

    public Feature(Long featureId, String featureName) {
        this.featureId = featureId;
        this.featureName = featureName;
    }

    @Id
    public Long getFeatureId() {
        return featureId;
    }

    public void setFeatureId(Long featureId) {
        this.featureId = featureId;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    @Override
    public String toString() {
        return "Feature{" +
                "featureId=" + featureId +
                ", featureName='" + featureName + '\'' +
                '}';
    }
}
