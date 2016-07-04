import javax.swing.JOptionPane;
/******************************************************************
 * Name: Feng Chen
 * CWID: 10400586
 * 10th Edition, Chapter 7 Exercise 9, Chapter 7 Exercise 10 
 ******************************************************************/

public class C7E9C7E10SmallestElement {	
	public static void main(String[] args) {
		// define values
		boolean bool = true;
		double[] numbers = new double[10];
		String[] numbersString = new String[10];
		int i = 0;
		int minNumbersIndex = 0;
		double minNumber = 0;
		boolean flag = true;

		// ask guest enter numbers
		while (flag) {
			i = 0;
			JOptionPane.showMessageDialog(null, "Please enter ten numbers one by one ");
			numbersString[i] = JOptionPane.showInputDialog("Please input the first number");
			bool = check(numbersString[i]);
			while (bool == false) {
				numbersString[i] = JOptionPane.showInputDialog("Error input , please enter a number again ");
				if(numbersString[i] == null){
					return;
				}
				bool = check(numbersString[i]);
			}

			numbers[i] = Double.parseDouble(numbersString[i]);
			i++;
			for (; i <= 9; i++) {
				numbersString[i] = JOptionPane.showInputDialog("Please enter the next number");
				bool = check(numbersString[i]);
				while (bool == false) {
					numbersString[i] = JOptionPane.showInputDialog("Error input , please enter a number again ");
					if(numbersString[i] == null){
						return;
					}
					bool = check(numbersString[i]);
				}
				numbers[i] = Double.parseDouble(numbersString[i]);
			}

			// display
			minNumbersIndex = indexOfSmallestElement(numbers);
			minNumber = min(numbers);
			StringBuffer sb = new StringBuffer();
			
			sb.append("Your input are: ");
			for(int k = 0; k < 9; ++k){
				sb.append(numbers[k]).append(", ");
			}
			sb.append(numbers[9]).append("\n").append("The smallest element is  ").append(minNumber).append(". \n The index of smallest element is ").append(minNumbersIndex);
			
			JOptionPane.showMessageDialog(null, sb.toString());
			
			// ask guest continue or exit
			int option = JOptionPane.showConfirmDialog(null, "Continue and begin a new test?");

			// if guest say exit then exit
			if (option != JOptionPane.YES_OPTION){
				flag = false;
			}
		}
	}

	/********************************* Chapter 7 Exercise 9 *********************************/
	// get the smallest number
	public static double min(double[] array){
		double min = array[0];

		for (int i = 1; i < array.length; i++)
			if (min > array[i]) {
				min = array[i];
			}
		return min;
	}
	
	/********************************* Chapter 7 Exercise 10 *********************************/
	// get the index of the smallest number
	public static int indexOfSmallestElement(double[] array) {
		double min = array[0];
		int minIndex = 0;

		for (int i = 1; i < array.length; i++)
			if (min > array[i]) {
				min = array[i];
				minIndex = i;
			}
		return minIndex;
	}

	// Check the input is a number
	public static boolean check(String str) {
		try {
			Double.parseDouble(str);
		} catch (Exception e1) {
			return false;
		}
		return true;
	}
}
