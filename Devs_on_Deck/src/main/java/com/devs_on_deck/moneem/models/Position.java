package com.devs_on_deck.moneem.models;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="postions")
public class Position {
	
	// member variables
		@Id
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
