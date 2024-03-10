package com.devs_on_deck.moneem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devs_on_deck.moneem.models.Position;

@Repository
public interface PositionRepository extends JpaRepository<Position,Long> {

	List<Position> findAll();
	
}
