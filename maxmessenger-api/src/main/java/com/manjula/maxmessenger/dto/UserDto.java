package com.manjula.maxmessenger.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserDto {

    private String id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String profilePicture = "noimage.png";

}
