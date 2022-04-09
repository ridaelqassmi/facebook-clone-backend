package com.facebook.facebookclone.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.facebook.facebookclone.CommunService.CommenFunctions;
import com.facebook.facebookclone.modals.Post;

import com.facebook.facebookclone.repository.PostRepo;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class PostController {

	@Autowired
	PostRepo postRepo ;
	@GetMapping("/post")
	public List<Post> getAllUsers(){
		return postRepo.findAll();
	}
	@GetMapping("/post/{id}")
	public Optional<Post> findById(@PathVariable(name="id") long id) {
		return postRepo.findById(id);
	}
	@PostMapping("/post/save")
	public Post savePost(@RequestPart("file") MultipartFile file,@RequestParam(value="Post") String Post) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		Post post = objectMapper.readValue(Post,Post.class);
		byte[] picInByte = CommenFunctions.hundleUpload(file);
		post.setImage(picInByte);
		return postRepo.save(post);
	}
	
	
	
}
