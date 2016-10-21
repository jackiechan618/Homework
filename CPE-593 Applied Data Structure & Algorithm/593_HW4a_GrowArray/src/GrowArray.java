import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class GrowArray {
	private int[] p;
	private int used;
	private int size;
	
	public GrowArray(){
		p = new int[1];
		used = 0; 
		size = 1;
	}
	
	public void ADD_FRONT(int v){
		if(used >= size){
			int temp[] = p;
			p = new int[size * 2];
			for(int i = 0; i < size; i++){				
				p[i+1] = temp[i];
			}
			p[0] = v;
			used++;
			size *= 2;
		}
		else{
			for(int i = used - 1; i >= 0; i--){
				p[i + 1] = p[i]; 
			}
			p[0] = v;
			used++;
		}
	}
	
	public void ADD_BACK(int v){
		if(used >= size){
			int temp[] = p;
			p = new int[size * 2];
			for(int i = 0; i < size; i++){				
				p[i] = temp[i];
			}
			p[size] = v;
			used++;
			size *= 2;
		}
		else{
			p[used++] = v;
		}
	}
	
	public void REMOVE_FRONT(){
		if(used > 0){
			for(int i = 0; i < used - 1; i++)
				p[i] = p[i+1];
			used--;
		}
		else{
			System.out.println("GrowArray is empty");
		}
	}
	
	public void REMOVE_BACK(){
		if(used > 0){
			p[used-1] = 0;
			used--;
		}
		else{
			System.out.println("GrowArray is empty");
		}
	}
	
	public void OUTPUT(){
		for(int i = 0; i < used; i++)
			System.out.print(p[i] + " ");
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
				else continue;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		GrowArray test = new GrowArray();
		test.readFromText();		
	}	
}
