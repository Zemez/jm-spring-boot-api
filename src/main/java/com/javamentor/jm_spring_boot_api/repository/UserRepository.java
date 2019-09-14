package com.javamentor.jm_spring_boot_api.repository;

import com.javamentor.jm_spring_boot_api.entity.User;

public interface UserRepository extends GenericRepository<User> {

    User findByUsername(String username);

}
