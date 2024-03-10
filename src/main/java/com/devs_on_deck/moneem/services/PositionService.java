package com.devs_on_deck.moneem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devs_on_deck.moneem.models.Position;
import com.devs_on_deck.moneem.repositories.PositionRepository;

@Service
public class PositionService {
	
	@Autowired
	private PositionRepository repository;

	
	// create position
	public Position add(Position position) {
		return this.repository.save(position);
	}
	
	// get all positions
	public List<Position> all(){
		return this.repository.findAll();
	}
	// get one position
	public Position getById(Long id) {
		Optional<Position> position=this.repository.findById(id);
		if(position.isPresent()) {
			return position.get();
		}return null;
	}
	
}
