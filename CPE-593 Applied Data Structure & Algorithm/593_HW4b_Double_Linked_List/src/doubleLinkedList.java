import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class doubleLinkedList {
	private Node head;
	private Node tail;
	
	public doubleLinkedList(){
		head = null;
		tail = null;
	}
	
	public void ADD_FRONT(int v) {
		if(head == null){
			head = new Node(v);
			tail = head;
			head.next = null;
			head.front = null;
			tail.next = null;
			tail.front = null;
		}
		else{
			Node temp = new Node(v);
			temp.next = head;
			head.front = temp;
			head = temp;
		}
	}
	
	public void ADD_BACK(int v) {
		if(head == null){
			head = new Node(v);
			tail = head;
			head.next = null;
			head.front = null;
			tail.next = null;
			tail.front = null;
		}
		else{
			Node temp = new Node(v);
			temp.next = tail.next;
			temp.front = tail;
			tail.next = temp;
			tail = tail.next;
		}
	}
	
	public void REMOVE_FRONT(){
		if(head == null){
			System.out.println("Cannot remove from front because linkedlist is empty");
		}
		else if(head == tail){
			head = tail = null;
		}
		else{
			head = head.next;
			head.front = null;
		}
	}
	
	public void REMOVE_BACK(){
		if(tail == null){
			System.out.println("Cannot remove from back because linkedlist is empty");
		}
		else if(head == tail){
			head = tail = null;
		}
		else{
			Node p = head;
			while(p.next != tail){
				p = p.next;
			}
			p.next = tail.next;
			tail = p;
		}
	}
	
	public void OUTPUT(){
		if(head == null){
			System.out.println("Output is null because linkedlist is empty");
			return;
		}
		Node p = head;
		while(p != null){
			System.out.print(p.val + ", ");
			p = p.next;
		}
		System.out.println();
	}
	
	public void OUTPUTFROMTAIL(){
		if(head == null){
			System.out.println("OutputFromTail is null because linkedlist is empty");
			return;
		}
		Node p = tail;
		while(p != null){
			System.out.print(p.val + ", ");
			p = p.front;
		}
		System.out.println();
	}
	
	public void readFromText(){
		InputStreamReader inputFileStream;
		BufferedReader fileReader;
		String[] readLineArray;
		System.out.println("please enter the path of input file: ");
		Scanner input = new Scanner (System.in);
		String caseFilePath = input.next();
		File caseFile = new File(caseFilePath);
		String readline = "";
		try {
			inputFileStream = new InputStreamReader(new FileInputStream(caseFile));
			fileReader = new BufferedReader(inputFileStream);
			while( (readline = fileReader.readLine()) != null ){
				readLineArray = readline.split("\\s{1,}");
				if( readLineArray[0].equals("ADD_FRONT") ){
					for(int i = readLineArray.length-1; i > 0; i--)
						ADD_FRONT(Integer.parseInt(readLineArray[i]));
				} 
				else if( readLineArray[0].equals("ADD_BACK") ){
					for(int i = 1; i < readLineArray.length; i++)
						ADD_BACK(Integer.parseInt(readLineArray[i]));
				} 
				else if( readLineArray[0].equals("REMOVE_FRONT") ){
					int count = Integer.parseInt(readLineArray[1]);
					for(int i = 0; i < count; i++)
						REMOVE_FRONT();
				}
				else if( readLineArray[0].equals("REMOVE_BACK") ){
					int count = Integer.parseInt(readLineArray[1]);
					for(int i = 0; i < count; i++)
						REMOVE_BACK();
				}
				else if( readLineArray[0].equals("OUTPUT") ){
					OUTPUT();
				}
				else if( readLineArray[0].equals("OUTPUTFROMTAIL") ){
					OUTPUTFROMTAIL();
				}
				else continue;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args){		
		doubleLinkedList test = new doubleLinkedList();
		test.readFromText();
	}
}

class Node {
	int val;
	Node front;
	Node next;	

	Node(int val){
		this.val = val;
		front = null;
		next = null;
	}
}

