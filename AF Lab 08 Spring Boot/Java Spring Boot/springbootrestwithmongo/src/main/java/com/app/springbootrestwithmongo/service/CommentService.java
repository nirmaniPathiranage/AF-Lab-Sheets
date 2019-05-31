package com.app.springbootrestwithmongo.service;

import java.util.List;

import com.app.springbootrestwithmongo.model.Comment;

public interface CommentService {

	Comment save(Comment comment);

	Comment update(Comment comment);

	List<Comment> getAllComments();

	void deleteComment(String commentId);

	Comment getComment(String commentId);

}
