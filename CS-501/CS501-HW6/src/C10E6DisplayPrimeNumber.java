/*******************************************
 * Name: Feng Chen
 * CWID: 10400586
 * 10th Edition, Chapter 10, Exercise 6
 * 
 * test class
 * 
 *******************************************/
import javax.swing.JOptionPane;

public class C10E6DisplayPrimeNumber {
	public static void main(String args[]) {
		C10E6StackOfIntegers stack = new C10E6StackOfIntegers();
		boolean[] nonPrime = new boolean[120];
		double bound = Math.sqrt(121);
		
		for(int i = 3; i <= bound; i += 2){
			for(int j = i * i; j < 120; j += 2 * i){
				nonPrime[j] = true;
			}
		}
		
		stack.push(2);		
		for(int i = 3; i < 120; i += 2){
			if(nonPrime[i] != true){
				stack.push(i);
			}
		}
		
		StringBuffer builder = new StringBuffer();
		while(!stack.empty()){
			builder.append(stack.pop()).append(",");
		}
		String ans = builder.substring(0, builder.length() - 1);
		JOptionPane.showMessageDialog(null, "the primes less than 120 are : " + ans);
	}

}
