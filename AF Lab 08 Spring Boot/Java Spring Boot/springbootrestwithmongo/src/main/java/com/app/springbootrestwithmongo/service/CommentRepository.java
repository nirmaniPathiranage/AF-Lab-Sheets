package com.app.springbootrestwithmongo.service;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.app.springbootrestwithmongo.model.Comment;

@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {

}
