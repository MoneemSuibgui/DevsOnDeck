package com.devs_on_deck.moneem.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.devs_on_deck.moneem.models.LoginUser;
import com.devs_on_deck.moneem.models.User;
import com.devs_on_deck.moneem.repositories.UserRepository;

@Service
public class UserService {
	
	// inject UserRepository
	@Autowired
	private UserRepository repo;
	
	// create user
	public User add(User user) {
		if(user == null)return null;
		return repo.save(user);
	}
	
	// update user
		public User update(User user) {
			if(user == null)return null;
			return repo.save(user);
		}
	
	// get one user
	public User oneUser(Long id) {
		Optional<User> optionalUser=repo.findById(id);
		if(optionalUser.isPresent()) {
			return optionalUser.get();
		}return null;
	}
	
	// get all developers
	public List<User> all(){
		return this.repo.findAll();
	}
	
	
	
	// register method
	public void register(User user,BindingResult result) {
		if(!user.getPassword().equals(user.getConfirm())) {
			result.rejectValue("confirm","match","* Confirm PW & Password doesn't match");
		}
		if(this.repo.findByEmail(user.getEmail()).isPresent()) {
			result.rejectValue("email","emailMatch","* Email already token");
			
		}
		if(!result.hasErrors()) {
			String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
			user.setPassword(hashed);
		}
	}
	
	// Login method
	public User login(LoginUser user,BindingResult result) {
		
		 // check if the login user email is exist or no && password is match or no
		Optional<User> optionalUser=repo.findByEmail(user.getEmail());
		if(!(optionalUser.isPresent() && BCrypt.checkpw(user.getPassword(),optionalUser.get().getPassword()))) {
			result.rejectValue("email", "CrdMatch","* Invalid Credentials ");
			return null;
		}
		return optionalUser.get();
	}
	
	
	
	
	
	
	
	

}
