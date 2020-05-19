package org.kek.rest;

import org.kek.backend.model.User;
import org.kek.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * User REST controller
 *
 * @version 1.01 16 May 2020
 * @author Uladzislau Biadrytski
 *
 */
@RestController
@RequestMapping(path = "/api/users", produces = {MediaType.APPLICATION_JSON_VALUE})
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Get all users
     *
     * @return list of users
     */
    @GetMapping
    public List<User> findAllUsers() {
        return userService.findAll();
    }

    /**
     * Get user by id
     *
     * @param id Users is
     * @return User
     */
    @GetMapping("/{id}")
    public User getUser(@PathVariable String id) {
        return userService.findUserById(id);
    }

    /**
     * Save user
     *
     * @param user User model
     * @return User
     */
    @PostMapping
    public User saveUser(@RequestBody User user) {
        userService.saveUser(user);
        return user;
    }

    /**
     * Update users username by id
     *
     * @param id Users id
     * @param user User model
     * @return User
     */
    @PutMapping("/{id}")
    public User updateUsername(@PathVariable String id, @RequestBody User user) {
        userService.updateUsername(id, user);
        return user;
    }

    /**
     * Delete user by id
     *
     * @param id Users id
     */
    @DeleteMapping("/{id}")
    public void removeUser(@PathVariable String id) {
        userService.removeUserById(id);
    }

}
