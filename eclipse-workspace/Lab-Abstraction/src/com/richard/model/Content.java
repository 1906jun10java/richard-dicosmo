package com.richard.model;

public class Content {
	private int amount;
	private String description;
	
	//Constructors
	
	public Content() {}
	
	public Content(int amount, String description) {
		super();
		this.amount = amount;
		this.description = description;
	}

	//getters and setters
	
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	//override toString()
	@Override
	public String toString() {
		return "Content [amount=" + amount + ", description=" + description + "]";
	}
	
	
	
	
	
	
	
}
