package com.revature.beans;

public class User {
	
	//constructors
	//For Authentication and info pull
	public User(String username, String pass, String firstName, String lastName, String email, int seesTo, String title) {
		super();
		this.username = username;
		this.pass = pass;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.seesTo = seesTo;
		this.title = title;
		
	}
	//For session
	public User(String username, String firstName, String lastName, String email, int seesTo, String title) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.seesTo = seesTo;
		this.title = title;
		
	}
	//For User Queries
		public User(int userID, String firstName, String lastName, String email, int seesTo, String title) {
			super();
			this.userID = userID;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.seesTo = seesTo;
			this.title = title;
			
		}
	//Variables
	private int userID;
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private String pass;
	private int seesTo;
	private String title;

	
	//data control
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public int getSeesTo() {
		return seesTo;
	}
	public void setSeesTo(int seesTo) {
		this.seesTo = seesTo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		result = prime * result + seesTo;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + userID;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		if (seesTo != other.seesTo)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (userID != other.userID)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "User [userID=" + userID + ", username=" + username + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", pass=" + pass + ", seesTo=" + seesTo + ", title=" + title + "]";
	}
	
}
