package com.manjula.maxmessenger.model;

import com.manjula.maxmessenger.dto.UserDto;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Table(name = "m_user")
@Entity
@Data
public class User {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(strategy = "uuid2", name = "uuid2")
    private String id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDate;
    private String profilePicture = "noimage.png";

    public static User valueOf(UserDto dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setBirthDate(dto.getBirthDate());
        user.setProfilePicture(dto.getProfilePicture());
        return user;
    }

    public UserDto view() {
        UserDto dto = new UserDto();
        dto.setId(id);
        dto.setEmail(email);
        dto.setPassword(password);
        dto.setFirstName(firstName);
        dto.setLastName(lastName);
        dto.setBirthDate(birthDate);
        dto.setProfilePicture(profilePicture);
        return dto;
    }

}
