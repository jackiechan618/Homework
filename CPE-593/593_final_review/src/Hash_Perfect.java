public class Hash_Perfect {
	private innerHash[] myInnerHash;
	private boolean[] flag;
	private int dataSize;
	private final int len = 5;  
	
	public Hash_Perfect(){
		dataSize = len * 2;
		myInnerHash = new innerHash[dataSize];
		flag = new boolean[dataSize];
		
		for(int i = 0; i < dataSize; ++i)
			myInnerHash[i] = null;
	}
	
	public void add(int v){
		int pos = v % dataSize;
		if(flag[pos] == false){
			flag[pos] = true;
			myInnerHash[pos] = new innerHash();
		}
		myInnerHash[pos].add(v);
	}
	
	public void print(){
		for(int i = 0; i < dataSize; ++i){
			if(flag[i] == true)
				myInnerHash[i].print();
		}
	}
	
	public static void main(String[] args){
		Hash_Perfect h = new Hash_Perfect();
		int[] array = {1,2,5,3,7,8,2,34,76,4,33,11,21,12,35};
//		int[] array = {15, 11, 5};
		for(int i = 0; i < array.length; ++i)
			h.add(array[i]);
		h.print();	
	}
}

class innerHash{
	private int[] dataSet;
	private int dataSize;
	
	public innerHash(){
		dataSize = 5;
		dataSet = new int[dataSize];
		for(int i = 0; i < dataSize; ++i)
			dataSet[i] = Integer.MIN_VALUE;
	}
	
	public void add(int v){
		int pos = v % dataSize;
		while(dataSet[pos] != Integer.MIN_VALUE && v != dataSet[pos]){
			grow();
			pos = v % dataSize;
		}
		dataSet[pos] = v;
	}
	
	public void grow(){
		int[] temp = dataSet;
		dataSize *= 2;
		dataSet = new int[dataSize];
		
		for(int i = 0; i < dataSize; ++i)
			dataSet[i] = Integer.MIN_VALUE;
		
		for(int j = 0; j < temp.length; ++j){
			if(temp[j] != Integer.MIN_VALUE)
				add(temp[j]);
		}
	}
	
	public void print(){
		for(int i = 0; i < dataSize; ++i)
			if(dataSet[i] != Integer.MIN_VALUE)
				System.out.print(dataSet[i] + ", ");
		System.out.println("innerHash's size = " + dataSize);
	}
}
