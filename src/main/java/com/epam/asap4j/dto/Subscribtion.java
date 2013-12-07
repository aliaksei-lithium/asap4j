package com.epam.asap4j.dto;

import javax.persistence.*;
import java.math.BigInteger;

/**
 * Created by Andrei_Akatsyeu on 12/7/13.
 */
@Entity
public class Subscribtion {

    private BigInteger subscribtionId;

    private GroupParticipation groupParticipation;

    private Feature feature;

    @Id
    @GeneratedValue
    public BigInteger getSubscribtionId() {
        return subscribtionId;
    }

    public void setSubscribtionId(BigInteger subscribtionId) {
        this.subscribtionId = subscribtionId;
    }

    @ManyToOne( cascade = {CascadeType.ALL})
    public GroupParticipation getGroupParticipation() {
        return groupParticipation;
    }

    public void setGroupParticipation(GroupParticipation groupParticipation) {
        this.groupParticipation = groupParticipation;
    }

    @ManyToOne( cascade = {CascadeType.ALL})
    public Feature getFeature() {
        return feature;
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
    }
}
