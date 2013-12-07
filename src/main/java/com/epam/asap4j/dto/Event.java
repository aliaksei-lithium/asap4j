package com.epam.asap4j.dto;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Andrei_Akatsyeu on 12/7/13.
 */
@Entity(name = "m_event")
public class Event {

    private Long eventId;

    private String title;

    private String description;

    private Feature feature;

    private List<Group> groups;

    public Event() {
    }

    public Event(String title, Feature feature, List<Group> groups) {
        this.title = title;
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

    @ManyToOne(cascade = {CascadeType.REFRESH})
    public Feature getFeature() {
        return feature;
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
    }

    @ManyToMany(cascade = {CascadeType.REFRESH})
    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventId=" + eventId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", feature=" + feature +
                '}';
    }
}
