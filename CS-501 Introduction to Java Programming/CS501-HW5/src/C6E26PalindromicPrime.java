/*******************************************
 * Name: Feng Chen
 * CWID: 10400586
 * 10th Edition, Chapter 6, Exercise 26
 * 
 *******************************************/

public class C6E26PalindromicPrime {
	public static int[] run(int n){
		boolean[] nonPrime = new boolean[n];
		double len = Math.sqrt(n);
		
		for(int i = 3; i < len; i += 2){
			for(int j = i * i; j < n; j += 2 * i){
				if(nonPrime[j] == false){
					nonPrime[j] = true;
				}
			}
		}
		
		int[] result = new int[100];
		result[0] = 2;
		int count = 1;
		
		for(int i = 3; i < n; i += 2){
			if(nonPrime[i] == false && isPalindromic(i) == true){
				result[count++] = i;
				if(count == 100){
					break;
				}
			}
		}
		
		return result;
	}
	
	public static boolean isPalindromic(int num){
		if(num < 10){
			return true;
		}
		
		String s = Integer.toString(num);
		int n = s.length();
		int left = 0, right = n - 1;
		
		while(left < right){
			if(s.charAt(left) != s.charAt(right)){
				return false;
			}
			left++;
			right--;
		}
		
		return true;
	}
	
	
	public static void main(String[] args){
		int[] printArray = C6E26PalindromicPrime.run(100000);		
		int column = 0;
		
		System.out.println("The first 100 palindromic prime numbers are:");
		
		for(int i = 0; i < printArray.length; ++i){
			System.out.print(printArray[i] + " ");
			column++;
			if(column == 10){
				column %= 10;
				System.out.println();
			}
		}
	}
}
