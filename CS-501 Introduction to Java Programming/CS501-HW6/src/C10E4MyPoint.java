/*******************************************
 * Name: Feng Chen
 * CWID: 10400586
 * 10th Edition, Chapter 10, Exercise 4
 * 
 * myPoint class
 * 
 *******************************************/

class C10E4MyPoint {
	  private double x = 0;
	  private double y = 0;

	  
	  public C10E4MyPoint() {
		  x = 0;
		  y = 0;
	  }

	  public C10E4MyPoint(double x, double y) {
	    this.x = x;
	    this.y = y;
	  }

	  public double distance(C10E4MyPoint secondPoint) {
	    return distance(this, secondPoint);
	  }

	  public static double distance(C10E4MyPoint p1, C10E4MyPoint p2) {
	    return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y)
	        * (p1.y - p2.y));
	  }

	  public double getX() {
	    return x;
	  }

	  public double getY() {
	    return y;
	  }
	}