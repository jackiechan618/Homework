import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Search {
	private String caseFilePath;
	private File caseFile;
	private InputStreamReader inputFileStream;
	private BufferedReader fileReader;
	private String[] readLineArray;
	private Scanner input;
	private int caseNum;
	
	public Search(){	
		System.out.println("please enter the path of input file: ");
		input = new Scanner (System.in);
		caseFilePath = input.next();
		caseFile = new File(caseFilePath);
		readLineArray = new String[3];
		String readline = "";
		try {
			inputFileStream = new InputStreamReader(new FileInputStream(caseFile));
			fileReader = new BufferedReader(inputFileStream);
			if( (readline = fileReader.readLine()) != null )
				caseNum = Integer.parseInt(readline.split("\\s{1,}")[1]);
			else{
				System.out.println("Nothing in the file, please try another file!");
				return;
			}
			for(int i = 0; i < caseNum; i++){
				for(int j = 0; j < 3; j++){
					if( (readLineArray[j] = fileReader.readLine()) == null ){
						System.out.println("Read error in case " + (i+1) + ": Read implete data, please try again!");
						return;
					}
				}
				binarySearch();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void binarySearch(){
		int integerNum = Integer.parseInt(readLineArray[0]);
		int target = Integer.parseInt(readLineArray[2]);
		String[] tempStr = readLineArray[1].split("\\s{1,}");
		int[] integerList = new int[integerNum];
		int iteration_time = 0;
		int frontPos = 0, backPos = integerNum - 1, guess = 0;
		
		for(int i = 0; i < integerNum; i++)
			integerList[i] = Integer.parseInt(tempStr[i]);
		
		while(frontPos <= backPos){
			iteration_time++;
			guess = (frontPos + backPos + 1) / 2;
			if(integerList[guess] > target) backPos = guess - 1;
			else if(integerList[guess] < target) frontPos = guess + 1;
			else {
				System.out.println(target + " " + iteration_time); 
				return;
			}			
		}
		System.out.println("NOT FOUND " + iteration_time);
	}
	
	public static void main(String[] args){
		Search s = new Search();
	}	
}
