package com.manjula.maxmessenger.service;

import com.manjula.maxmessenger.dto.Message;

import java.util.List;

/**
 * Created by manjula on 12/4/17.
 */
public interface MessageService {

    void create(Message message);

    Message findById(String id);

    void update(String id, Message message);

    List<Message> findAll();

}
