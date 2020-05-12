package org.kek.backend.dao;

import org.kek.backend.model.User;

import java.util.List;

public interface UserDao {

    void saveUser(User user);

    List<User> findAll();

    User findUserById(String id);

    void updateUsername(User user);

    void removeUser(User user);
}
