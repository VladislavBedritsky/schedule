package org.kek.rest;

import org.kek.backend.model.User;
import org.kek.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class MainController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> findAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable String id) {
        return userService.findUserById(id);
    }

    @PostMapping
    public User saveUser(@RequestBody User user) {
        userService.saveUser(user);
        return user;
    }

    @PutMapping("/user/{id}")
    public User updateUsername(@PathVariable String id, @RequestBody User user) {
        userService.updateUsername(id, user);
        return user;
    }

    @DeleteMapping("/user/{id}")
    public void removeUser(@PathVariable String id) {
        userService.removeUserById(id);
    }
}
