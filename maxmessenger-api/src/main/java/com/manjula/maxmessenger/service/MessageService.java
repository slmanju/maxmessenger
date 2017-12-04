package com.manjula.maxmessenger.service;

import com.manjula.maxmessenger.dto.MessageDto;

import java.util.List;

/**
 * Created by manjula on 12/4/17.
 */
public interface MessageService {

    void save(MessageDto messageDto);

    MessageDto findById(String id);

    void update(MessageDto messageDto);

    void delete(String id);

    List<MessageDto> findAll();

}
