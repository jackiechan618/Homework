/*******************************************
 * Name: Feng Chen
 * CWID: 10400586
 * 10th Edition, Chapter 11, Exercise 1
 * 
 * TestTriangle class
 * 
 *******************************************/

import javax.swing.JOptionPane;

public class C11E1TestTriangle {
	

	public static void main(String[] args) {		
		String tempString;
		double side1 = 0;
		double side2 = 0;
		double side3 = 0;
		int y = 0;
		while(y == 0){
			
		
			int x1 = 0;
			while(x1 == 0){
				try{
					tempString = JOptionPane.showInputDialog("Enter length the first side   ");
					if(tempString == null){
						return;
					}
					side1 = Double.parseDouble(tempString);
					if(side1 <= 0){
						Exception e = new Exception();
						throw e;
					}
					x1 = 1;
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(null, " Error input, plesae enter again ");
				}
			}
			
			int x2 = 0;
			while(x2 == 0){
				try{
					tempString = JOptionPane.showInputDialog("  Enter length the second side ");
					if(tempString == null){
						return;
					}
					side2 = Double.parseDouble(tempString);
					if(side2 <= 0){
						Exception e = new Exception();
						throw e;
					}
					x2 = 1;
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(null, " Error input, plesae enter again ");
				}
			}
			
			int x3 = 0;
			while(x3 == 0){
				try{
					tempString = JOptionPane.showInputDialog("  Enter length the third side ");
					if(tempString == null){
						return;
					}
					side3 = Double.parseDouble(tempString);
					if(side3 <= 0){
						Exception e = new Exception();
						throw e;
					}
					x3 = 1;
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(null, " Error input, plesae enter again ");
				}
			}
			y = 1;
		}
		
		String color = null;
		color = JOptionPane.showInputDialog(" enter the color of Triangle ");
		if(color == null){
			return;
		}
		int option;
		String filled = null;
		option = JOptionPane.showConfirmDialog(null, "Is the Triangle filled?");
		if(color == null){
			return;
		}
		if(option == JOptionPane.YES_OPTION){
			filled = "the Triangle  is filled";
		}
		else {
			filled = "the Triangle is not filled";
		}

		System.out.println(" Is the Triangle filled? Reply with 'True' or 'False' ");

		C11E1Triangle triangle;
		try {
			triangle = new C11E1Triangle(side1, side2, side3);
			
			// set color of Triangle
			triangle.setColor(color);
			if (filled.equals("the Triangle  is filled")) {
				triangle.setFilled(true);

			} else {
				triangle.setFilled(false);

			}
			
			JOptionPane.showMessageDialog(null,"The Triangle Sides are \n side 1: "
					+ triangle.getSide1() + "\n Side 2: " + triangle.getSide2()
					+ "\n Side 3: " + triangle.getSide3());
			JOptionPane.showMessageDialog(null,"The Triangle's Area is " + triangle.getArea());		
			JOptionPane.showMessageDialog(null,"The Triangle's Perimeter is " + triangle.getPerimeter());			
			JOptionPane.showMessageDialog(null,"The Triangle's Color is " + triangle.getColor());
			JOptionPane.showMessageDialog(null,"Is the Triangle filled? " + triangle.isFilled());
		} catch (C11E1IllegalTriangleException e) {
			// TODO Auto-generated catch block			
			JOptionPane.showMessageDialog(null,"Error input, the sum of two side should be larger than the third one");
		}
	}

}