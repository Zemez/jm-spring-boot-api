package com.javamentor.jm_spring_boot_api.controller;

import com.javamentor.jm_spring_boot_api.entity.User;
import com.javamentor.jm_spring_boot_api.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User user = userService.findById(id);
        logger.debug("User read: {}", user);
        if (user == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(user);
        }
    }

    @GetMapping(path = "/name/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> findByUsername(@PathVariable String username) {
        User user = userService.findByUsername(username);
        logger.debug("User read: {}", user);
        if (user == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(user);
        }
    }

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> findAll() {
        List<User> users = userService.findAll();
//        logger.debug("Users read: {}", users);
        if (users == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(users);
        }
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> create(@Valid @RequestBody User user) {
        User userNew = userService.create(user);
        logger.debug("User create: {}", userNew);
        if (userNew == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(userNew);
        }
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> update(@Valid @RequestBody User user) {
        User userUpd = userService.update(user);
        logger.debug("User update: {}", userUpd);
        if (userUpd == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(userUpd);
        }
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        try {
            userService.deleteById(id);
            logger.debug("User delete: {}", id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
