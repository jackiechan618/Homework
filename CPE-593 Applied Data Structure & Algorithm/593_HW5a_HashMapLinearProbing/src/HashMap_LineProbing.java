import java.util.HashSet;
import java.util.Random;
import java.util.Iterator;


public class HashMap_LineProbing {
	private int[] dataMap;
	private int dataSize;
	private int used;
	private int[] histogramArray;
	private HashSet<Integer> numSet;  //using to get 1 million different integers  
	private final int len = 1000000;  
	
	public HashMap_LineProbing(){
		dataSize = len * 2;
		used = 0;
		dataMap = new int[dataSize];
		for(int i = 0; i < dataSize; ++i)
			dataMap[i] = Integer.MIN_VALUE;  //initial as MIN_VALUE
		histogramArray = new int[52];
	}
	
	public void add(int value){
		if(used >= dataSize){
			grow();
		}
		int pos = lineProbing(value);
		dataMap[pos] = value;
		used++;
	} 
	
	public void grow(){
		int[] temp = dataMap;	
		int newLength = dataSize * 2;
		dataMap = new int[newLength];
		
		for(int i = 0; i < newLength; ++i)   //initial as MIN_VALUE
			dataMap[i] = Integer.MIN_VALUE;
		
		for(int i = 0; i < dataSize; ++i){   
			int tempValue =  dataMap[i];
			int pos = tempValue % newLength;
			while(dataMap[pos] != Integer.MIN_VALUE && dataMap[i] != dataMap[pos]){
				pos = (++pos) % newLength;
			}
			dataMap[pos] = tempValue;			
		}
		dataSize = newLength;
	}
	
	public int lineProbing(int value){
		int pos = value % dataSize;
		int probe_Count = 1;
		while(dataMap[pos] != Integer.MIN_VALUE && value != dataMap[pos]){
			pos = (++pos) % dataSize;
			probe_Count++;
		}
		if(probe_Count < 51)
			histogramArray[probe_Count]++;
		else
			histogramArray[51]++;
		return pos;
	}
	
	public void getDistinctNum(){          // generate one million different random numbers
		numSet = new HashSet<Integer>();   // and add them to the hashtable
		Random r = new Random();
		while (numSet.size() < len) {
			numSet.add(r.nextInt(1000000000)); 
		}
		
		Iterator<Integer> iterator = numSet.iterator(); 
	    while (iterator.hasNext()){
	    	add(iterator.next());
	    }
	}
	
	public void displayHistogram(){
		histogramArray[0] = dataSize - used;
		System.out.printf("%7s", "Searchs");
		System.out.printf("%10s", "Numbers");
		System.out.println();
		System.out.printf("%7s", "=======");
		System.out.printf("%10s", "=======");
		System.out.println();
		
		System.out.printf("%7s", "0");
		System.out.printf("%10s", histogramArray[0]);
		System.out.println();
		
		for(int i = 1; i < 51; ++i){
			System.out.printf("%7s", i);
			System.out.printf("%10s", histogramArray[i]);
			System.out.println();
		}	
		
		System.out.printf("%7s", ">50");
		System.out.printf("%10s", histogramArray[51]);
	}
		
//	public void showDataMap(){
//		for(int i = 0; i < dataSize; ++i){
//			if(dataMap[i] != 0)
//				System.out.print(dataMap[i] + ", ");
//		}
//		System.out.println();
//	}

	
	public static void main(String[] args){
		HashMap_LineProbing myMap = new HashMap_LineProbing();
		myMap.getDistinctNum();
		myMap.displayHistogram();

//		System.out.println("before:");
//		for(int i = 0; i < array.length; ++i)
//			System.out.print(array[i] + ", ");
//		System.out.println();
//		System.out.println("after:");
//		myMap.showDataMap();
//		System.out.println();
	}
}
