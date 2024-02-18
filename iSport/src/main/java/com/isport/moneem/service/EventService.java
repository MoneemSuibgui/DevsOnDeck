package com.isport.moneem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isport.moneem.model.Event;
import com.isport.moneem.repository.EventRepository;

@Service
public class EventService {
	
	// inject EventRepository
	@Autowired
	private EventRepository repository;

	// create event
	public Event addEvent(Event event) {
		return this.repository.save(event);
	}
	
	// update event same method as create
	public Event updateEvent(Event event) {
		return this.repository.save(event);
	}
	
	// get One event
	public Event getEvent(Long id) {
		Optional<Event> optionalEvent=this.repository.findById(id);
		if(optionalEvent.isPresent()) {
			return optionalEvent.get();
		}return null;
	}
	
	// get all events
	public List<Event> getAll(){
		return this.repository.findAll();
	}
	
	// get all events by events name
	public List<Event> getAllByname(String name){
		return this.repository.findByNameContains(name);
	}
	
	// get all events by events locations
		public List<Event> getAllByLocation(String location){
			return this.repository.findByLocationContains(location);
		}
	
	// get all events by events creator
	   public List<Event> getAllByCreator(String creator){
			return this.repository.findByLocationContains(creator);
		}
	
	
	
}
