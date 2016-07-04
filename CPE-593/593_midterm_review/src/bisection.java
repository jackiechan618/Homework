
public class bisection {
	public double bisectionFunc(double a, double b, double eps){
		if (func(a) * func(b) > 0) {
			System.out.println("not root");
			return -1;
		}
		if (func(a) > 0 && func(b) < 0)
			swap(a,b);
		double guess, t = (a+b)/2;
		int count = 0;
		while (t > eps){
			count++;
			guess = (a + b) / 2;
	        double y = func(guess);
	        if (y > 0) 
	            b = guess;
	        else if (y < 0) 
	            a = guess;
	        t = (b-a >= 0) ? b-a : a-b;
	        System.out.println("t = " + t);
		}	
		System.out.println("count = " + count);
		return (a+b)/2;
	}
	
	public double func(double x){
		return 3*x*x-2;
	}
	
	public void swap(double x, double y){
		double temp = x;
		x = y;
		y = temp;
	}

	public static void main(String[] args){
		double eps = 0.00001;
		bisection test = new bisection();
//		for (int i = 1; i <= 15; i++, eps *= 0.1){
			System.out.printf("%.15f", eps);
			System.out.println();
			System.out.println(", " + test.bisectionFunc(0,  3, eps));
//		}
	}
}
