package com.isport.moneem.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.isport.moneem.model.Event;

public interface EventRepository extends CrudRepository<Event,Long> {

	List<Event> findAll();
	
	List<Event> findByNameContains(String name);
	List<Event> findByLocationContains(String location);
	List<Event> findByCreatorContains(String creator);
}
