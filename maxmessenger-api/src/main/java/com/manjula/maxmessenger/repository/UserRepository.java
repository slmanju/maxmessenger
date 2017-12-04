package com.manjula.maxmessenger.repository;

import com.manjula.maxmessenger.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
