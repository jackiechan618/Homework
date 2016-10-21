
public class powder {
	public long power(long x, int n){
		if(n == 0) return 1;
		long prod = 1;
		while(n > 0){
			if(n % 2 != 0){            //处理奇数
				prod = prod * x;
			}
			x = x * x;
			n = n / 2;
		}
		return prod;
	}
	
	public long powermod(long x, int n, int m){
		long prod = 1;
		while(n > 0){
			if(n % 2 != 0)
				prod = prod * x % m;
			x = x * x % m;
			n = n / 2;
		}
		return prod;
	}

	
	public static void main(String[] args){	
		powder t = new powder();
		System.out.println(t.power(5, 3));
		System.out.println(t.powermod(2, 36, 37));
		System.out.println(t.powermod(2, 6, 37));
	}
}
