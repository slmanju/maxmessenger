package com.manjula.maxmessenger.controller;

import com.manjula.maxmessenger.controller.util.Preconditions;
import com.manjula.maxmessenger.dto.RoleDto;
import com.manjula.maxmessenger.dto.UserDto;
import com.manjula.maxmessenger.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController()
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "")
    public ResponseEntity<?> index() {
        List<UserDto> userDtos = userService.findAll();
        userDtos = Preconditions.validate(userDtos);
        return ResponseEntity.ok(userDtos);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") String id) {
        UserDto userDto = userService.findById(id);
        userDto = Preconditions.validate(userDto);
        return ResponseEntity.ok(userDto);
    }

    @PostMapping(value = "")
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto) {
        userDto = userService.save(userDto);
        return ResponseEntity.created(URI.create("/users")).body(userDto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") String id, @RequestBody UserDto userDto) {
        UserDto existing = userService.findById(id);
        existing = Preconditions.validate(existing);
        userDto.setId(existing.getId());
        userService.update(userDto);
        return ResponseEntity.ok(userDto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") String id) {
        userService.delete(id);
        return ResponseEntity.ok(id);
    }

    @PostMapping(value = "/roles")
    public ResponseEntity<?> saveRole(@RequestBody @Valid RoleDto role, BindingResult bindingResult) {
        Preconditions.validate(bindingResult);
        role = userService.saveRole(role);
        return ResponseEntity.created(URI.create("/users/roles")).body(role);
    }

    @GetMapping(value = "/roles")
    public ResponseEntity<?> findRoles() {
        List<RoleDto> roles = userService.findRoles();
        roles = Preconditions.validate(roles);
        return ResponseEntity.ok(roles);
    }

}
