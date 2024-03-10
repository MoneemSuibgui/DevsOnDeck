package com.devs_on_deck.moneem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devs_on_deck.moneem.models.Profile;

@Repository
public interface SkillsRepository extends JpaRepository<Profile, Long> {
	

}
