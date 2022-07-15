package com.example.getmesocialservice.resource;

import com.example.getmesocialservice.model.Comment;
import com.example.getmesocialservice.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api/comment")
public class CommentResource {

    @Autowired
    private CommentService commentService;

    @PostMapping
    public Comment saveComment(@RequestBody @Valid Comment comment){
        return commentService.saveComment(comment);

    }
    @GetMapping
    public List<Comment> getAllComments(){
        return commentService.getAllComments();
    }

    @GetMapping("/findById")
    public Optional<Comment> getCommentById(@RequestParam(name="commentId") String commentId){
        return commentService.getCommentById(commentId);
    }

    @PutMapping
    public Comment updateComment(@RequestBody @Valid Comment comment) {
        return commentService.updateComment(comment);
    }

    @DeleteMapping
    public void deleteComment(String commentId){
        commentService.deleteComment(commentId);
    }





}
