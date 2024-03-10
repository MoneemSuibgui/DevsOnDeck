package com.devs_on_deck.moneem.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class LoginOrg {

	// member variables
		@Email
		@NotEmpty(message="* Email is required ")
		private String email;
		
		@NotEmpty
		@Size(min=8,max=20,message="* Password must between 8 and 20 characters")
		private String password;
		
		// beans constructor
		public LoginOrg() {}

		
		// getters & setters
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
		
		
}
