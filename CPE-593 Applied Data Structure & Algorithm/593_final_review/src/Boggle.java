import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;


public class Boggle {
	private char[][] boggle_dices;
	private boggleTrie myTrie;
	private Scanner input;
	private int lineNum = 0;
	private HashSet<String> mySet;
	
	private String dictionaryPath;
	private File dictionaryFile;
	private InputStreamReader dictionaryInputFileStream;
	private BufferedReader dictionaryFileReader;
	
	private String boggleDataPath;
	private File boggleDataFile;
	private InputStreamReader boggleDataInputFileStream;
	private BufferedReader boggleDataFileReader;	

	public Boggle (){
		myTrie = new boggleTrie();
		mySet = new HashSet<String>();
		input = new Scanner (System.in);
	}
	
	public void addToTrie(){
		System.out.println("Please input the path of dictionary to build a Trie: ");
		dictionaryPath = input.next();
		dictionaryFile = new File(dictionaryPath);   
		String readline = "";
		try {
			dictionaryInputFileStream = new InputStreamReader(new FileInputStream(dictionaryFile));
			dictionaryFileReader = new BufferedReader(dictionaryInputFileStream);			
			while( (readline = dictionaryFileReader.readLine()) != null ){
				myTrie.add(readline);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void readBoggleData(){
		System.out.println("Please input the path of the boggle data: ");
		boggleDataPath = input.next();
		boggleDataFile = new File(boggleDataPath);
		String readline = "";
		try {
			boggleDataInputFileStream = new InputStreamReader(new FileInputStream(boggleDataFile));			
			boggleDataFileReader = new BufferedReader(boggleDataInputFileStream);
			if( (readline = boggleDataFileReader.readLine()) != null )
				lineNum = Integer.parseInt(readline);
			boggle_dices = new char[lineNum][lineNum];
			for(int i = 0; i < lineNum; ++i){
				if( (readline = boggleDataFileReader.readLine()) != null ){
					String[] strArray = readline.split("\\s{1,}");
					for(int j = 0; j < strArray.length; ++j)
						boggle_dices[i][j] = strArray[j].charAt(0);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void backtrack(int posX, int posY, String word, boolean[][] boggle_dices_flag){
		if(posX < 0 || posX >= lineNum || posY < 0 || posY >= lineNum)
			return;		
		if(boggle_dices_flag[posX][posY] == true)
			return;
		
		boolean[][] temp_flag = new boolean[lineNum][lineNum];
		for(int i = 0; i < lineNum; ++i)
			for(int j = 0; j < lineNum; ++j)
				temp_flag[i][j] = boggle_dices_flag[i][j];
		
		word += boggle_dices[posX][posY];
		temp_flag[posX][posY] = true;
		
		if(word.length() > 2 && myTrie.contains(word)){
			if(!mySet.contains(word))
				mySet.add(word);
		}
		
		if(myTrie.containsPrefix(word) == true){
			backtrack(posX + 1, posY, word, temp_flag);
			backtrack(posX - 1, posY, word, temp_flag);
			backtrack(posX, posY + 1, word, temp_flag);
			backtrack(posX, posY - 1, word, temp_flag);	
			backtrack(posX + 1, posY + 1, word, temp_flag);
			backtrack(posX - 1, posY - 1, word, temp_flag);
			backtrack(posX + 1, posY - 1, word, temp_flag);
			backtrack(posX - 1, posY + 1, word, temp_flag);
		}
	}
	
	public int getLineNum(){
		return lineNum;
	}
	
	public void printWords(){
		System.out.println("Result is: ");
		for(String word : mySet){
			System.out.println(word + " ");
		}
	}
	
	public static void main(String[] args){
		Boggle t = new Boggle();
		String word = "";
		t.addToTrie();
		t.readBoggleData();
		int n = t.getLineNum();
		for(int i = 0; i < n; ++i){
			for(int j = 0; j < n; ++j){
				boolean[][] boggle_dices_flag = new boolean[n][n];
				t.backtrack(i, j, word, boggle_dices_flag);
			}
		}		
		t.printWords();
	}
			
// /Users/Jackie/Downloads/dictionary.txt
// /Users/Jackie/Downloads/boggle.dat
}


/************ class boggleTrie **************/

class boggleTrie {
	private int SIZE = 27;  
	private TrieNode root;

	private class TrieNode {                 
		private TrieNode[] children;    
		private boolean isEnd;     
		private char value;
		
		public TrieNode() {
			children = new TrieNode[SIZE];
			isEnd = false;
		}
	}

	public boggleTrie() { 
		root = new TrieNode();
	}

	public void add(String str) {   
		if (str == null || str.length() == 0) {
			return;
		}
		TrieNode node = root;
		char[] letters = str.toCharArray();
		int pos = 0;
		for (int i = 0, len = str.length(); i < len; i++) {
			if(letters[i] == '-')
				pos = 26;
			else if(letters[i] >= 'A' && letters[i] <= 'Z'){
				letters[i] += 32;
				pos = letters[i] - 'a';
			}
			else
				pos = letters[i] - 'a';
			if (node.children[pos] == null) {
				node.children[pos] = new TrieNode();
				node.children[pos].value = letters[i];
			} 
			node = node.children[pos];
		}
		node.isEnd = true;
	}

	public boolean contains(String str) {
		if (str == null || str.length() == 0) {
			return false;
		}
		TrieNode node = root;
		char[] letters = str.toCharArray();
		for (int i = 0, len = str.length(); i < len; i++) {
			int pos = 0;
			if(letters[i] == '-')
				pos = 128;
			else
				pos = letters[i] - 'a';
			if (node.children[pos] != null) {
				node = node.children[pos];
			} else {
				return false;
			}
		}
		return node.isEnd;
	}
	
	public boolean containsPrefix(String str) {
		if (str == null || str.length() == 0) {
			return false;
		}
		TrieNode node = root;
		char[] letters = str.toCharArray();
		for (int i = 0, len = str.length(); i < len; i++) {
			int pos = 0;
			if(letters[i] == '-')
				pos = 26;
			else
				pos = letters[i] - 'a';
			if (node.children[pos] != null) {
				node = node.children[pos];
			} else {
				return false;
			}
		}
		return true;
	}
	
	public void preTraverse(TrieNode node) {
		if (node != null) {
			System.out.print(node.value + "-");
			for (TrieNode child : node.children) {
				preTraverse(child);
			}
		}
	}
}

