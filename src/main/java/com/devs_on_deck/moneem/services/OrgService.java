package com.devs_on_deck.moneem.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.devs_on_deck.moneem.models.LoginOrg;
import com.devs_on_deck.moneem.models.Organization;
import com.devs_on_deck.moneem.repositories.OrgRepository;

@Service
public class OrgService {
	
	@Autowired
	private OrgRepository repo;
	
	//  create organization
	public Organization create(Organization org) {
		return this.repo.save(org);
	}
	
	// get one organization
		public Organization oneOrg(Long id) {
			Optional<Organization> org=this.repo.findById(id);
			if(org.isPresent()) {
				return org.get();
			}return null;
		}
	
	// register method
	public void register(Organization org,BindingResult result) {
		
		// check the email is not found in database & password with confirm matches 
		if(!org.getPassword().equals(org.getConfirm())){
			result.rejectValue("confirm", "Cmatch", " * Confirm password and password doesn't match");
		}if(this.repo.findByEmail(org.getEmail())!= null) {
			result.rejectValue("email", "Ematch", "* Email already token");
		}if(!result.hasErrors())
		org.setPassword(BCrypt.hashpw(org.getPassword(),BCrypt.gensalt()));
		
	}
	
	// login method
	public  Organization login(LoginOrg org,BindingResult result) {
		// check email && password
		Organization optionalOrg= this.repo.findByEmail(org.getEmail());
		if(( optionalOrg != null)&&(BCrypt.checkpw(org.getPassword(), optionalOrg.getPassword()))) {
			return optionalOrg;
		}
		result.rejectValue("email", "crdMatch","* Invalid credentials");
			return null;
	}
	

}
