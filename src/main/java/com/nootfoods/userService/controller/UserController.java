package com.nootfoods.userService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nootfoods.userService.model.User;
import com.nootfoods.userService.service.UService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UService uservice;
	
	@GetMapping("/all")
	public List<User> getAllUsers() {
		return uservice.getAll();
	}
	
	@PostMapping("/add")
	public User createUser(@RequestBody User user) {
		 return uservice.addUser(user);
		 //return user.toString();
	}
	
	@GetMapping("/{id}")
	public User getbyId(@PathVariable int id) {
		return uservice.getById(id);
	}
	
	@PutMapping("update/{id}")
	public User ypdateUser(@PathVariable int id, @RequestBody User user) {
		//TODO: process PUT request
		
		return uservice.updateUser(id, user);
	}
	
	@DeleteMapping("/del/{id}")
	public String delUser(@PathVariable int id) {
		uservice.deleteUser(id);
		return "Deleted "+id;
	}
	
	
}
