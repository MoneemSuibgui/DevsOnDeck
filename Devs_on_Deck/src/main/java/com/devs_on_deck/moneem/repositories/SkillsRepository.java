package com.devs_on_deck.moneem.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.devs_on_deck.moneem.models.Profile;

@Repository
public interface SkillsRepository extends CrudRepository<Profile, Long> {
	

}
