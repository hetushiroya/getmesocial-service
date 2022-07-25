package com.example.getmesocialservice.resource;

import com.example.getmesocialservice.model.Comment;
import com.example.getmesocialservice.model.FireBaseUser;
import com.example.getmesocialservice.service.CommentService;
import com.example.getmesocialservice.service.FireBaseService;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api/comment")
public class CommentResource {

    @Autowired
    private CommentService commentService;

    @Autowired
    FireBaseService fireBaseService;

    @PostMapping
    public Comment saveComment(@RequestBody @Valid Comment comment, @RequestHeader("idToken") String idToken) throws IOException, FirebaseAuthException {
        FireBaseUser fireBaseUser = fireBaseService.authenticate(idToken);
        if(fireBaseUser!=null) {
            return commentService.saveComment(comment);
        }
        return null;
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
    public Comment updateComment(@RequestBody @Valid Comment comment , @RequestHeader("idToken") String idToken) throws IOException, FirebaseAuthException {
            FireBaseUser fireBaseUser = fireBaseService.authenticate(idToken);
            if(fireBaseUser!=null) {
                return commentService.updateComment(comment);
            }
            return null;
    }

    @DeleteMapping
    public void deleteComment(String commentId , @RequestHeader("idToken") String idToken) throws IOException, FirebaseAuthException {
            FireBaseUser fireBaseUser = fireBaseService.authenticate(idToken);
            if (fireBaseUser != null) {
                commentService.deleteComment(commentId);
            }
        }
}
