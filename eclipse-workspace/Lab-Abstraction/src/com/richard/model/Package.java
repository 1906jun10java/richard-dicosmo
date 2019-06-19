package com.richard.model;

public class Package {
	private Content content;
	private Color color;
	private Dimension dimension;
	
	//constructors
	
	public Package() {}

	public Package(Content content, Color color, Dimension dimension) {
		super();
		this.content = content;
		this.color = color;
		this.dimension = dimension;
	}
	
	//getters and setters
	
	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Dimension getDimension() {
		return dimension;
	}

	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}
	
	//override toString()
	
	@Override
	public String toString() {
		return "Package [content=" + content + ", color=" + color + ", dimension=" + dimension + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
