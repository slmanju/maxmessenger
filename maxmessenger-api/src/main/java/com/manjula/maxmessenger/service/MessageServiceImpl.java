package com.manjula.maxmessenger.service;

import com.manjula.maxmessenger.dto.Message;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by manjula on 12/4/17.
 */
@Service
public class MessageServiceImpl implements MessageService {

    private static List<Message> messges = new ArrayList<>();

    @Override
    public void create(Message message) {
        message.setId("" + System.currentTimeMillis());
        message.setDate(new Date());
        messges.add(message);
        System.out.println("============================");
        System.out.println(messges.size());
        System.out.println("============================");
    }

    @Override
    public Message findById(String id) {
        return messges.stream().filter(message -> id.equals(message.getId())).findFirst().orElse(null);
    }

    @Override
    public void update(String id, Message message) {

    }

    @Override
    public List<Message> findAll() {
        return messges;
    }

}
