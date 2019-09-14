package com.javamentor.jm_spring_boot_api.service;

import com.javamentor.jm_spring_boot_api.entity.Role;

public interface RoleService extends GenericService<Role> {

    Role findByName(String name);

}
