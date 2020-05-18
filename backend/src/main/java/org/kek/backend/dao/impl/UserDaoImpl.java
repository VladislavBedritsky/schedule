package org.kek.backend.dao.impl;

import org.kek.backend.dao.UserDao;
import org.kek.backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
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
    private MongoTemplate mongodbTemplate;

    @Override
    public void saveUser(User user) {
        mongodbTemplate.insert(user, "user");
    }

    @Override
    public List<User> findAll() {
        return mongodbTemplate.findAll(User.class, "user");
    }

    @Override
    public User findUserById(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        return mongodbTemplate.findOne(query, User.class, "user");
    }

    @Override
    public void updateUser(User user) {
        mongodbTemplate.save(user, "user");
    }

    @Override
    public void removeUser(User user) {
        mongodbTemplate.remove(user, "user");
    }
}
