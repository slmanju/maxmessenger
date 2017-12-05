package com.manjula.maxmessenger.service;

import com.manjula.maxmessenger.dto.MessageDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MessageService {

    MessageDto save(String userId, MessageDto messageDto);

    MessageDto findById(String id);

    void update(MessageDto messageDto);

    void delete(String id);

    List<MessageDto> findAll();

    Page<MessageDto> findPaginated(int page, int size);
}
