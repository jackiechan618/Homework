import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;


public class Sorting {	
	private String[] getFromFile;
	private static Scanner input;
	private int numForSort;
	private String filePath;
	private LinkedList<String[]> allNum;
	private LinkedList<Integer> arrayForSort;
	private int[] sortArray;
	
	public Sorting(){
		allNum = new LinkedList<String[]>();
		arrayForSort = new LinkedList<Integer>();
		input = new Scanner (System.in);
		System.out.println("please enter the path of input file: ");
		String filePath = input.next();    
 
		if(readTxtFile(filePath) < 0){
			System.out.println("try it again");
			return;
		}
		quickSort(sortArray, 0, numForSort-1);
		
		System.out.println();
		System.out.print("After quciksorting: ");
		for(int i = 0; i < sortArray.length; i++){
			System.out.print(sortArray[i] + ", ");
		}
	}
	
	public static void main(String[] args){
		Sorting mySort = new Sorting();
	}
	
	
	public int partition(int[] p, int x, int y) {
		int i = x - 1;
		int temp;
		int pivot = p[y];
		for (int j = x; j < y; j++) {
			if (p[j] <= pivot) {
				i++;
				temp = p[i];
				p[i] = p[j];
				p[j] = temp;
			}
		}
		temp = p[i + 1];
		p[i + 1] = p[y];
		p[y] = temp;
		return i + 1;
	}

	int randomized_partition(int[] p, int x, int y) {
		int n = y - x + 1;
		int temp;
		int gap = new Random().nextInt(n); 
		temp = p[y];
		p[y] = p[x + gap];
		p[x + gap] = temp;
		return partition(p, x, y);
	}

	public void quickSort(int[] p, int x, int y) {
		if (x < y) {
			int r = randomized_partition(p, x, y); 													
			quickSort(p, x, r - 1);
			quickSort(p, r + 1, y);
		}
	}
	
	public int readTxtFile(String filePath) {
		try {
			String encoding = "UTF-8";
			File file = new File(filePath);
			if (file.isFile() && file.exists()) { 
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				
				getFromFile = bufferedReader.readLine().toString().split("\\s{1,}");
				numForSort = Integer.parseInt(getFromFile[0]);
				if(numForSort < 0){
					System.out.println("sorting number error!");
					return -1;
				}
				
				while ((lineTxt = bufferedReader.readLine()) != null) 
						allNum.add(lineTxt.split("\\s{1,}"));
				
				for(int i = 0; i < allNum.size(); i++){
					for(int j = 0; j < allNum.get(i).length; j++){
						arrayForSort.add(Integer.parseInt(allNum.get(i)[j]));
					}
				}					
				read.close();
				
				if(arrayForSort.size() < numForSort){
					System.out.println("sorting number is larger than the actual");
					return -1;
				}
				
			} else {
				System.out.println("Cannot find the file");
				return -1;
			}
		} catch (Exception e) {
			System.out.println("Reading file error");
			e.printStackTrace();
			return -1;
		}
		
		sortArray = new int[arrayForSort.size()];
		System.out.print("Before quickSorting: ");
		for(int i = 0; i < arrayForSort.size(); i++){
			sortArray[i] = arrayForSort.get(i);
			System.out.print(sortArray[i] + ", ");
		}
		return 0;
	}
	
}	
