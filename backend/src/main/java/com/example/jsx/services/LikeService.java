package com.example.jsx.services;

import com.example.jsx.entities.Like;
import com.example.jsx.entities.Post;
import com.example.jsx.entities.User;
import com.example.jsx.repos.LikeRepository;
import com.example.jsx.requests.LikeCreateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LikeService {
    LikeRepository likeRepository;
    UserService userService;
    PostService postService;

    public LikeService(LikeRepository likeRepository, UserService userService, PostService postService) {
        this.likeRepository = likeRepository;
        this.userService = userService;
        this.postService = postService;
    }

    public List<Like> getAllLike(Optional<Long> postId , Optional<Long> userId) {
        System.out.println("postId: " + postId);
        System.out.println("userId: " + userId);
        if (postId.isPresent()) {
            return likeRepository.findByUserId(postId.get());
        } else {
            return likeRepository.findAll();
        }
    }

    public Like createLike(LikeCreateRequest likeBody) {
        User user = userService.getOneUser(likeBody.getUserId());
        Post post = postService.getOnePost(likeBody.getPostId());
        if (user == null || post == null) {
            return null;
        } else {
            Like toSave = new Like();
            toSave.setId(likeBody.getId());
            toSave.setUser(user);
            toSave.setPost(post);
            likeRepository.save(toSave);
            System.out.println("post: " + likeBody);
            return toSave;
        }
    }

    public void deleteLike(Long id) {
        likeRepository.deleteById(id);
    }
}
