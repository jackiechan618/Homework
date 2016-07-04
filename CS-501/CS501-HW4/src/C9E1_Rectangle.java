/*******************************************
 * Name: Feng Chen
 * CWID: 10400586
 * 10th Edition, Chapter 9, Exercise 1
 * 
 *******************************************/

public class C9E1_Rectangle {
	public double width = 1;
	public double height = 1;
	public String errorMessage = "";

	public C9E1_Rectangle() {

	}

	public void setWidth(double _width) throws Exception {
		if (!isValidWidth(_width)) {
			Exception e = new Exception(errorMessage);
			throw e;
		}
		width = _width;
	}

	public void setHeight(double _height) throws Exception {
		if (!isValidHeight(_height)) {
			Exception e = new Exception(errorMessage);
			throw e;
		}
		height = _height;
	}

	public boolean isValidWidth(double _width) {
		if (_width > 0) {
			return true;
		}
		errorMessage = "Invalid numeber of width : the number you enter should be > 0";
		return false;
	}

	public boolean isValidHeight(double _height) {
		if (_height > 0) {
			return true;
		}
		errorMessage = "Invalid numeber of height : the number you enter should be > 0";
		return false;
	}

	public String getMessage() {
		return errorMessage;
	}

	public double getArea() {
		return width * height;
	}

	public double getPerimeter() {
		return 2 * (width + height);

	}		
}
