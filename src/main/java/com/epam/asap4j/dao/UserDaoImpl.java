package com.epam.asap4j.dao;

import com.epam.asap4j.dto.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User, Long> implements UserDao {

    public UserDaoImpl() {
        super(UserDaoImpl.class);
    }

    public User getByName(String name) {
        return (User) sessionFactory.getCurrentSession()
                .createQuery("from User u where u.person.personName = :name").setParameter("name", name).uniqueResult();
    }

}
