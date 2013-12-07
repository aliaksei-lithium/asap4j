package com.epam.asap4j.dto;

import javax.persistence.*;

/**
 * Created by Andrei_Akatsyeu on 12/7/13.
 */
@Entity(name = "m_group")
public class Group {

    public enum Type {PROJECT, UNIT, LOCATION}

    private Long groupId;
    private String groupName;
    private String externalId;
    private Type groupType;

    public Group() {
    }

    public Group(Long groupId, String groupName) {
        this.groupId = groupId;
        this.groupName = groupName;
    }

    @Id
    @GeneratedValue
    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long personId) {
        this.groupId = personId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String personName) {
        this.groupName = personName;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public Type getGroupType() {
        return groupType;
    }

    public void setGroupType(Type groupType) {
        this.groupType = groupType;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                '}';
    }
}
