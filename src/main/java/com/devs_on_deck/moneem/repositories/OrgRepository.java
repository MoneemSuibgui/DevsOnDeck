package com.devs_on_deck.moneem.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devs_on_deck.moneem.models.Organization;

@Repository
public interface OrgRepository extends JpaRepository<Organization, Long> {

	Organization findByEmail(String email);
}
