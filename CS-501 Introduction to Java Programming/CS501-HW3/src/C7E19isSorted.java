import javax.swing.JOptionPane;
/******************************************************************
 * Name: Feng Chen
 * CWID: 10400586
 * 10th Edition, Chapter 7 Exercise 19 
 ******************************************************************/

public class C7E19isSorted {
	public static void main(String[] args) {
		boolean bool = true;
		String[] numbersString = new String[10];
		int i = 0;		
		boolean flag = true;
		String zString = "";
		boolean test_flag = false;
		int testNum = 0;
		
		// ask guest enter numbers
		while (flag) {
			i = 0;
			test_flag = false;
			zString = JOptionPane.showInputDialog("Please input an integer which is the size of the array, for example: 10");
			bool = check(numbersString[i]);
			
			while(zString == null || zString.length() == 0){
				if(zString == null){
					return;
				}
				zString = JOptionPane.showInputDialog(null, "Error input , please enter a correct value again");
			}
			
			while(!test_flag){
				try {
					testNum = Integer.parseInt(zString);
					test_flag = true;
				} catch (Exception e1) {
					zString = JOptionPane.showInputDialog(null, "Error input , please enter a correct integer again");
					if(zString == null){
						return;
					}
				}
			}
			
			int[] inputArray = new int[testNum];
			int index = 0;
			JOptionPane.showMessageDialog(null, "Please enter " + testNum + " numbers one by one ");
			
			for(int k = 0; k < testNum; ++k){				
				zString = JOptionPane.showInputDialog("Please enter the next number of the array, for example: 1");
				bool = check(zString);
				while (bool == false) {
					zString = JOptionPane.showInputDialog("Error input , please enter a number again ");
					if(zString == null){
						return;
					}
					bool = check(zString);
				}				
				inputArray[index++] = Integer.parseInt(zString);
			}
			
			boolean sort_flag = true;
			StringBuffer sb = new StringBuffer();
			sb.append("Your input are: \n");
			
			for(int t = 0; t < inputArray.length - 1; ++t){
				sb.append(inputArray[t]).append(", ");
				if(inputArray[t] > inputArray[t + 1]){
					sort_flag = false;
				}
			}
			
			sb.append(inputArray[inputArray.length - 1]).append("\n");
					
			if(sort_flag == true){
				sb.append("The list is already sorted");
			} else {
				sb.append("The list is not sorted");
			}
			JOptionPane.showMessageDialog(null, sb.toString());

			// ask guest continue or exit
			int option = JOptionPane.showConfirmDialog(null, "Continue and begin a new test?");

			// if guest say exit then exit
			if (option != JOptionPane.YES_OPTION) {
				flag = false;
			}
		}
	}

	public static boolean check(String str) {
		try {
			Double.parseDouble(str);
		} catch (Exception e1) {
			return false;
		}
		return true;
	}
}
