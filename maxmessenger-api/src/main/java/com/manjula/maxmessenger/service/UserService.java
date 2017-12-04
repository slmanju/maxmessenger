package com.manjula.maxmessenger.service;

import com.manjula.maxmessenger.dto.UserDto;

import java.util.List;

public interface UserService {

    void save(UserDto userDto);

    UserDto findById(String id);

    void update(UserDto userDto);

    void delete(String id);

    List<UserDto> findAll();

}
