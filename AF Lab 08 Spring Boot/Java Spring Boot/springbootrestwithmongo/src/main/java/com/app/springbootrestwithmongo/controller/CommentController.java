package com.app.springbootrestwithmongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.springbootrestwithmongo.model.Comment;
import com.app.springbootrestwithmongo.service.CommentService;

@RestController
@RequestMapping("comment")

public class CommentController {

	@Autowired
	private CommentService commentService;

	@PostMapping("/save")
	public Comment save(@RequestBody Comment comment) {
		return commentService.save(comment);
	}

	@PutMapping("/update")
	public Comment update(@RequestBody Comment comment) {
		return commentService.update(comment);
	}

	@GetMapping("/all")
	public List<Comment> getAllComments() {
		return commentService.getAllComments();
	}

	@GetMapping("/by/{commentId}")
	public Comment getComment(@PathVariable(name = "commentId") String commentId) {
		return commentService.getComment(commentId);
	}

	@DeleteMapping("/delete/{commentId}")
	public void deleteComment(@PathVariable(name = "commentId") String commentId) {
		commentService.deleteComment(commentId);
	}

}
