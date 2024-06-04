package com.nootfoods.userService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.*;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.nootfoods.userService.model.User;
import com.nootfoods.userService.model.User.userType;
import com.nootfoods.userService.repository.UserRepository;

@Service
public class UService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getAll() {
		return userRepository.findAll();
	}

	public User getById(int id) {
		return userRepository.getReferenceById(id);
	}

	public List<User> getbyUserName(String userName) {
		return userRepository.findByUserName(userName);
	}

	public User getByEmail(String email) {
		return userRepository.findByEmailAdd(email);
	}

	public List<User> findAllOfUserType(userType ut) {
		return userRepository.findByUllu(ut);
	}

//	public void addUser(User user) {
//		try {
//		userRepository.insertUser(user.getEmailAdd(),user.getUllu(),user.getUserName());
//		} catch (DataIntegrityViolationException e) {
//			throw new RuntimeException("Email already exists");
//		}
//	}
	
	public User addUser(User user) {
		try {
		return userRepository.save(user);
		} catch (DataIntegrityViolationException e) {
			throw new RuntimeException("Email already exists");
		}
	}

	public void deleteUser(int id) {
		try {
			userRepository.deleteByUserId(id);
		} catch (EmptyResultDataAccessException e) {
			throw new RuntimeException("User not found");
		}
	}

	public void deleteUser(String email) {
		try {
			userRepository.deleteByEmailAdd(email);
		} catch (EmptyResultDataAccessException e) {
			throw new RuntimeException("User not found");
		}
	}

	public User updateUser(int id, User user) {
		Optional<User> existingUser = userRepository.findById(id);
		if (existingUser.isPresent()) {
			User temp = existingUser.get();
			temp.setEmailAdd(user.getEmailAdd());
			temp.setUserName(user.getUserName());
			temp.setUllu(user.getUllu());
			return userRepository.save(temp);
		} else {
			throw new RuntimeException("User not found");
		}
	}

}
