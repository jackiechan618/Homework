import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Build_A_List {
	private String caseFilePath;
	private File caseFile;
	private InputStreamReader inputFileStream;
	private BufferedReader fileReader;
	private String[] readLineArray;
	private Scanner input;
	private int startPos;
	private int endPos;
	private int moveNum;
	private long startTime;
	private long endTime;
	
	public Build_A_List(){	
		System.out.println("please enter the path of input file: ");
		input = new Scanner (System.in);
		caseFilePath = input.next();
		caseFile = new File(caseFilePath);   // /Users/Jackie/Downloads/testcase.txt
		String readline = "";
		try {
			inputFileStream = new InputStreamReader(new FileInputStream(caseFile));
			fileReader = new BufferedReader(inputFileStream);
			int readCount = 1;
			int[] moveNumArray;
			
			while( (readline = fileReader.readLine()) != null ){
				readLineArray = readline.split("\\s{1,}");
				if(readCount % 2 != 0){
					startPos = Integer.parseInt(readLineArray[0]);
					endPos = Integer.parseInt(readLineArray[1]);
					moveNum = Integer.parseInt(readLineArray[2]);
				}
				else{
					moveNum = Integer.min(moveNum, readLineArray.length);
					moveNumArray = new int[moveNum];
					for(int i = 0; i < moveNum; ++i){
						moveNumArray[i] = Integer.parseInt(readLineArray[i]);
					}
					getList(moveNumArray);
				}
				readCount++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void getList(int[] moveArray){
		int [] wholeArray = new int [endPos+1];
		int moveCount = moveArray.length;
		int count = 0;
		long sum = 0;
		
		for(int i = 0; i < moveCount; ++i) {
			for(int j = moveArray[i]; j <= endPos; j += moveArray[i]){
				if(wholeArray[j] == 1)
					continue;
				else
					wholeArray[j] = 1;
			}
		}
		
		startTime = System.currentTimeMillis();
		
		for(int i = startPos; i <= endPos; ++i){
			if(wholeArray[i] == 0){
				count++;
				sum += i;
			}
		}			
		endTime = System.currentTimeMillis();
		System.out.println(count + "  " + sum + "  " + (endTime - startTime) + "ms");
	}
	
	public static void main(String[] args){
		Build_A_List t = new Build_A_List();
	}
}
