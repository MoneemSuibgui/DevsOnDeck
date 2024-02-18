package com.isport.moneem.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class User {

	// member variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "First name must be not empty")
	private String firstName;

	@NotEmpty(message = "Last name must be not empty")
	private String lastName;

	@Email(message = "Email is required")
	@NotEmpty(message = "Email must be not empty")
	private String email;

	@NotEmpty(message = "Password must be not empty")
	@Size(min = 8, message = "Password must at least 8 characters")
	private String password;

	@NotNull(message = "Birthdate must be not empty")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthdate;

	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

	// user can create many events
	@OneToMany(mappedBy = "creator", fetch = FetchType.LAZY)
	private List<Event> events;

	// user can upload many pictures
	@OneToMany(mappedBy="creator",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Picture> pictures;

	// n:n connection : user can join to many events
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "favourites", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "event_id"))
	private List<Event> favouriteEvents;

	// zero args constructor
	public User() {
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

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
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
	
	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public List<Picture> getPictures() {
		return pictures;
	}

	public void setPictures(List<Picture> pictures) {
		this.pictures = pictures;
	}

	public List<Event> getFavouriteEvents() {
		return favouriteEvents;
	}

	public void setFavouriteEvents(List<Event> favouriteEvents) {
		this.favouriteEvents = favouriteEvents;
	}


}
