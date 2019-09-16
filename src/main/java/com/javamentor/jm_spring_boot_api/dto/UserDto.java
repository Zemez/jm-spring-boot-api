package com.javamentor.jm_spring_boot_api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.javamentor.jm_spring_boot_api.entity.Role;

import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {

    private Long id;
    private String username;
    private String password;
    private boolean enabled;
    private boolean accountNonExpired;
    private boolean credentialsNonExpired;
    private boolean accountNonLocked;
    private Set<Role> roles;
    private String firstName;
    private String lastName;
    private String email;

}
