package com.manjula.maxmessenger.controller;

import com.manjula.maxmessenger.dto.MessageDto;
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
    public ResponseEntity<?> index() {
        List<MessageDto> messageDtos = messageService.findAll();
        return (messageDtos.isEmpty()) ? ResponseEntity.notFound().build() : ResponseEntity.ok(messageDtos);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getMessage(@PathVariable("id") String id) {
        MessageDto messageDto = messageService.findById(id);
        return (messageDto == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(messageDto);
    }

    @PostMapping(value = "")
    public ResponseEntity<?> createMessage(@RequestBody MessageDto messageDto) {
        messageService.save(messageDto);
        return ResponseEntity.created(URI.create("/messages")).body(messageDto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateMessage(@PathVariable("id") String id, @RequestBody MessageDto messageDto) {
        MessageDto existing = messageService.findById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        messageDto.setId(existing.getId());
        messageService.update(messageDto);
        return ResponseEntity.ok(messageDto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteMessage(@PathVariable("id") String id) {
        messageService.delete(id);
        return ResponseEntity.ok(id);
    }

}
