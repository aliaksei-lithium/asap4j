package com.epam.asap4j.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Andrei_Akatsyeu on 12/7/13.
 */
@Entity
public class Group {

    private Long groupId;

    private String groupName;

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

    @Override
    public String toString() {
        return "Group{" +
                "groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                '}';
    }
}
