package org.kek.backend.service.impl;

import org.kek.backend.dao.UserDao;
import org.kek.backend.model.User;
import org.kek.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findUserById(String id) {
        return userDao.findUserById(id);
    }

    @Override
    public void updateUsername(String id, User user) {
        User userFromDb = userDao.findUserById(id);
        userFromDb.setUsername(user.getUsername());
        userDao.updateUsername(userFromDb);
    }

    @Override
    public void removeUserById(String id) {
        User userFromDb = userDao.findUserById(id);
        userDao.removeUser(userFromDb);
    }
}
