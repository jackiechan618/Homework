/****************************************************************************
 *	Name: Feng Chen   
 *  CWID: 10400586 
 *	10th Edition, Chapter 4, Exercise4.3: Estimate Areas
 *****************************************************************************/
import java.util.Scanner;
import javax.swing.JOptionPane;


public class C4E3EstimateAreas {
	// Find them online
	//  						   latitude,              longitude
	// Atlanta, Georgia:           33.74915597435176,    -84.37077334696043
	// Orlando, Florida:           28.543104572275134,   -81.38166121694944
	// Savannah, Georgia:          32.0835407,           -81.09983419999998
	// Charlotte, North Carolina:  35.2270869,           -80.84312669999997
	
	/************** Main method *************/
	public static void main(String[] args) {
		//s1 is the area of part1, s2 is the area of part2, l1,l2,l3,l4,l5 is the length of the side of polygon
		double s1,s2,l1,l2,l3,l4,l5;
		String output = "";
		
		l1 = dis(33.75325943908751,-84.395728619635,28.53071961683232,-81.38224057409666);
		l2 = dis(28.53071961683232,-81.38224057409666,32.0835407,-81.09983419999998);
		l3 = dis(33.75325943908751,-84.395728619635,32.0835407,-81.09983419999998);
		l4 = dis(35.22540417747565,-80.84020845659177,33.75325943908751,-84.395728619635);
		l5 = dis(35.22540417747565,-80.84020845659177,32.0835407,-81.09983419999998);
		
		s1 = area(l1,l2,l3);
		s2 = area(l3,l4,l5);
		double st = s1+s2;
		
		output = "The area of first triangle is " + s1 + ", the area of second triangle is " + s2 + "\nThe area is " + st;
		JOptionPane.showMessageDialog(null, output);
	}
	
	//compute the distance between two cities by using its latitude and longitude 
	public static double dis(double x1, double y1, double x2, double y2) {
		double dis;
		dis = 6371.01 * Math.acos(Math.sin(Math.toRadians(x1))
				* Math.sin(Math.toRadians(x2)) + Math.cos(Math.toRadians(x2))
				* Math.cos(Math.toRadians(x1))
				* Math.cos(Math.toRadians(y1) - Math.toRadians(y2)));
		return dis;
	}
	
	//compute the are of a triangle by using its three length of each side
	public static double area(double side1,double side2,double side3){
		double s,area;	
		s = (side1+side2+side3)/2;
		area = Math.pow(s*(s-side1)*(s-side2)*(s-side3), 0.5);
		return area;
	}

}

