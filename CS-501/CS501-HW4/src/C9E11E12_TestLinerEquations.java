/**********************************************************
 * Name: Feng Chen
 * CWID: 10400586
 * 10th Edition, Chapter 9, Exercise 11 and Exercise 12
 * 
 **********************************************************/

import javax.swing.JOptionPane;

public class C9E11E12_TestLinerEquations {
	
	public static void main(String[] args) {
		while (true) {
			run();

			// ask guest continue or exit
			int option = JOptionPane.showConfirmDialog(null, "Would you like to continue and begin a new test?");

			// if guest say exit then exit
			if (option != JOptionPane.YES_OPTION) {
				break;
			}
		}	
	}
	
	public static void run() {
		String stringA = null;
		boolean flag = false;
		double x1 = 0;
		double y1 = 0;
		double x2 = 0;
		double y2 = 0;
		double x3 = 0;
		double y3 = 0;
		double x4 = 0;
		double y4 = 0;
		
		do {
			stringA = JOptionPane.showInputDialog("Please Enter the values of x1 (for example 3.0)");
			try {
				x1 = Double.parseDouble(stringA);
				flag = true;
			} catch (Exception e) {
				if(stringA == null){
					return;
				}
				JOptionPane.showMessageDialog(null, "Invalid numeber of x1 : the number you enter should be a Double");
			}
		} while (flag == false);
		
		flag = false;
		do {
			stringA = JOptionPane.showInputDialog("Please Enter the values of y1 (for example 3.0)");
			try {
				y1 = Double.parseDouble(stringA);
				flag = true;
			} catch (Exception e) {
				if(stringA == null){
					return;
				}
				JOptionPane.showMessageDialog(null, "Invalid numeber of y1 : the number you enter should be a Double");
			}
		} while (flag == false);
		
		flag = false;
		do {
			stringA = JOptionPane.showInputDialog("Please Enter the values of x2 (for example 3.0)");
			try {
				x2 = Double.parseDouble(stringA);
				flag = true;
			} catch (Exception e) {
				if(stringA == null){
					return;
				}
				JOptionPane.showMessageDialog(null, "Invalid numeber of x2 : the number you enter should be a Double");
			}
		} while (flag == false);
		
		flag = false;
		do {
			stringA = JOptionPane.showInputDialog("Please Enter the values of y2 (for example 3.0)");
			try {
				y2 = Double.parseDouble(stringA);
				flag = true;
			} catch (Exception e) {
				if(stringA == null){
					return;
				}
				JOptionPane.showMessageDialog(null, "Invalid numeber of y2 : the number you enter should be a Double");
			}
		} while (flag == false);
		
		flag = false;
		do {
			stringA = JOptionPane.showInputDialog("Please Enter the values of x3 (for example 3.0)");
			try {
				x3 = Double.parseDouble(stringA);
				flag = true;
			} catch (Exception e) {
				if(stringA == null){
					return;
				}
				JOptionPane.showMessageDialog(null, "Invalid numeber of x3 : the number you enter should be a Double");
			}
		} while (flag == false);
		
		flag = false;
		do {
			stringA = JOptionPane.showInputDialog("Please Enter the values of y3 (for example 3.0)");
			try {
				y3 = Double.parseDouble(stringA);
				flag = true;
			} catch (Exception e) {
				if(stringA == null){
					return;
				}
				JOptionPane.showMessageDialog(null, "Invalid numeber of y3 : the number you enter should be a Double");
			}
		} while (flag == false);
		
		flag = false;
		do {
			stringA = JOptionPane.showInputDialog("Please Enter the values of x4 (for example 3.0)");
			try {
				x4 = Double.parseDouble(stringA);
				flag = true;
			} catch (Exception e) {
				if(stringA == null){
					return;
				}
				JOptionPane.showMessageDialog(null, "Invalid numeber of x4 : the number you enter should be a Double");
			}
		} while (flag == false);
		
		flag = false;
		do {
			stringA = JOptionPane.showInputDialog("Please Enter the values of y4 (for example 3.0)");
			try {
				y4 = Double.parseDouble(stringA);
				flag = true;
			} catch (Exception e) {
				if(stringA == null){
					return;
				}
				JOptionPane.showMessageDialog(null, "Invalid numeber of y4 : the number you enter should be a Double");
			}
		} while (flag == false);

		C9E11E12_LinerEquations linearEquation1 = new C9E11E12_LinerEquations();
		linearEquation1.getA(y1 - y2);
		linearEquation1.getB(x2 - x1);
		linearEquation1.getC(y3 - y4);
		linearEquation1.getD(x4 - x3);
		linearEquation1.getE(-y1 * (x1 - x2) + (y1 - y2) * x1);
		linearEquation1.getF(-y3 * (x3 - x4) + (y3 - y4) * x3);

		linearEquation1.getX();
		linearEquation1.getY();

		if (linearEquation1.isSolvable()) {
			JOptionPane.showMessageDialog(null,
					"The intersection point is : " + "("
							+ linearEquation1.getX() + ", "
							+ linearEquation1.getY() + " )");
		} else {
			JOptionPane.showMessageDialog(null, "There is no intersection point");
		}
	}
}
