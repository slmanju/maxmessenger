package com.manjula.maxmessenger.service.impl;

import com.manjula.maxmessenger.dto.MessageDto;
import com.manjula.maxmessenger.model.Message;
import com.manjula.maxmessenger.repository.MessageRepository;
import com.manjula.maxmessenger.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by manjula on 12/4/17.
 */
@Service
@Transactional
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public void save(MessageDto messageDto) {
        messageDto.setDate(new Date());
        messageRepository.save(Message.valueOf(messageDto));
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

}
