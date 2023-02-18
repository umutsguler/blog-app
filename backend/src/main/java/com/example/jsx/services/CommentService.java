package com.example.jsx.services;

import com.example.jsx.entities.Comment;
import com.example.jsx.entities.Post;
import com.example.jsx.entities.User;
import com.example.jsx.repos.CommentRepository;
import com.example.jsx.requests.CommentCreateRequest;
import com.example.jsx.requests.CommentUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    CommentRepository commentRepository;
    UserService userService;
    PostService postService;

    public CommentService(CommentRepository commentRepository, PostService postService, UserService userService) {
        this.commentRepository = commentRepository;
        this.userService = userService;
        this.postService = postService;
    }

    public List<Comment> getAllCommentsWithParam(Optional<Long> userId, Optional<Long> postId) {
        if (userId.isPresent() && postId.isPresent()) {
            return commentRepository.findByUserIdAndPostId(userId.get(), postId.get());
        } else if (userId.isPresent()) {
            return commentRepository.findByUserId(userId.get());
        } else if (postId.isPresent()) {
            return commentRepository.getByPostId(postId.get());
        } else {
            return commentRepository.findAll();
        }

    }

    public Comment getOneCommentById(Long commentId) {
        return commentRepository.findById(commentId).orElse(null);
    }

    public Comment createOneComment(CommentCreateRequest commentRequest) {
        User user = userService.getOneUser(commentRequest.getUserId());
        Post post = postService.getOnePost(commentRequest.getPostId());

        if (user != null && post != null) {
            Comment commentToSave = new Comment();
            commentToSave.setId(commentRequest.getId());
            commentToSave.setPost(post);
            commentToSave.setUser(user);
            commentToSave.setText(commentRequest.getText());
            return commentRepository.save(commentToSave);
        } else {
            return null;
        }

    }

    public Comment updateOneCommentById(Long commentId, CommentUpdateRequest newComment) {
        Optional<Comment> comment = commentRepository.findById(commentId);
        if (comment.isPresent()) {
            Comment commentToUpdate = comment.get();
            commentToUpdate.setText(newComment.getText());
            return commentRepository.save(commentToUpdate);
        } else {
            return null;
        }
    }

    public void deleteOneComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
