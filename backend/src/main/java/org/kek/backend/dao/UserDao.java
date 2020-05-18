package org.kek.backend.dao;

import org.kek.backend.model.User;

import java.util.List;

/**
 *
 * Airport DAO
 *
 * @version 1.01 16 May 2020
 * @author Uladzislau Biadrytski
 *
 */
public interface UserDao {

    /**
     * Save user to DB
     *
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
     * Update user in DB
     *
     * @param user User model
     */
    void updateUser(User user);

    /**
     * Remove user from DB
     *
     * @param user User model
     */
    void removeUser(User user);
}
