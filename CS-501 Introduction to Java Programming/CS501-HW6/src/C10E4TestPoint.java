/*******************************************
 * Name: Feng Chen
 * CWID: 10400586
 * 10th Edition, Chapter 10, Exercise 4
 * 
 * test class
 * 
 *******************************************/

import javax.swing.JOptionPane;

public class C10E4TestPoint {
	public static void main(String[] args) {
		double x1 = 0, y1 = 0, x2 = 10, y2 = 30.5;
		C10E4MyPoint p1 = new C10E4MyPoint(x1, y1);
		C10E4MyPoint p2 = new C10E4MyPoint(x2, y2);
		double output1 = Math.rint(p1.distance(p2) * 100) / 100.00;
		double output2 = Math.rint(C10E4MyPoint.distance(p1, p2) * 100) / 100.00;
		JOptionPane.showMessageDialog(null, "the distance between point(0, 0) and point(10, 30.5) catched by distance(MyPoint secondPoint) method is :" + output1);
		JOptionPane.showMessageDialog(null, "the distance between point(0, 0) and point(10, 30.5) catched by distance(MyPoint p1, MyPoint p2) method is :" + output2);
	}
}
