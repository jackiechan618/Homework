import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;


public class computingPrime {	
	public static void SieveOfEratosthenes(int n1, int count, int[] primeArry){
	    boolean[] arr = new boolean [1000000];
	    for(int i = 0; i < 1000000; i++)
	    	arr[i] = false;
	    for(int i = 1; i < 1000000; i++){
	        if (arr[i] == false){
	            primeArry[count] = i + 1;
	            count++;
	            for(int j = 2, num = (i+1)*j; num <= n1; j++){
	                arr[num - 1] = true;
	                num = (i+1)*j;
	            }
	        }
	    }
	}
	
	public static boolean isPrime(long n, int[] primeArry){
	    if (n == 1) return false;
	    if (n == 2 || n == 3) return true;
	    if ((n % 6 != 1) && (n % 6 != 5)) return false;
	    for (int j = 0; primeArry[j] <= Math.sqrt(n) && j <= 78497; j++){
	        if (n%primeArry[j] == 0) return false;
	    }
	    for (long i = 999983; i <= Math.sqrt(n); i += 2){
	        if (n%i == 0) return false;
	    }
	    return true;
	}
	
    public static void main(String[] args) {
    	int[] primeArry = new int[100000];
        int count = 0;
        long start_num = 0;
        long last_num = 0;
        int n1 = 1000000;
        int prime_count = 0;
        
        SieveOfEratosthenes(n1, count, primeArry);
        System.out.println("Please input the start number:");
        Scanner input = new Scanner(System.in);
        start_num = input.nextLong();
	    System.out.println("Please input the last number:");
	    last_num = input.nextLong();
	    System.out.println("Start time is: " + new SimpleDateFormat("HH:mm:ss:SSS") .format(new Date() ) + " ms"); 
        for (long n2 = start_num; n2 <= last_num; n2++){
            if(isPrime(n2, primeArry))
                prime_count++;
        }
        System.out.println("Number of primes: " + prime_count);
        System.out.println("End time is: " + new SimpleDateFormat("HH:mm:ss:SSS") .format(new Date() ) + " ms"); 
    } 
}