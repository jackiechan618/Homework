import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;


public class HashMap_LineChaining {
	private LinkedList[] dataMap;     //using to re
	private int dataSize;
	private int probe_count;	
	private int[] histogramArray;
	private HashSet<Integer> numSet;  //using to get 1 million different integers
	private final int len = 1000000;
	
	public HashMap_LineChaining(){
		dataSize = (int) (len * 1.3);
		probe_count = 0;
		dataMap = new LinkedList[dataSize];
		for(int i = 0; i < dataSize; ++i)
			dataMap[i] = new LinkedList();
		histogramArray = new int[52];
	}
	
	public void add(int value){
		int pos = value % dataSize;
		probe_count = 0;
		probe_count = dataMap[pos].add(value, 0);
		histogramArray[probe_count]++;
	} 
	
	public void getDistinctNum(){  // generate one million different random numbers
		numSet = new HashSet<Integer>();
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
		System.out.printf("%7s", "Searchs");
		System.out.printf("%10s", "Numbers");
		System.out.println();
		System.out.printf("%7s", "=======");
		System.out.printf("%10s", "=======");
		System.out.println();
		
		for(int i = 1; i < 51; ++i){
			System.out.printf("%7s", i);
			System.out.printf("%10s", histogramArray[i]);
			System.out.println();
		}	
		
		System.out.printf("%7s", ">50");
		System.out.printf("%10s", histogramArray[51]);
	}
	
	public static void main(String[] args){
		HashMap_LineChaining myMap = new HashMap_LineChaining();
		myMap.getDistinctNum();
		myMap.displayHistogram();
	}
}


/******************************* class LinkedList and Node ****************************************                     
*  (1). Class LinkedList has used as a list to store the values which have got the same result    *   
*       from hash function and need to be stored at the same bin.                                 *
*  (2). Class Node has used as a data structure to store the value.                               *
**************************************************************************************************/

class LinkedList{
	private Node head;

	public LinkedList(){
		head = null;
	}
	
	public int add(int value, int probe_count){
		if(head == null){
			head = new Node(value);
			return probe_count+1;
		}
		else{
			Node temp = head;
			while(temp.next != null){
				temp = temp.next;
				probe_count++;
			}
			temp.next = new Node(value);
			return probe_count+1;
		}	
	}
	
	public Node getHead(){
		return head;
	}
	
//	public void showDataList(){
//		Node temp = head;
//		while(temp != null){
//			System.out.print(temp.value + ", ");
//			temp = temp.next;
//		}
//		System.out.println();
//	}	
}

class Node{
	int value;
	Node next;
	
	public Node(int v){
		value = v;
		next = null;
	}
}
