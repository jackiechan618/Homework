import java.text.SimpleDateFormat;
import java.util.*;

public class sieve {
		public static int SieveOfEratosthenes(long last, int sqrt_last, int[] primeArry){
		    boolean[] arr = new boolean [sqrt_last];
		    int count = 0;
		    for(int i = 0; i < sqrt_last; i++)
		    	arr[i] = false;
		    for(int i = 1; i < sqrt_last; i++){
		        if (arr[i] == false){
		            primeArry[count] = i + 1;
		            count++;
		            for(int j = 3, num = (i+1)*j; num <= sqrt_last; j += 2){
		                arr[num - 1] = true;
		                num = (i+1)*j;
		            }
		        }
		    }		    
		    return count-1;
		}
		
		public static boolean isPrime(long n, int[] primeArry, int count){
		    if (n == 1) return false;
		    if (n == 2 || n == 3) return true;
		    if ((n % 6 != 1) && (n % 6 != 5)) return false;
		    for (int j = 0; primeArry[j] <= Math.sqrt(n) && j <= count; j++){
		        if (n != primeArry[j] && n % primeArry[j] == 0) return false;
		    }
		    return true;
		}
		
	    public static void main(String[] args) {
	    	long start_num = 0;
	        long last_num = 0;
	        double sqrt_lastNum_double = 0;
	        int sqrt_lastNum = 0;
	        
	        System.out.println("Please input the start number:");
	        Scanner input = new Scanner(System.in);
	        start_num = input.nextLong();
		    System.out.println("Please input the last number:");
		    last_num = input.nextLong();
		    System.out.println("Start time is: " + new SimpleDateFormat("HH:mm:ss:SSS") .format(new Date() ) + " ms"); 
		    sqrt_lastNum_double = Math.sqrt(last_num);
		    sqrt_lastNum = (int)sqrt_lastNum_double + 1;
		    
		    int[] primeArry = new int[sqrt_lastNum];
	        int count = 0;	        
	        long prime_count = 0;
		    
	        count = SieveOfEratosthenes(last_num, sqrt_lastNum, primeArry);
	        	        
		    for (long n2 = start_num; n2 <= last_num; n2++){
	            if(isPrime(n2, primeArry, count))
	                prime_count++;
	        }
	        System.out.println("Number of primes: " + prime_count);
	        System.out.println("End time is: " + new SimpleDateFormat("HH:mm:ss:SSS") .format(new Date() ) + " ms"); 
	    } 

}