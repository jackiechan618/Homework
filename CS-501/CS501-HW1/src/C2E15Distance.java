/*
 * 	10th Edition: Chapter 2, Exercise 15
 *  Name: Feng Chen   
 *  CWID: 10400586 
 */


import java.util.Scanner;

public class C2E15Distance {
	public static void main(String[] args) {
		System.out.println("compute the distance between point a and point b : ");
		System.out.println("please enter x1 and y1");
		Scanner in = new Scanner(System.in);
		double x1 = in.nextDouble();
		double y1 = in.nextDouble();

		System.out.println("please enter x2 and y2");
		Scanner in2 = new Scanner(System.in);
		double x2 = in2.nextDouble();
		double y2 = in2.nextDouble();

		double distance = Math.pow((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1), 0.5);

		System.out.println("The distance between two point is : " + distance);
	}
}
