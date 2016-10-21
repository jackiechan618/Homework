/*******************************************
 * Name: Feng Chen
 * CWID: 10400586
 * 10th Edition, Chapter 10, Exercise 13
 * 
 * myMyRectangle2D class
 * 
 *******************************************/

import javax.swing.JOptionPane;

public class C10E13MyRectangle2D {
	double x, y;
	double width, height;
	
	/**
	 * Constructor with no args*/
	public C10E13MyRectangle2D() {
		x = 0;
		y = 0;
		width = 1;
		height = 1;
	}
	
	/**
	 * Constructor - initializes the rectangle*/
	public C10E13MyRectangle2D(double x1, double y1, double w, double h){
		x = x1;
		y = y1;
		width = w;
		height = h;
	}
	
	public double getX(){
		return this.x;
	}
	
	public void setX(double x1) throws Exception{
		this.x = x1;
	}
	
	public double getY(){
		return this.y;
	}
	
	public void setY(double y1) throws Exception{

		this.x = y1;
	}
	
	public double getWidth(){
		return this.width;
	}
	
	public void setWidth(double w) throws Exception{
		if(!isValidWidth(w)){
			Exception e = new Exception();
			throw e;
		}
		this.width = w;
	}
	
	public double getHeight(){
		return this.height;
	}
	
	public void setHeight(double h) throws Exception{
		if(!isValidHeight(h)){
			Exception e = new Exception();
			throw e;
		}
		this.height = h;
	}
	
	
	public boolean isValidWidth(double w){
		if(w > 0){
			return true;
		}
		return false;
	}
	
	public boolean isValidHeight(double h){
		if(h > 0){
			return true;
		}
		return false;
	}
	
	/**
	 * Method to calculate Area of rectangle*/
	private double getArea(){
		return this.width * this.height;
	}
	
	
	/**
	 * Method to calculate Perimeter of rectangle*/
	private double getPerimeter(){
		return 2 * (this.width + this.height);
	}
	
	
	/**
	 * Method to find if given point is contained in rectangle*/
	public boolean contains(double x, double y){
		double rectX = getX();
		double rectY = getY();
		double halfWidth = getWidth()/2;
		double halfHeight = getHeight()/2;
		
		double X_Left_Limit = rectX - halfWidth;
		double X_Right_Limit = rectX + halfWidth;
		
		double Y_Down_Limit = rectY - halfHeight;
		double Y_Up_Limit = rectY + halfHeight;
		
		
		if (x >= X_Left_Limit && x <= X_Right_Limit && y <= Y_Up_Limit && y >= Y_Down_Limit)
			return true;
		else
			return false;
	}
	
	
	/**
	 * Method to find if given rectangle is contained in this rectangle*/
	public boolean contains(C10E13MyRectangle2D r){
		
			double innerLeftLimit = r.getX() - r.width/2;
			double innerRightLimit = r.getX() + r.width/2;
			double innerUpLimit = r.getY() + r.height/2;
			double innerDownLimit = r.getY() - r.height/2;
			
			double outerLeftLimit = this.getX() - this.width/2;
			double outerRightLimit = this.getX() + this.width/2;
			double outerUpLimit = this.getY() + this.height/2;
			double outerDownLimit = this.getY() - this.height/2;
			
			if (innerLeftLimit > outerLeftLimit && innerRightLimit < outerRightLimit && innerUpLimit < outerUpLimit && innerDownLimit > outerDownLimit)
				return true;
			else
				return false;
		
	}
	
	
	/**
	 * Method to find if given rectangle overlaps this rectangle*/
	public boolean overlaps(C10E13MyRectangle2D r){
		double innerLeftLimit = r.getX() - r.width/2;
		double innerRightLimit = r.getX() + r.width/2;
		double innerUpLimit = r.getY() + r.height/2;
		double innerDownLimit = r.getY() - r.height/2;
		
		double outerLeftLimit = this.getX() - this.width/2;
		double outerRightLimit = this.getX() + this.width/2;
		double outerUpLimit = this.getY() + this.height/2;
		double outerDownLimit = this.getY() - this.height/2;
		
		if (outerLeftLimit < innerRightLimit && outerRightLimit > innerLeftLimit && outerUpLimit > innerDownLimit && outerDownLimit < innerUpLimit)
			return true;
		else
			return false;
	}

}
	
