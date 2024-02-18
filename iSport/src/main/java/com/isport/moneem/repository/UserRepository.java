package com.isport.moneem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.isport.moneem.model.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

	Optional<User> findByEmail(String email);
	List<User> findAll();
}
