package com.manjula.maxmessenger.service.impl;

import com.manjula.maxmessenger.dto.RoleDto;
import com.manjula.maxmessenger.dto.UserDto;
import com.manjula.maxmessenger.model.Role;
import com.manjula.maxmessenger.model.User;
import com.manjula.maxmessenger.repository.RoleRepository;
import com.manjula.maxmessenger.repository.UserRepository;
import com.manjula.maxmessenger.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDto save(UserDto userDto) {
        User user = userRepository.save(User.valueOf(userDto));
        return user.view();
    }

    @Override
    public UserDto findById(String id) {
        User user = userRepository.findOne(id);
        return (user != null) ? user.view() : null;
    }

    @Override
    public void update(UserDto userDto) {
        userRepository.save(User.valueOf(userDto));
    }

    @Override
    public void delete(String id) {
        userRepository.delete(id);
    }

    @Override
    public List<UserDto> findAll() {
        Optional<List<User>> users = userRepository.findAllUsers();
        return users.map(users1 -> users1.stream().map(User::view)).orElse(Stream.empty()).collect(Collectors.toList());
    }

    @Override
    public RoleDto saveRole(RoleDto roleDto) {
        Role role = roleRepository.save(Role.valueOf(roleDto));
        return role.view();
    }

    @Override
    public List<RoleDto> findRoles() {
        List<Role> roles = roleRepository.findAll();
        return roles.stream().map(Role::view).collect(Collectors.toList());
    }

}
