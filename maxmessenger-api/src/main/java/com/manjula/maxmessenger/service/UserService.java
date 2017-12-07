package com.manjula.maxmessenger.service;

import com.manjula.maxmessenger.dto.RoleDto;
import com.manjula.maxmessenger.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto save(UserDto userDto);

    UserDto findById(String id);

    void update(UserDto userDto);

    void delete(String id);

    List<UserDto> findAll();

    RoleDto saveRole(RoleDto roleDto);

    List<RoleDto> findRoles();
}
