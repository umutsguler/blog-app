package com.example.jsx.controllers;


import com.example.jsx.entities.Like;
import com.example.jsx.entities.Post;
import com.example.jsx.requests.LikeCreateRequest;
import com.example.jsx.services.LikeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/likes")
public class LikeController {

    LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @GetMapping
    public List<Like> getAllLike(@RequestParam Optional<Long> postId,
                                 @RequestParam Optional<Long> userId) {
        return likeService.getAllLike(postId, userId);
    }

    @PostMapping
    public Like createPost(@RequestBody LikeCreateRequest likeBody) {
        return likeService.createLike(likeBody);
    }

    @DeleteMapping("/{id}")
    public void deleteLike(@PathVariable Long id) {
        likeService.deleteLike(id);
    }
}
