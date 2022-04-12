package com.facebook.facebookclone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.facebook.facebookclone.modals.Comment;
import com.facebook.facebookclone.modals.User;
import com.facebook.facebookclone.repository.CommentRepo;
import com.facebook.facebookclone.repository.PostRepo;
import com.facebook.facebookclone.repository.UserRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin

public class CommentController {
	
	@Autowired
	CommentRepo commentRepo;
	@Autowired
	PostRepo postRepo;
	@Autowired
	UserRepo userRepo;
	@PostMapping("/comment/save")
	public Comment addComment(@RequestParam(value="idPost") Long idPost,@RequestParam(value="idUser") Long idUser,@RequestParam("Comment") String comment) throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		Comment comment1 = mapper.readValue(comment,Comment.class);
		User user = userRepo.findById(idUser).get();
		comment1.setUser(user);
		comment1.setPost_id(idPost);
		return commentRepo.save(comment1);
	}
	@GetMapping("/comment/{idUser}/{postId}")
	public List<Comment> fetchComment(@PathVariable(value="postId") Long idPost,@PathVariable(value="idUser") Long idUser)  {
		
		return commentRepo.getComment(idUser,idPost);
	
	}

	
	
}
