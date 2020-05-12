package org.kek.backend.service;

import org.kek.backend.model.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);

    List<User> findAll();

    User findUserById(String id);

    void updateUsername(String id, User user);

    void removeUserById(String id);
}
