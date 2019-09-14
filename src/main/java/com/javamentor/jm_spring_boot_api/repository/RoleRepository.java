package com.javamentor.jm_spring_boot_api.repository;

import com.javamentor.jm_spring_boot_api.entity.Role;

public interface RoleRepository extends GenericRepository<Role> {

    Role findByName(String name);

}
