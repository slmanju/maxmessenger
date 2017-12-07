package com.manjula.maxmessenger.model;

import com.manjula.maxmessenger.dto.RoleDto;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Table(name = "m_role")
@Entity
@Data
public class Role {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(strategy = "uuid2", name = "uuid2")
    private String id;
    private String code;
    private String name;

    public static Role valueOf(RoleDto dto) {
        Role role = new Role();
        role.setId(dto.getId());
        role.setCode(dto.getCode());
        role.setName(dto.getName());
        return role;
    }

    public RoleDto view() {
        RoleDto dto = new RoleDto();
        dto.setId(id);
        dto.setCode(code);
        dto.setName(name);
        return dto;
    }

}
