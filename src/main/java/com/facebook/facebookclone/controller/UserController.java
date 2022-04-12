package com.facebook.facebookclone.controller;


import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.facebook.facebookclone.CommunService.CommenFunctions;
import com.facebook.facebookclone.modals.User;
import com.facebook.facebookclone.repository.UserRepo;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	UserRepo userRepo;
	
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userRepo.findAll();
	}
	@GetMapping("/users/{id}")
	public Optional<User> findById(@PathVariable(name="id") long id) {
		return userRepo.findById(id);
	}
	
	
	@PostMapping("/users/save")
	public User saveUser(@RequestPart("file") MultipartFile file,@RequestParam(value="User") String u) throws IOException  {
		ObjectMapper objectMapper = new ObjectMapper();
		User user = objectMapper.readValue(u, User.class);
		byte[] picInBytes = CommenFunctions.hundleUpload(file);
		user.setProfilePic(picInBytes);
		return userRepo.save(user);
	}
	
	

}
