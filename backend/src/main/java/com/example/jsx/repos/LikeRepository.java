package com.example.jsx.repos;

import com.example.jsx.entities.Like;
import com.example.jsx.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long> {

    List<Like> findByUserId(Long userId);
}
