package com.epam.asap4j.dto;

import javax.persistence.*;
import java.math.BigInteger;

/**
 * Created by Andrei_Akatsyeu on 12/7/13.
 */
@Entity
public class GroupParticipation {

    private BigInteger groupParticipationId;

    private Group group;

    private Person person;

    @Id
    @GeneratedValue
    public BigInteger getGroupParticipationId() {
        return groupParticipationId;
    }

    public void setGroupParticipationId(BigInteger groupParticipationId) {
        this.groupParticipationId = groupParticipationId;
    }

    @ManyToOne( cascade = {CascadeType.ALL} )
    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @ManyToOne( cascade = {CascadeType.ALL} )
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
