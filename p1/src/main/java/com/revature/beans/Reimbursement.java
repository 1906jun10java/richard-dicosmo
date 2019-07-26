package com.revature.beans;

public class Reimbursement {

	//variables
	private int reimbursement_id;
	private int user_id;
	private String title;
	private String description;
	private int status;
	private int resolved_by;
	
	//creating Reimbursements Constructor
	public Reimbursement(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}
	
	public Reimbursement(int reimbursement_id, int user_id, String title, String description, int status,
			int resolved_by) {
		super();
		this.reimbursement_id = reimbursement_id;
		this.user_id = user_id;
		this.title = title;
		this.description = description;
		this.status = status;
		this.resolved_by = resolved_by;
	}



	public int getReimbursement_id() {
		return reimbursement_id;
	}

	public void setReimbursement_id(int reimbursement_id) {
		this.reimbursement_id = reimbursement_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getResolved_by() {
		return resolved_by;
	}

	public void setResolved_by(int resolved_by) {
		this.resolved_by = resolved_by;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + reimbursement_id;
		result = prime * result + resolved_by;
		result = prime * result + status;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + user_id;
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
		Reimbursement other = (Reimbursement) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (reimbursement_id != other.reimbursement_id)
			return false;
		if (resolved_by != other.resolved_by)
			return false;
		if (status != other.status)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (user_id != other.user_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimbursement_id=" + reimbursement_id + ", user_id=" + user_id + ", title=" + title
				+ ", description=" + description + ", status=" + status + ", resolved_by=" + resolved_by + "]";
	}
	
	
	
	

}
