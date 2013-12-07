package com.epam.asap4j.dto;

import javax.persistence.*;

/**
 * Created by Andrei_Akatsyeu on 12/7/13.
 */
@Entity( name = "l_subscribtion")
public class Subscribtion {

    private Long subscribtionId;

    private GroupParticipation groupParticipation;

    private Feature feature;

    public Subscribtion() {
    }

    public Subscribtion(GroupParticipation groupParticipation, Feature feature) {
        this.groupParticipation = groupParticipation;
        this.feature = feature;
    }

    @Id
    @GeneratedValue
    public Long getSubscribtionId() {
        return subscribtionId;
    }

    public void setSubscribtionId(Long subscribtionId) {
        this.subscribtionId = subscribtionId;
    }

    @ManyToOne(cascade = {CascadeType.ALL})
    public GroupParticipation getGroupParticipation() {
        return groupParticipation;
    }

    public void setGroupParticipation(GroupParticipation groupParticipation) {
        this.groupParticipation = groupParticipation;
    }

    @ManyToOne(cascade = {CascadeType.ALL})
    public Feature getFeature() {
        return feature;
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
    }
}
