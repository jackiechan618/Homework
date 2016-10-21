import java.util.Scanner;
import javax.swing.JOptionPane;

/****************************************************************************
 *	Name: Feng Chen   
 *  CWID: 10400586 
 *	10th Edition, Chapter 3, Exercise3.23: Point in a rectangle
 *****************************************************************************/

public class C3E23PointInRectangle {
	/************** Main method *************/
	public static void main(String[] args) {
		// loop for ask guest continue or exit the computing when end of test
		while (true) {
			// definite and initialization
			boolean index = true;    // judge the input by guest is correct or error
			            			 // intermediate variable
			double x_centerCoordinate = 0;
			double y_centerCoordinate = 0;
			double height = 0;
			double width = 0;
			double x_coordinates_test = 0;
			double y_coordinates_test = 0;
			
			double leftSide = 0;     
			double rightSide = 0;
			double topSide = 0;
			double bottomSide = 0;

			String zString = null;   
			String output = null;

			// input
			for (int i = 1; i <= 6; i++) {
				while (true) {
					if (index) {
						switch (i) {
						case 1:
							zString = JOptionPane.showInputDialog("Enter the value of center coordinate of x (double),for example 9.0");
							break;
						case 2:
							zString = JOptionPane.showInputDialog("Enter the value of center coordinate of y (double),for example 4.0");
							break;
						case 3:
							zString = JOptionPane.showInputDialog("Enter the value of height (positive double),for example 3.0");
							break;
						case 4:
							zString = JOptionPane.showInputDialog("Enter the value of width (positive double),for example 5.0");
							break;
						case 5:
							zString = JOptionPane.showInputDialog("Enter the value of coordinate of x for test (double),for example 6.0");
							break;
						case 6:
							zString = JOptionPane.showInputDialog("Enter the value of coordinate of y for test (double),for example 21.0");
							break;
						}
					}

					// ask guest enter the number again when previous input is incorrect
					else {
						if(zString == null){
							return;
						}
						zString = JOptionPane.showInputDialog(null, "Error input , please enter a correct value again");
					}

					index = true;

					// check whether the input is a number
					try {
						Double.parseDouble(zString);
					} catch (Exception e1) {
						index = false;
					}

					// Convert string to double
					double tempVariable = 0;
					if (index) {
						tempVariable = Double.parseDouble(zString);
						switch (i) {
						case 1:
							x_centerCoordinate = tempVariable;
							break;
						case 2:
							y_centerCoordinate = tempVariable;
							break;
						case 3:
							height = tempVariable;
							break;
						case 4:
							width = tempVariable;
							break;
						case 5:
							x_coordinates_test = tempVariable;
							break;
						case 6:
							y_coordinates_test = tempVariable;
							break;
						}
						break;
					}
				}
			}
			
			leftSide = x_centerCoordinate - width / 2;
			rightSide = x_centerCoordinate + width / 2;
			topSide = y_centerCoordinate - height / 2;
			bottomSide = y_centerCoordinate + height / 2;

			output = "";
			output = "Your input are:\ncenter coordinates of rectangle is ("
					+ x_centerCoordinate + ", " + y_centerCoordinate + ") \n"
					+ "Width is " + width + ", Height is " + height + " \n"
					+ "test point is (" + x_coordinates_test + ", "
					+ y_coordinates_test + ") \n";

			if (x_coordinates_test >= leftSide
					&& x_coordinates_test <= rightSide
					&& y_coordinates_test >= topSide
					&& y_coordinates_test <= bottomSide) {
				if (x_coordinates_test == leftSide
						|| x_coordinates_test == rightSide
						|| y_coordinates_test == topSide
						|| y_coordinates_test == bottomSide) {
					output += "Answer: this point is on the boundary of the rectangle";
					JOptionPane.showMessageDialog(null, output);
				} else {
					output += "Answer: this point is inside of the rectangle";
					JOptionPane.showMessageDialog(null, output);
				}
			} else {
				output += "Answer: this point is outside of the rectangle";
				JOptionPane.showMessageDialog(null, output);
			}
			
			// ask guest continue or exit
			int option = JOptionPane.showConfirmDialog(null,
					"continue and begin a new test?");

			// if guest say exit then exit
			if (option != JOptionPane.YES_OPTION)
				break;
		}
	}

}
