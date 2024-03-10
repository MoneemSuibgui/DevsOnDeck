package com.devs_on_deck.moneem.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devs_on_deck.moneem.models.Profile;
import com.devs_on_deck.moneem.repositories.SkillsRepository;

@Service
public class SkillsService {
	
	@Autowired
	private SkillsRepository repository;

	// add profile
	public Profile add(Profile profile) {
		return this.repository.save(profile);
	}

	// get one profile
	public Profile getOne(Long id) {
		Optional<Profile>optionalProfile=this.repository.findById(id);
		if(optionalProfile.isPresent()) {
			return optionalProfile.get();
		}return null;
	}

	// update skills
		public Profile update(Profile profile) {
			return this.repository.save(profile);
		}
}
