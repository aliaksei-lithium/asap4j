package com.epam.asap4j.dao;

import com.epam.asap4j.dto.User;

public interface UserDao extends BaseDao<User, Long> {

    User getByName(String name);
}
