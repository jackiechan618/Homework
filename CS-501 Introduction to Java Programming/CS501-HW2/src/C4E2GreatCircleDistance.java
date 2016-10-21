/****************************************************************************
 *	Name: Feng Chen   
 *  CWID: 10400586 
 *	10th Edition, Chapter 4, Exercise4.2: Great Circle Distance
 *****************************************************************************/
import java.util.Scanner;
import javax.swing.JOptionPane;


public class C4E2GreatCircleDistance {
	/************** Main method *************/
	public static void main(String[] args) {

		// loop for ask guest continue or exit the computing when end of
		// computing
		while (true) {
			// definite and initialization
			boolean index = true;    // judge the input by guest is correct or error
			                         // intermediate variable
			double x1_coordinate = 0;
			double y1_coordinate = 0;
			double x2_coordinate = 0;
			double y2_coordinate = 0;
			double distance = 0;
			double tempVariable = 0;
			
			String zString = null;   // intermediate variable
			String output = null;

			// input
			for (int i = 1; i <= 4; i++) {
				while (true) {
					if (index) {
						switch (i) {
						case 1:
							zString = JOptionPane.showInputDialog("Enter the value of coordinate of x1 (double),for example 1.0");
							break;
						case 2:
							zString = JOptionPane.showInputDialog("Enter the value of coordinate of y1 (double),for example 2.0");
							break;
						case 3:
							zString = JOptionPane.showInputDialog("Enter the value of coordinate of x2 (double),for example 3.0");
							break;
						case 4:
							zString = JOptionPane.showInputDialog("Enter the value of coordinate of y2 (double),for example 4.0");
							break;
						}
					}

					// ask guest enter the number again
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
					if (index) {

						tempVariable = Double.parseDouble(zString);
						switch (i) {
						case 1:
							x1_coordinate = tempVariable;
							break;
						case 2:
							y1_coordinate = tempVariable;
							break;
						case 3:
							x2_coordinate = tempVariable;
							break;
						case 4:
							y2_coordinate = tempVariable;
							break;
						}

						break;
					}
				}
			}
			
			// computing the result
			distance = 6371.01 * Math.acos(Math.sin(Math
					.toRadians(x1_coordinate))
					* Math.sin(Math.toRadians(x2_coordinate))
					+ Math.cos(Math.toRadians(x2_coordinate))
					* Math.cos(Math.toRadians(x1_coordinate))
					* Math.cos(Math.toRadians(y1_coordinate)
							- Math.toRadians(y2_coordinate)));
			output = "";
			output = "Your input are:\nPoint1(" + x1_coordinate + ", "
					+ y1_coordinate + ") and Point2(" + x2_coordinate + ", "
					+ y2_coordinate
					+ ") \nAnswer: The distance between the two points is "
					+ distance + " km";
			JOptionPane.showMessageDialog(null, output);
			
			// ask guest continue or exit
			int option = JOptionPane.showConfirmDialog(null, "continue and begin a new computing?");

			// if guest say exit then exit
			if (option != JOptionPane.YES_OPTION){
				break;
			}
			
		}
	}

}