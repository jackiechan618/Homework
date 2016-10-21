//public class Trie {
//	private int SIZE = 27; // number 0~127 are used for Ascii Codes whose
//							// totall number are 128, and number 128 is reserved for letter '-'
//	private TrieNode root;
//
//	private class TrieNode {                 
//		private TrieNode[] children;    
//		private boolean isEnd;     
//		private char value;
//		
//		public TrieNode() {
//			children = new TrieNode[SIZE];
//			isEnd = false;
//		}
//	}
//
//	public Trie() { 
//		root = new TrieNode();
//	}
//
//	public void add(String str) {   
//		if (str == null || str.length() == 0) {
//			return;
//		}
//		TrieNode node = root;
//		char[] letters = str.toCharArray();
//		int pos = 0;
//		for (int i = 0, len = str.length(); i < len; i++) {
//			if(letters[i] == '-')
//				pos = 26;
//			else if(letters[i] >= 'A' && letters[i] <= 'Z'){
//				letters[i] += 32;
//				pos = letters[i] - 'a';
//			}
//			else
//				pos = letters[i] - 'a';
////			else
////				pos = letters[i] - '0';
//			if (node.children[pos] == null) {
//				node.children[pos] = new TrieNode();
//				node.children[pos].value = letters[i];
//			} 
//			node = node.children[pos];
//		}
//		node.isEnd = true;
//	}
//
//	public boolean contains(String str) {
//		if (str == null || str.length() == 0) {
//			return false;
//		}
//		TrieNode node = root;
//		char[] letters = str.toCharArray();
//		for (int i = 0, len = str.length(); i < len; i++) {
//			int pos = 0;
//			if(letters[i] == '-')
//				pos = 128;
//			else
//				pos = letters[i] - 'a';
//			if (node.children[pos] != null) {
//				node = node.children[pos];
//			} else {
//				return false;
//			}
//		}
//		return node.isEnd;
//	}
//	
//	public boolean containsPrefix(String str) {
//		if (str == null || str.length() == 0) {
//			return false;
//		}
//		TrieNode node = root;
//		char[] letters = str.toCharArray();
//		for (int i = 0, len = str.length(); i < len; i++) {
//			int pos = 0;
//			if(letters[i] == '-')
//				pos = 26;
//			else
//				pos = letters[i] - 'a';
//			if (node.children[pos] != null) {
//				node = node.children[pos];
//			} else {
//				return false;
//			}
//		}
//		return true;
//	}
//	
//	public void preTraverse(TrieNode node) {
//		if (node != null) {
//			System.out.print(node.value + "-");
//			for (TrieNode child : node.children) {
//				preTraverse(child);
//			}
//		}
//	}
//}
