/*
 * 	10th Edition: Chapter 2, Exercise 19
 *  Name: Feng Chen   
 *  CWID: 10400586 
 */


import java.util.Scanner;

public class C2E19Area {
	public static void main(String[] args) {
		System.out.println("Enter three poiont for a triangle: ");
		double x1 = 0, y1 = 0, x2 = 0, y2 = 0, x3 = 0, y3 = 0, side1, side2, side3, s, area;
		Scanner in = new Scanner(System.in);
		x1 = in.nextDouble();
		y1 = in.nextDouble();
		x2 = in.nextDouble();
		y2 = in.nextDouble();
		x3 = in.nextDouble();
		y3 = in.nextDouble();

		side1 = computeSide(x1, y1, x2, y2);
		side2 = computeSide(x1, y1, x3, y3);
		side3 = computeSide(x3, y3, x2, y2);
		if (side1 * side2 * side3 == 0) {
			System.out.println("Please enter correct data to constract a triangle");
			return;
		} else {
			s = (side1 + side2 + side3) / 2;
			area = Math.pow(s * (s - side1) * (s - side2) * (s - side3), 0.5);
			area = Double.parseDouble(String.format("%.2f", area));
			System.out.println("The area of the triangle is " + area);
		}

	}

	private static double computeSide(double x1, double y1, double x2, double y2) {
		double side = Math.pow((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1), 0.5);
		return side;
	}

}
