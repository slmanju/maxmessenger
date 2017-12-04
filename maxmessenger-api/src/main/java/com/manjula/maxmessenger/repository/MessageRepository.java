package com.manjula.maxmessenger.repository;

import com.manjula.maxmessenger.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by manjula on 12/4/17.
 */
public interface MessageRepository extends JpaRepository<Message, String> {
}
