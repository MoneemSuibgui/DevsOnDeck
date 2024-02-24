package com.devs_on_deck.moneem.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.devs_on_deck.moneem.models.Position;

@Repository
public interface PositionRepository extends CrudRepository<Position,Long> {

	List<Position> findAll();
	
}
