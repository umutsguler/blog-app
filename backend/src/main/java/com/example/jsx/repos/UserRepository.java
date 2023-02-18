package com.example.jsx.repos;

import com.example.jsx.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);

    Optional<User> findAllById(Long userId);
}