/*******************************************
 * Name: Feng Chen
 * CWID: 10400586
 * 10th Edition, Chapter 11, Exercise 1
 * 
 * GeometricObject class
 * 
 *******************************************/

public class C11E1GeometricObject {
	private String color = " white ";
	private boolean filled;
	private java.util.Date dateCreated;

	public C11E1GeometricObject() {
		dateCreated = new java.util.Date();
	}

	public C11E1GeometricObject(String color, boolean filled) {
		dateCreated = new java.util.Date();
		this.color = color;
		this.filled = filled;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	public java.util.Date getDateCreated() {
		return dateCreated;
	}

	public String toString() {
		return "Created on " + dateCreated + "\n color: " + color
				+ " and filled ";
	}
}
