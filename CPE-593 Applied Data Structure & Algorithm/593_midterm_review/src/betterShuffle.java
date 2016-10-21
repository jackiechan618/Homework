import java.util.Random;


public class betterShuffle {
	void bettershuffle(){
		int n = 52;
		int[] temp = new int[n];
		for(int i = 0; i < n; ++i)
			temp[i] = i;
				
		for(int i = 0; i < n; ++i){
			Random rand = new Random();
			int r = rand.nextInt(n);
			swap(temp, r, i);
		}
		for(int i = 0; i < n; ++i)
			System.out.print(temp[i] + ", ");
		System.out.println();
	}

	public void swap(int[] x, int a, int b){
		int temp = x[a];
		x[a] = x[b];
		x[b] = temp;
	}
	
	public static void main(String[] args){
		betterShuffle test = new betterShuffle();
		test.bettershuffle();
	}
	
}
