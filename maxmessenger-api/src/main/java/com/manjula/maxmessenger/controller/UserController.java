package com.manjula.maxmessenger.controller;

import com.manjula.maxmessenger.dto.UserDto;
import com.manjula.maxmessenger.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return (userDtos.isEmpty()) ? ResponseEntity.notFound().build() : ResponseEntity.ok(userDtos);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") String id) {
        UserDto userDto = userService.findById(id);
        return (userDto == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(userDto);
    }

    @PostMapping(value = "")
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto) {
        userService.save(userDto);
        return ResponseEntity.created(URI.create("/users")).body(userDto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") String id, @RequestBody UserDto userDto) {
        UserDto existing = userService.findById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        userDto.setId(existing.getId());
        userService.update(userDto);
        return ResponseEntity.ok(userDto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") String id) {
        userService.delete(id);
        return ResponseEntity.ok(id);
    }

}
