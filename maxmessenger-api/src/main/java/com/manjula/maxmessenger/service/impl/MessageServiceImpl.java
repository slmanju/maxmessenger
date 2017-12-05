package com.manjula.maxmessenger.service.impl;

import com.manjula.maxmessenger.dto.MessageDto;
import com.manjula.maxmessenger.dto.UserDto;
import com.manjula.maxmessenger.model.Message;
import com.manjula.maxmessenger.model.User;
import com.manjula.maxmessenger.repository.MessageRepository;
import com.manjula.maxmessenger.service.MessageService;
import com.manjula.maxmessenger.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private UserService userService;

    @Override
    public MessageDto save(String userId, MessageDto messageDto) {
        UserDto userDto = userService.findById(userId);

        messageDto.setDate(new Date());

        Message message = Message.valueOf(messageDto);
        message.setUser(User.valueOf(userDto));
        message = messageRepository.save(message);
        return message.view();
    }

    @Override
    public MessageDto findById(String id) {
        Message message = messageRepository.findOne(id);
        return (message != null) ? message.view() : null;
    }

    @Override
    public void update(MessageDto messageDto) {
        messageRepository.save(Message.valueOf(messageDto));
    }

    @Override
    public void delete(String id) {
        messageRepository.delete(id);
    }

    @Override
    public List<MessageDto> findAll() {
        List<Message> messages = messageRepository.findAll();
        return messages.stream().map(Message::view).collect(Collectors.toList());
    }

    @Override
    public Page<MessageDto> findPaginated(int page, int size) {
        Page<Message> entities = messageRepository.findAll(new PageRequest(page - 1, size));
        return entities.map(Message::view);
    }

}
