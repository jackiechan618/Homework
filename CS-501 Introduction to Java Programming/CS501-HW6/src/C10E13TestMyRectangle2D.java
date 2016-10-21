/*******************************************
 * Name: Feng Chen
 * CWID: 10400586
 * 10th Edition, Chapter 10, Exercise 13
 * 
 * test class
 * 
 *******************************************/

import javax.swing.JOptionPane;

public class C10E13TestMyRectangle2D {
	public static void main(String [] args){	
		double x = 0;
		double y = 0;
		double width = 0;
		double height = 0;
		double xTestP = 0;
		double yTestP = 0;
		double xTest = 0;
		double yTest = 0;
		double widthTest = 0;
		double heightTest = 0;
		String tempString;
		
		C10E13MyRectangle2D r1 = new C10E13MyRectangle2D();
		C10E13MyRectangle2D r2 = new C10E13MyRectangle2D();
		int option = JOptionPane.YES_OPTION;
		while(option == JOptionPane.YES_OPTION){
			
			JOptionPane.showMessageDialog(null, " Enter parameters of first rectangle ");
			int x1 = 0;
			while(x1 == 0){
				try{
					tempString = JOptionPane.showInputDialog(" Please enter the x-axes of the first Rectangle : ");
					if(tempString == null){
						return;
					}
					r1.setX(Double.parseDouble(tempString));
					x1 = 1;
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(null, "  x-axes must be a digit ");
				}
			}
			
			int y1 = 0;
			while(y1 == 0){
				try{
					tempString = JOptionPane.showInputDialog(" Please enter the y-axes of the first Rectangle : ");
					if(tempString == null){
						return;
					}
					r1.setY(Double.parseDouble(tempString));
					y1 = 1;
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(null, " y-axes must be a digit ");
				}
			}
			
			int width1 = 0;
			while(width1 == 0){
				try{
					tempString = JOptionPane.showInputDialog(" Please enter the width of the first Rectangle : ");
					if(tempString == null){
						return;
					}
					r1.setWidth(Double.parseDouble(tempString));
					width1 = 1;
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(null, " width must be a positive digit ");
				}
			}
			
			int height1 = 0;
			while(height1 == 0){
				try{
					tempString = JOptionPane.showInputDialog(" Please enter the height of the first Rectangle : ");
					if(tempString == null){
						return;
					}
					r1.setHeight(Double.parseDouble(tempString));
					height1 = 1;
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(null, " height must be a positive digit  ");
				}
			}
			while(option == JOptionPane.YES_OPTION){
				JOptionPane.showMessageDialog(null, " Enter parameters of the test point ");
				int x11 = 0;
				while(x11 == 0){
					try{
						tempString = JOptionPane.showInputDialog(" Please enter the x-axes of the test point : ");
						if(tempString == null){
							return;
						}
						xTestP = Double.parseDouble(tempString);
						x11 = 1;
					}
					catch(Exception e){
						JOptionPane.showMessageDialog(null, "  x-axes must be a digit ");
					}
				}
				
				int y11 = 0;
				while(y11 == 0){
					try{
						tempString = JOptionPane.showInputDialog(" Please enter the y-axes of the test point : ");
						if(tempString == null){
							return;
						}
						yTestP = Double.parseDouble(tempString);
						y11 = 1;
					}
					catch(Exception e){
						JOptionPane.showMessageDialog(null, "  y-axes must be a digit");
					}
				}
				
				//enter test rectangle
				JOptionPane.showMessageDialog(null, " Enter parameters of the test rectangle ");
				
				int x111 = 0;
				while(x111 == 0){
					try{
						tempString = JOptionPane.showInputDialog(" Please enter the x-axes of the test Rectangle : ");
						if(tempString == null){
							return;
						}
						r2.setX(Double.parseDouble(tempString));
						x111 = 1;
					}
					catch(Exception e){
						JOptionPane.showMessageDialog(null, " x-axes must be a digit ");
					}
				}
				
				int y111 = 0;
				while(y111 == 0){
					try{
						tempString = JOptionPane.showInputDialog(" Please enter the y-axes of the test Rectangle : ");
						if(tempString == null){
							return;
						}
						r2.setY(Double.parseDouble(tempString));
						y111 = 1;
					}
					catch(Exception e){
						JOptionPane.showMessageDialog(null, " y-axes must be a digit ");
					}
				}
				
				int width11 = 0;
				while(width11 == 0){
					try{
						tempString = JOptionPane.showInputDialog(" Please enter the width of the test Rectangle : ");
						if(tempString == null){
							return;
						}
						r2.setWidth(Double.parseDouble(tempString));
						width11 = 1;
					}
					catch(Exception e){
						JOptionPane.showMessageDialog(null, " width must be a positive digit ");
					}
				}
				
				int height11 = 0;
				while(height11 == 0){
					try{
						tempString = JOptionPane.showInputDialog(" Please enter the height of the test Rectangle : ");
						if(tempString == null){
							return;
						}
						r2.setHeight(Double.parseDouble(tempString));
						height11 = 1;
					}
					catch(Exception e){
						JOptionPane.showMessageDialog(null, " height must be a positive digit ");
					}
			}
				
				if(r1.contains(xTestP, yTestP)){
					JOptionPane.showMessageDialog(null, " the test point is inside this rectangle");
				}else JOptionPane.showMessageDialog(null, " the test point is not inside this rectangle");
				
				if(r1.contains(r2))
					JOptionPane.showMessageDialog(null, " the test rectangle is inside this rectangle");
				else if(r1.overlaps(r2))
					JOptionPane.showMessageDialog(null, " the test rectangle overlaps with this rectangle");
				else
					JOptionPane.showMessageDialog(null, " the test point is outside this rectangle");
				
				option = JOptionPane.showConfirmDialog(null, "do you need test anthoer point and rectangle? ");
						
		}
			option = JOptionPane.showConfirmDialog(null, "do you need enter a new first rectangle?");
	}
		
	}
}
