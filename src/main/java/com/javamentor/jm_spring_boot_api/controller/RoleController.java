package com.javamentor.jm_spring_boot_api.controller;

import com.javamentor.jm_spring_boot_api.entity.Role;
import com.javamentor.jm_spring_boot_api.service.RoleService;
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
@RequestMapping("/api/role")
public class RoleController {

    private static final Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private RoleService roleService;

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Role> findById(@PathVariable Long id) {
        Role role = roleService.findById(id);
        logger.debug("Role read: {}", role);
        if (role == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(role);
        }
    }

    @GetMapping(path = "/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Role> findByUsername(@PathVariable String name) {
        Role role = roleService.findByName(name);
        logger.debug("Role read: {}", role);
        if (role == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(role);
        }
    }

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Role>> findAll() {
        List<Role> roles = roleService.findAll();
        logger.debug("Roles read: {}", roles);
        if (roles == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(roles);
        }
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Role> create(@Valid @RequestBody Role role) {
        Role roleNew = roleService.create(role);
        logger.debug("Role create: {}", roleNew);
        if (roleNew == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(roleNew);
        }
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Role> update(@Valid @RequestBody Role user) {
        Role roleUpd = roleService.update(user);
        logger.debug("Role update: {}", roleUpd);
        if (roleUpd == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(roleUpd);
        }
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            roleService.deleteById(id);
            logger.debug("Role delete: {}", id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
