package com.manjula.maxmessenger.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * Created by manjula on 12/4/17.
 */
@Data
public class Message {

    private String id;
    private String text;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;

}
