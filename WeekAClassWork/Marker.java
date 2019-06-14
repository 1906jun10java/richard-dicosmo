public class Marker{

	//fields should be private
	//These instances are variables
	private String inkColor;
	private String markerType;

	//getters and setters - controls access to internal state of objects
	public String getInkColor(){
		return this.inkColor; //'this' keyword refers to the current object
	}

	public String getMarkerType(){
		return this.markerType;
	}

	public void setInkColor(String inkColor){
		this.inkColor = inkColor;
		//both the method and the instance have an inkColor variable.

	}

	public void setMarkerType(String markerType){
		this.markerType = markerType;
	}

	//toString - provides a string representation of the object
	//method is inhereted from the object class
	@Override //this indicates to the compiler that we intend to make an override of a parent method.
	public String toString() {
		return "Marker: [inkColor="+this.inkColor+", markerType=" +this.markerType+"]";
	}

}
