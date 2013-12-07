package com.epam.asap4j.dto;

import javax.persistence.*;

/**
 * Created by Andrei_Akatsyeu on 12/7/13.
 */
@Entity(name = "l_group_participation")
public class GroupParticipation {

    private Long groupParticipationId;

    private Group group;

    private Person person;

    public GroupParticipation() {
    }

    public GroupParticipation(Group group, Person person) {
        this.group = group;
        this.person = person;
    }

    @Id
    @GeneratedValue
    public Long getGroupParticipationId() {
        return groupParticipationId;
    }

    public void setGroupParticipationId(Long groupParticipationId) {
        this.groupParticipationId = groupParticipationId;
    }

    @ManyToOne(cascade = {CascadeType.REFRESH})
    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @ManyToOne(cascade = {CascadeType.REFRESH})
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
