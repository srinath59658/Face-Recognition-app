package com.API.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.API.dto.UserRequest;
import com.API.entity.User;
import com.API.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public User saveUser(UserRequest userRequest) {

		User user = User.build(0, userRequest.getName(), userRequest.getEmail(), userRequest.getMobile(),
				userRequest.getGender(), userRequest.getAge(), userRequest.getNationality());

		return repository.save(user);
	}

	public List<User> getAllUsers() {
		return repository.findAll();
	}

	public User getUser(int id) {
		User user= repository.findByUserId(id);
		if(user!=null) {
			return user;
		}
		else {
			throw new UserNotFoundException("User Not found with Id:"+id);
		}
	}
	
	
}
