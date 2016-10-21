
public class Recursive_Fibonacci {
	
	public static int Fibonacci(int n){
		if(n <= 0) return 0;
		else if(n == 1) return 1;
		else return Fibonacci(n-1)+Fibonacci(n-2);
	}
	
	public static void main(String[] args) {
		System.out.println(Fibonacci(5));
		System.out.println(Fibonacci(10));
		System.out.println(Fibonacci(20));		
	}
}
