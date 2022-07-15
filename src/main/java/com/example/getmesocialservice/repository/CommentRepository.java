package com.example.getmesocialservice.repository;

import com.example.getmesocialservice.model.Album;
import com.example.getmesocialservice.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment,String > {
}
