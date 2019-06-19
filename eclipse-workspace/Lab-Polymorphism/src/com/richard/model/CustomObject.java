package com.richard.model;

public class CustomObject {
	private String name;
	public CustomObject() {}
	
	public CustomObject(String name) {
		this.name = name;
	}
	
	public String getName() { return this.name; }
	
	public String toString() {
		return this.getName();
	}
	
}
