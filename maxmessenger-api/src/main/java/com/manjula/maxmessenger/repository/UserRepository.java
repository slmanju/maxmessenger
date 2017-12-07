package com.manjula.maxmessenger.repository;

import com.manjula.maxmessenger.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    @Query("SELECT user FROM User user LEFT JOIN user.role")
    Optional<List<User>> findAllUsers();

}
