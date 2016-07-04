/*******************************************
 * Name: Feng Chen
 * CWID: 10400586
 * 10th Edition, Chapter 9, Exercise 5
 * 
 *******************************************/

import javax.swing.JOptionPane;
import java.util.GregorianCalendar;


public class C9E5_TestGregorianCalendar {
	public static void main(String[] args){
		GregorianCalendar calendarCurrent = new GregorianCalendar();
		
		JOptionPane.showMessageDialog(null,"The current year is : " + calendarCurrent.get(GregorianCalendar.YEAR)
									  + "\n " + "The current month is : month " + (calendarCurrent.get(GregorianCalendar.MONTH) + 1)
										  + "\n " + "The current day is : " + calendarCurrent.get(GregorianCalendar.DAY_OF_MONTH)
										  + "\n ");
		
	
		calendarCurrent.setTimeInMillis(123456788765L);
		
		JOptionPane.showMessageDialog(null,"The year of SET TIME (123456788765L) is : " + calendarCurrent.get(GregorianCalendar.YEAR)
				  + "\n " + "The month of SET TIME (123456788765L) is : " + (calendarCurrent.get(GregorianCalendar.MONTH) + 1)
					  + "\n " + "The day of SET TIME (123456788765L) is : " + calendarCurrent.get(GregorianCalendar.DAY_OF_MONTH)
					  + "\n ");
		
		return;
	}	
}