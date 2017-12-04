package com.manjula.maxmessenger.controller;

import com.manjula.maxmessenger.dto.Message;
import com.manjula.maxmessenger.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

/**
 * Created by manjula on 12/4/17.
 */
@RestController()
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping(value = "")
    public ResponseEntity<List<Message>> index() {
        List<Message> messages = messageService.findAll();
        return ResponseEntity.ok(messages);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Message> getMessage(@PathVariable("id") String id) {
        Message message = messageService.findById(id);
        return ResponseEntity.ok(message);
    }

    @PostMapping(value = "")
    public ResponseEntity<Message> createMessage(@RequestBody Message message) {
        messageService.create(message);
        return ResponseEntity.created(URI.create("/messages")).body(message);
    }

}
