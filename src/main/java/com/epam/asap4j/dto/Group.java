package com.epam.asap4j.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigInteger;

/**
 * Created by Andrei_Akatsyeu on 12/7/13.
 */
@Entity
public class Group {

    private BigInteger groupId;

    private String groupName;

    @Id
    public BigInteger getGroupId() {
        return groupId;
    }

    public void setGroupId(BigInteger personId) {
        this.groupId = personId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String personName) {
        this.groupName = personName;
    }
}
