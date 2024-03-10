package com.devs_on_deck.moneem.models;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name="postions")
public class Position {
	
	// member variables
	
		// The @GeneratedValue annotation provides us with different strategies for the
		// generation of primary keys which are as follows : GenerationType.IDENTITY:
		
		@Id
		// This strategy will help us to generate the primary key value by the database itself using the auto-increment column option
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
		
		@NotEmpty(message="* Name must not be empty ")
		private String name;
		
		@NotEmpty(message="* Description must not be empty ")
		private String description;
		
		@NotEmpty(message="* Skills must not be empty ")
		ArrayList<String> skills = new ArrayList<String>();
		
		@DateTimeFormat(pattern="yyyy-MM-dd")
		@Column(updatable=false)
		private Date createdAt;
		
		@DateTimeFormat(pattern="yyyy-MM-dd")
		private Date updatedAt;
		
		// relashionShip :one organization can add many positions & one position belongs to one organization
		@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name="organization_id")
		private Organization organization;
	
		
		// beans constructor
		public Position() {}
		
		
		// getters & setters
		@PrePersist
		public void createdOn() {
			this.createdAt=new Date();
		}
		
		@PreUpdate
		public void updatedOn() {
			this.updatedAt=new Date();
		}


		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public String getDescription() {
			return description;
		}


		public void setDescription(String description) {
			this.description = description;
		}


		public ArrayList<String> getSkills() {
			return skills;
		}


		public void setSkills(ArrayList<String> skills) {
			this.skills = skills;
		}


		public Date getCreatedAt() {
			return createdAt;
		}


		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}


		public Date getUpdatedAt() {
			return updatedAt;
		}


		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}


		public Organization getOrganization() {
			return organization;
		}


		public void setOrganization(Organization organization) {
			this.organization = organization;
		}

}
