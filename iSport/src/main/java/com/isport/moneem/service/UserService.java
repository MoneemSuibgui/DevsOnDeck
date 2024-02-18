package com.isport.moneem.service;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.isport.moneem.model.LoggedUser;
import com.isport.moneem.model.User;
import com.isport.moneem.repository.UserRepository;

@Service
public class UserService {

	// inject UserRepository using @Autowired annotation
	@Autowired
	private UserRepository repository;

	// register method
	public void register(User user, BindingResult result) {
		Optional<User> optionalUser = this.repository.findByEmail(user.getEmail());
		if (optionalUser.isPresent()) {
			result.rejectValue("email", "emailExist", "* Email already token");
		} else {
			user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
		}
	}

	// login method
	public User login(LoggedUser user, BindingResult result) {
		Optional<User> optionalUser = this.repository.findByEmail(user.getEmail());
		if ((optionalUser.isPresent() && BCrypt.checkpw(user.getPassword(), optionalUser.get().getPassword()))) {
			return optionalUser.get();
		} else {
			result.rejectValue("email", "UserNotExit", "* Invalid Credentials !!");
			return null;
		}
	}

	// create user
	public User add(User user) {
		return this.repository.save(user);
	}

	// get one user by id
	public User getById(Long id) {
		Optional<User> user = this.repository.findById(id);
		if (user.isPresent()) {
			return user.get();
		}
		return null;
	}

}
