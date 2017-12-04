package com.manjula.maxmessenger.model;

import com.manjula.maxmessenger.dto.MessageDto;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by manjula on 12/4/17.
 */
@Table(name = "message")
@Entity
@Data
public class Message {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(strategy = "uuid2", name = "uuid2")
    private String id;
    private String text;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public static Message valueOf(MessageDto dto) {
        Message message = new Message();
        message.setText(dto.getText());
        message.setId(dto.getId());
        message.setDate(dto.getDate());
        return message;
    }

    public MessageDto view() {
        MessageDto dto = new MessageDto();
        dto.setId(id);
        dto.setText(text);
        dto.setDate(date);
        return dto;
    }

}
