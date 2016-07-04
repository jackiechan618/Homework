
public class arrayList {
	private double[] x;
	private int size;
	private int used;
	
	public arrayList(){
		x = null;
		size = 0; 
		used = 0;
	}
	
	public void addFirst(int v){
		if(size == 0){
			x = new double[++size];
			x[used++] = v;
		}
		else if(size > 0 && used >= size){
			double[] temp = x;
			x = new double[size*2];
			x[0] = v;
			for(int i = 0; i < used; ++i)
				x[i+1] = temp[i];
			size *= 2;
			used++;
		}
		else{
			for(int i = used-1; i >= 0; --i)
				x[i+1] = x[i];
			x[0] = v;
			used++;
		}
	}
	
	public void printList(){
		for(int i = 0; i < used; ++i)
			System.out.print(x[i] + ", ");
		System.out.println();
	}
	
	public static void main(String[] args){
		arrayList test = new arrayList();
		for(int i = 0; i < 10; ++i)
			test.addFirst(i);
		test.printList();
	}
}
