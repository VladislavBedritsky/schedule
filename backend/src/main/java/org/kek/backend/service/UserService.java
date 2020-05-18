package org.kek.backend.service;

import org.kek.backend.model.User;

import java.util.List;


/**
 *
 * User Service
 *
 * @version 1.01 16 May 2020
 * @author Uladzislau Biadrytski
 *
 */
public interface UserService {

    /**
     * Save user to DB
     * @param user User model
     */
    void saveUser(User user);

    /**
     * Get all users from DB
     *
     * @return list of users
     */
    List<User> findAll();

    /**
     * Get user by id from DB
     *
     * @param id Users id
     * @return User
     */
    User findUserById(String id);

    /**
     * Update users username in DB
     *
     * @param id Users id
     * @param user User model
     */
    void updateUsername(String id, User user);

    /**
     * Remove user from DB
     *
     * @param id Users id
     */
    void removeUserById(String id);
}
