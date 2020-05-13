package org.kek.rest;

import org.kek.backend.model.User;
import org.kek.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users", produces = {MediaType.APPLICATION_JSON_VALUE})
public class MainController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> findAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable String id) {
        return userService.findUserById(id);
    }

    @PostMapping
    public User saveUser(@RequestBody User user) {
        userService.saveUser(user);
        return user;
    }

    @PutMapping("/{id}")
    public User updateUsername(@PathVariable String id, @RequestBody User user) {
        userService.updateUsername(id, user);
        return user;
    }

    @DeleteMapping("/{id}")
    public void removeUser(@PathVariable String id) {
        userService.removeUserById(id);
    }

}
