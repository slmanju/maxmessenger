package com.manjula.maxmessenger.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@ApiModel(description = "All details about user")
@Data
public class UserDto {

    private String id;
    @ApiModelProperty("email should present")
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    @ApiModelProperty("birth date should be a past value")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date birthDate;
    private String profilePicture = "noimage.png";
    private RoleDto role;

}
