package org.kek.backend.dao.impl;

import org.kek.backend.dao.UserDao;
import org.kek.backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * UserDao implementation
 *
 * @version 1.01 16 May 2020
 * @author Uladzislau Biadrytski
 *
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    @Qualifier("mongodbTemplate")
    private MongoTemplate mongodbTemplate;

    @Override
    public void saveUser(User user) {
        mongodbTemplate.insert(user, "users");
    }

    @Override
    public List<User> findAll() {
        return mongodbTemplate.findAll(User.class, "users");
    }

    @Override
    public User findUserById(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        return mongodbTemplate.findOne(query, User.class, "users");
    }

    @Override
    public void updateUser(User user) {
        mongodbTemplate.save(user, "users");
    }

    @Override
    public void removeUser(User user) {
        mongodbTemplate.remove(user, "users");
    }
}
