/*******************************************
 * Name: Feng Chen
 * CWID: 10400586
 * 10th Edition, Chapter 10, Exercise 6
 * 
 * StackOfIntegers class
 * 
 *******************************************/

public class C10E6StackOfIntegers {
	private int[] elements;
	private int size;
	public static final int DEFAULT_CAPACITY = 16;
	
	public C10E6StackOfIntegers(){
		this(DEFAULT_CAPACITY);
	}
	
	public C10E6StackOfIntegers(int capacity){
		elements = new int[capacity];
	}
	
	public void push(int value){
		if(size >= elements.length){
			int[] temp = new int[elements.length * 2];
			for(int i = 0; i < size; ++i){
				temp[i] = elements[i];
			}
			elements = temp;
		}
		elements[size++] = value;
	}
	
	public int pop(){
		return elements[--size];
	}
	
	public int peek(){
		return elements[size - 1];
	}
	
	public boolean empty(){
		return size == 0;
	}
	
	public int getSize(){
		return size;
	}

}

