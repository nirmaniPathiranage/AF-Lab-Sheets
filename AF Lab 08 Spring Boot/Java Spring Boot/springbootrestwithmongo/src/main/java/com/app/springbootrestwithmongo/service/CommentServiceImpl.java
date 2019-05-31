package com.app.springbootrestwithmongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.springbootrestwithmongo.model.Comment;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository commentRepository;

	public Comment save(Comment comment) {
		// TODO Auto-generated method stub
		return commentRepository.save(comment);
	}

	public Comment update(Comment comment) {
		// TODO Auto-generated method stub
		return commentRepository.save(comment);
	}

	public List<Comment> getAllComments() {
		// TODO Auto-generated method stub
		return commentRepository.findAll();
	}

	public void deleteComment(String commentId) {
		// TODO Auto-generated method stub
		commentRepository.delete(commentId);
	}

	public Comment getComment(String commentId) {
		// TODO Auto-generated method stub
		return commentRepository.findOne(commentId);
	}

}
