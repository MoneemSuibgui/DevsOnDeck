package com.isport.moneem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.isport.moneem.model.Picture;

@Repository
public interface PictureRepository extends CrudRepository<Picture,Long> {

}
