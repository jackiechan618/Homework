/*
 * 	10th Edition: Chapter 1, Exercise 13
 *  Name: Feng Chen   
 *  CWID: 10400586 
 */


public class C1E13LinearEquations {
	public static void main(String[] args) {
		double a, b, c, d, e, f, x, y;
		a = 3.4;
		b = 50.2;
		c = 2.1;
		d = 0.55;
		e = 44.5;
		f = 5.9;
		x = (e * d - b * f) / (a * d - b * c);
		y = (a * f - e * c) / (a * d - b * c);
		System.out.println("The result of x is : " + x);
		System.out.println("The result of y is : " + y);
	}
}
