package com.isport.moneem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isport.moneem.model.Event;
import com.isport.moneem.model.Picture;
import com.isport.moneem.model.User;
import com.isport.moneem.repository.PictureRepository;

@Service
public class PictureService {
	
	// inject PictureRepository
	@Autowired
	private PictureRepository repo;

	// save picture
	public void savePicture(String url,User creator) {
		Picture newPicture= new Picture(url,creator);
		this.repo.save(newPicture);		
	}

	
}
