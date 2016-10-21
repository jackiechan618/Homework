/****************************************************************************
 *	Name: Feng Chen   
 *  CWID: 10400586 
 *	10th Edition, Chapter 3, Exercise3.3: Solve linear equations
 *****************************************************************************/
import java.util.Scanner;
import javax.swing.JOptionPane;

public class C3E3SolveLinearEquations {

	/************** Main method *************/
	public static void main(String[] args) {

		// loop for ask guest continue or exit the computing when end of
		// computing
		while (true) {
			// definite and initialization
			boolean index = true;    // judge the input by guest is correct or error
			double z = 0;            // intermediate variable
			double a = 0;
			double b = 0;
			double c = 0;
			double d = 0;
			double e = 0;
			double f = 0;
			double x = 0;
			double y = 0;
			String zString = null;   // intermediate variable
			String output = null;

			// input six number for a b c d e f
			for (int i = 1; i <= 6; i++) {
				while (true) {
					if (index) {
						switch (i) {
						case 1:
							zString = JOptionPane.showInputDialog("The first equation will be ax + by = e and second equation will be cx + dy = f \nPlease enter the value of a (double), for example 9.0");
							break;
						case 2:
							zString = JOptionPane.showInputDialog("Enter the value of b (double), for example 4.0");
							break;
						case 3:
							zString = JOptionPane.showInputDialog("Enter the value of c (double), for example 3.0");
							break;
						case 4:
							zString = JOptionPane.showInputDialog("Enter the value of d (double), for example -5.0");
							break;
						case 5:
							zString = JOptionPane.showInputDialog("Enter the value of e (double), for example -6.0");
							break;
						case 6:
							zString = JOptionPane.showInputDialog("Enter the value of f (double), for example -21.0");
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

						z = Double.parseDouble(zString);
						switch (i) {
						case 1:
							a = z;
							break;
						case 2:
							b = z;
							break;
						case 3:
							c = z;
							break;
						case 4:
							d = z;
							break;
						case 5:
							e = z;
							break;
						case 6:
							f = z;
							break;
						}

						break;
					}
				}
			}
			// computing the result
			if ((a * d - b * c) == 0) {
				JOptionPane.showMessageDialog(null, "The equation has no solution.");
			} else {
				x = ((e * d) - (b * f)) / ((a * d) - (b * c));
				y = ((a * f) - (e * c)) / ((a * d) - (b * c));
				
				// round the result and reserve two decimal places
				x = Math.rint(x * 100) / 100.00;
				y = Math.rint(y * 100) / 100.00;
				
				// display the output
				output = "Your input are: \n" + a + "x + " + b + "y = " + e
						+ "\n" + c + "x + " + d + "y = " + f + "\nAnswer: "
						+ "x is " + x + " and " + "y is " + y;
				JOptionPane.showMessageDialog(null, output);
			}

			// ask guest continue or exit
			int option = JOptionPane.showConfirmDialog(null, "continue and begin a new computing?");

			// if guest say exit then exit
			if (option != JOptionPane.YES_OPTION)
				break;

		}
	}
}
