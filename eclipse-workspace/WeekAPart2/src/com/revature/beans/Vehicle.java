package com.revature.beans;

public abstract class Vehicle {
	
	/*
	 * Abstract class:
	 * Cannot be instantiated
	 * Can have both abstract and concrete methods
	 * 
	 * Alt-shift S for code generators 
	 */
	
	private int topSpeed = 120; //setting a default value for instance field topSpeed
	
	

	public int getTopSpeed() {
		return topSpeed;
	}

	public void setTopSpeed(int topSpeed) {
		this.topSpeed = topSpeed;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + topSpeed;
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
		Vehicle other = (Vehicle) obj;
		if (topSpeed != other.topSpeed)
			return false;
		return true;
	}
	
	//public abstract void move();
	
	
	
	
	
}
