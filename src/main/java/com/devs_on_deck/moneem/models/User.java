package com.devs_on_deck.moneem.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

	// member variables

	// The @GeneratedValue annotation provides us with different strategies for the
	// generation of primary keys which are as follows : GenerationType.IDENTITY:
	// This strategy will help us to generate the primary key value by the database
	// itself using the auto-increment column option
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "* First Name must not be empty ")
	private String firstName;

	@NotEmpty(message = "* Last Name must not be empty")
	private String lastName;

	@Email
	@NotEmpty(message = "* Email is required ")
	private String email;

	@NotEmpty(message = "* Adresse must not be empty")
	private String addresse;

	@NotNull(message = "* City is required ")
	private String city;

	@NotNull(message = "* State is required ")
	private String state;

	@NotEmpty
	@Size(min = 8, message = "* Password must at least 8 characters")
	private String password;

	private String image_url;

	@Transient
	@Size(min = 8, max = 20, message = "* Confirm Password must between 8 and 20 characters")
	private String confirm;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(updatable = false)
	private Date createdAt;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

	// user can have one profile & one profile belongs to one developer
	@OneToOne(mappedBy = "developer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Profile profile;

	// beans constructor
	public User() {
	}

	// getters & setters
	@PrePersist
	protected void createdOn() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void updatedOn() {
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

	public String getAddresse() {
		return addresse;
	}

	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
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

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

}
