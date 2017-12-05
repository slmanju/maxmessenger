package com.manjula.maxmessenger.controller;

import com.manjula.maxmessenger.controller.exception.NotFoundException;
import com.manjula.maxmessenger.controller.util.Preconditions;
import com.manjula.maxmessenger.dto.MessageDto;
import com.manjula.maxmessenger.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController()
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping(value = "")
    public ResponseEntity<?> index() {
        List<MessageDto> messageDtos = messageService.findAll();
        messageDtos = Preconditions.validate(messageDtos);
        return ResponseEntity.ok(messageDtos);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getMessage(@PathVariable("id") String id) {
        MessageDto messageDto = messageService.findById(id);
        messageDto = Preconditions.validate(messageDto);
        return ResponseEntity.ok(messageDto);
    }

    @PostMapping(value = "/user/{userId}")
    public ResponseEntity<?> createMessage(@PathVariable("userId") String userId, @RequestBody MessageDto messageDto) {
        messageService.save(userId, messageDto);
        return ResponseEntity.created(URI.create("/messages")).body(messageDto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateMessage(@PathVariable("id") String id, @RequestBody MessageDto messageDto) {
        MessageDto existing = messageService.findById(id);
        existing = Preconditions.validate(existing);
        messageDto.setId(existing.getId());
        messageService.update(messageDto);
        return ResponseEntity.ok(messageDto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteMessage(@PathVariable("id") String id) {
        messageService.delete(id);
        return ResponseEntity.ok(id);
    }

    @GetMapping(params = { "page", "size" })
    public ResponseEntity<?> findPaginated(@RequestParam("page") int page, @RequestParam("size") int size) {
        if (page < 1 || size < 1) {
            throw new NotFoundException();
        }
        final Page<MessageDto> resultPage = messageService.findPaginated(page, size);
        if (page > resultPage.getTotalPages()) {
            throw new NotFoundException();
        }
        return ResponseEntity.ok(resultPage);
    }

}
