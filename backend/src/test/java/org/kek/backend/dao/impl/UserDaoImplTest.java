package org.kek.backend.dao.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kek.backend.dao.UserDao;
import org.kek.backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:test.xml"})
public class UserDaoImplTest {

    @Autowired
    private UserDao userDao;
    @Autowired
    private MongoTemplate mongodbTemplate;

    private User user;
    private User userFromDb;

    @Before
    public void setUp() {
        user = new User();
        user.setUsername("Kyle");
        user.setPassword("kyle");

        userFromDb = userDao.findAll().stream().reduce((first,second) -> second).orElse(null);
    }

    @Test
    @Transactional
    public void saveUser() {
        userDao.saveUser(user);
        Query query = new Query().addCriteria(Criteria.where("username").is("Kyle"));
        List<User> users = mongodbTemplate.find(query, User.class, "user");

        assertThat(users.size(), is(1));
    }

    @Test
    public void findAll() {
        List<User> users = userDao.findAll();
        assertNotNull(users);
    }

    @Test
    public void findUserById() {
        assertNotNull(userFromDb);
        assertNotNull(userDao.findUserById(userFromDb.getId()));
    }

    @Test
    @Transactional
    public void updateUsername() {
        assertNotNull(userFromDb);

        userFromDb.setUsername("JUnit4");
        userDao.updateUsername(userFromDb);

        assertEquals(userFromDb.getUsername(), "JUnit4");
    }

    @Test
    @Transactional
    public void removeUser() {
        int sizeOfListBeforeRemove = userDao.findAll().size();

        assertNotNull(userFromDb);
        userDao.removeUser(userFromDb);
        assertNotEquals(sizeOfListBeforeRemove, userDao.findAll().size());
    }

}