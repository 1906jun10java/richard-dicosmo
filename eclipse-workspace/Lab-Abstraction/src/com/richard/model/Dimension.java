package com.richard.model;

public class Dimension {
	private double width;
	private double height;
	private double length;
	
	//constructors
	
	public Dimension() {}
	
	public Dimension(double width, double height, double length) {
		super();
		this.width = width;
		this.height = height;
		this.length = length;
	}

	//getters and setters
	
	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}
	
	//overrride toString()
	
	@Override
	public String toString() {
		return "Dimension [width=" + width + ", height=" + height + ", length=" + length + "]";
	}
	
	
	
	
	
}
