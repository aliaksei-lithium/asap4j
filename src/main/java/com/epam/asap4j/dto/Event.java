package com.epam.asap4j.dto;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Andrei_Akatsyeu on 12/7/13.
 */
@Entity(name = "m_event")
public class Event {

    private Long eventId;

    private Feature feature;

    private List<Group> groups;

    public Event() {
    }

    public Event(Feature feature, List<Group> groups) {
        this.feature = feature;
        this.groups = groups;
    }

    @Id
    @GeneratedValue
    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    @ManyToOne(cascade = {CascadeType.ALL})
    public Feature getFeature() {
        return feature;
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
    }

    @ManyToMany(cascade = {CascadeType.ALL})
    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}
