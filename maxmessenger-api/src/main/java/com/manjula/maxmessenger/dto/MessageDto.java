package com.manjula.maxmessenger.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

@Data
public class MessageDto {

    private String id;
    @NotEmpty(message = "Message text can not be empty")
    private String text;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date date;

}
