package com.richard;

public class Product {
	private int id;
	
	public Product(int id) {
		this.id = id;
	}
	
	public int getID() {
		return this.id;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Product) {
			Product other = (Product) obj;
			
			if(other.getID() == this.id) {
				return true;
			}
		}
		return false;
	}
}
