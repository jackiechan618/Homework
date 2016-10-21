import javax.swing.JOptionPane;
/******************************************************************
 * Name: Feng Chen
 * CWID: 10400586
 * 10th Edition, Chapter 5 Exercise 16, Chapter 6 Exercise 10 
 ******************************************************************/

public class C5E16C6E10Prime {	  
	private int[] primeArray;
	
	public C5E16C6E10Prime(){
		primeArray = new int[1000];
	}
	
	/********************************* Chapter 5 Exercise 16 *********************************/
	public void C5E16FindFactors(){
		String zString = "";
		boolean flag = true;
		boolean test_flag = false;
		int testNum = 0;

			while (flag) {
				test_flag = false;
				zString = JOptionPane.showInputDialog("Please enter a Integer less than 1000 to find its factors, for example: 120");
				
				while(zString == null || zString.length() == 0){
					if(zString == null){
						return;
					}
					zString = JOptionPane.showInputDialog(null, "Error input , please enter a correct value again");
				}
				
				while(!test_flag){
					try {
						testNum = Integer.parseInt(zString);
						if(testNum >= 1000){
							zString = JOptionPane.showInputDialog(null, "Error input , please enter a integer less than 1000 again");
							if(zString == null){
								return;
							}
						} else {
							test_flag = true;
						}
					} catch (Exception e1) {
						zString = JOptionPane.showInputDialog(null, "Error input , please enter a correct integer again");
						if(zString == null){
							return;
						}
					}
				}
				
				if(search(primeArray, testNum) == true){
					String str = "Your input is " + testNum + ", this is a prime";
					JOptionPane.showMessageDialog(null , str);
				} else {
					int j = 2;
					StringBuffer sb = new StringBuffer();
					sb.append("Your input is " + testNum + ", this is not a prime \n").append("Its factors are: \n");
					while (j <= testNum) {
						if(testNum % j == 0) {
							sb.append(j).append(", ");
							testNum = testNum / j;
						}
						else {
							j++;
						}
					}
					JOptionPane.showMessageDialog(null , sb.toString());
				}							
				
				// ask guest continue or exit
				int option = JOptionPane.showConfirmDialog(null, "Continue and begin a new test?");

				// if guest say exit then exit
				if (option != JOptionPane.YES_OPTION){
					break;
				}
			}
	}
	
	public boolean search(int[] primeArray, int target){
		if(target < primeArray[0] || target > primeArray[primeArray.length - 1]){
			return false;
		}
		int left = 0, right = primeArray.length - 1;
		while(left + 1 < right){
			int mid = left + (right - left) / 2;
			if(target > primeArray[mid]){
				left = mid;
			} else if(target < primeArray[mid]){
				right = mid;
			} else {
				return true;
			}
		}
		
		if(primeArray[left] == target || primeArray[right] == target){
			return true;
		} else {
			return false;
		}
	}
	
	
	/********************************* Chapter 6 Exercise 10 *********************************/
	public void C6E10DisplayPrimes(){
		StringBuffer sb = new StringBuffer();
		int index = 0;
		
		for (int i = 2; i < 10000; i++) {
			if(isPrime(i)){
				if(index <= 999){
					primeArray[index] = i;
					if(index <= 49){                //print out the first 50 prime number
						sb.append(i).append(", ");
						if(index % 10 == 9){
							sb.append("\n");
						}
					}
				}
				index++;
			}
		}
		
		String str = "The number of prime numbers less than 10000 is " + index + "\n" + "The first 50 prime numbers are: \n" + sb.toString();
		JOptionPane.showMessageDialog(null , str);
	}
	
	public static boolean isPrime(int number){
		for(int divisor = 2; divisor <= number/2; divisor++){
			if(number % divisor == 0){
				return false;
			}
		}
		return true;
	}
	
	
	
	/*********************** Main method **************************/
	public static void main(String[] args) {	
		C5E16C6E10Prime t = new C5E16C6E10Prime();
		t.C6E10DisplayPrimes();	
		t.C5E16FindFactors();
	}
}

