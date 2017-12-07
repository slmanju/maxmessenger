package com.manjula.maxmessenger.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class RoleDto {

    private String id;
    @NotEmpty(message = "code is required")
    private String code;
    @NotEmpty(message = "name is required")
    private String name;

}
