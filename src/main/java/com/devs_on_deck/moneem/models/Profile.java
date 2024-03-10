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
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "skills")
public class Profile {

	// The @GeneratedValue annotation provides us with different strategies for the
	// generation of primary keys which are as follows : GenerationType.IDENTITY:
	@Id
	// This strategy will help us to generate the primary key value by the database
	// itself using the auto-increment column option
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private ArrayList<String> languages = new ArrayList<>();

	private ArrayList<String> frameworks = new ArrayList<>();

	private String biography;

	private String profession;

	private Integer experience;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(updatable = false)
	private Date createdAt;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

	// one profile belong to one developer & one developer can have only one profile
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User developer;

	// beans constructor
	public Profile() {
	}

	// getters & setters
	@PrePersist
	public void createdOn() {
		this.createdAt = new Date();
	}

	@PreUpdate
	public void updatedOn() {
		this.updatedAt = new Date();
	}

	public Long getId() {
		return id;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public ArrayList<String> getLanguages() {
		return languages;
	}

	public void setLanguages(ArrayList<String> languages) {
		this.languages = languages;
	}

	public ArrayList<String> getFrameworks() {
		return frameworks;
	}

	public void setFrameworks(ArrayList<String> frameworks) {
		this.frameworks = frameworks;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
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

	public void setId(Long id) {
		this.id = id;
	}

	public User getDeveloper() {
		return developer;
	}

	public void setDeveloper(User developer) {
		this.developer = developer;
	}

}
