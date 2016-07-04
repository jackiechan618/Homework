/*******************************************
 * Name: Feng Chen
 * CWID: 10400586
 * 10th Edition, Chapter 9, Exercise 1
 * 
 *******************************************/

import javax.swing.JOptionPane;

public class C9E1_TestRectangle {
	
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
		String _heightString = null;
		String _widthString = null;
		int x = 1;
		int y = 1;

		C9E1_Rectangle r1 = new C9E1_Rectangle();
		do {
			_widthString = JOptionPane.showInputDialog("Enter the width of rectangle (for example 4.0)");
			try {
				double w = Double.parseDouble(_widthString);
				r1.setWidth(w);
				x++;
			} catch (Exception e) {
				if(_widthString == null){
					return;
				}
				JOptionPane.showMessageDialog(null, "Invalid numeber of width : the number you enter should be > 0");
			}
		} while (x == 1);
		
		do {
			_heightString = JOptionPane.showInputDialog("Enter the height of rectangle (for example 4.0)");
			try {
				double h = Double.parseDouble(_heightString);
				r1.setHeight(h);
				y++;
			} catch (Exception e) {
				if(_heightString == null){
					return;
				}
				JOptionPane.showMessageDialog(null, "Invalid numeber of height : the number you enter should be > 0");
			}
		} while (y == 1);

		JOptionPane.showMessageDialog(null,
				"The area and perimeter of the rectangle of width " + r1.width
						+ " and height " + r1.height + "\n" + " are "
						+ r1.getArea() + " and " + r1.getPerimeter());

	}

}
