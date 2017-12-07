package com.manjula.maxmessenger.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class UserDto {

    private String id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date birthDate;
    private String profilePicture = "noimage.png";
    private RoleDto role;

}
