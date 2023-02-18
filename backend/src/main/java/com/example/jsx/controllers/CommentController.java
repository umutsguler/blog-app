package com.example.jsx.controllers;


import com.example.jsx.entities.Comment;
import com.example.jsx.requests.CommentCreateRequest;
import com.example.jsx.requests.CommentUpdateRequest;
import com.example.jsx.services.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
public class CommentController {
    CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<Comment> getAllComment(@RequestParam Optional<Long> userId, @RequestParam Optional<Long> postId) {
        return  commentService.getAllCommentsWithParam(userId,postId);
    }

    @GetMapping("/{commentId}")
    public Comment getOneComment(@PathVariable Long commentId){
        return commentService.getOneCommentById(commentId);
    }

    @PostMapping
    public Comment createOneComment(@RequestBody CommentCreateRequest commentRequest){
        return commentService.createOneComment(commentRequest);
    }

    @PutMapping("/{commentId}")
    public  Comment updateOneComment(@PathVariable Long commentId , @RequestBody CommentUpdateRequest newComment){
        return commentService.updateOneCommentById(commentId,newComment);
    }

    @DeleteMapping("/{commentId}")
    public void deleteOneComment(@PathVariable Long commentId){
        commentService.deleteOneComment(commentId);
    }
}
