package com.manjula.maxmessenger.service.impl;

import com.manjula.maxmessenger.dto.UserDto;
import com.manjula.maxmessenger.model.User;
import com.manjula.maxmessenger.repository.UserRepository;
import com.manjula.maxmessenger.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(UserDto userDto) {
        userRepository.save(User.valueOf(userDto));
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
        List<User> users = userRepository.findAll();
        return users.stream().map(User::view).collect(Collectors.toList());
    }

}
