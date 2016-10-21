public class Trie {
	private int SIZE = 26; // number 0~127 are used for Ascii Codes whose
							// totall number are 128, and number 128 is reserved for letter '-'
	public TrieNode root;

	private class TrieNode {                 
		private TrieNode[] children;    
		private boolean isEnd;     
		private char value;
		private int include_num;
		
		public TrieNode() {
			children = new TrieNode[SIZE];
			isEnd = false;
			include_num = 1;
			for(int i = 0; i < SIZE; ++i)
				children[i] = null;
		}
	}

	public Trie() { 
		root = new TrieNode();
	}

	public void Insert(String str) {   
		if (str == null || str.length() == 0) {
			return;
		}
		TrieNode node = root;
		char[] letters = str.toCharArray();
		int pos = 0;
		for (int i = 0, len = str.length(); i < len; i++) {
			pos = letters[i] - 'a';
			
			if (node.children[pos] == null) {
				node.children[pos] = new TrieNode();
				node.children[pos].value = letters[i];
			} 
			node.include_num++;
			node = node.children[pos];
		}
		node.isEnd = true;
	}
	
	public boolean Delete(String str){				
		if(Find(str) == false)
			return false;
		
		TrieNode node = root;
		char[] letters = str.toCharArray();
		recursive_delete(letters, 0, node);
		return true;
	}
	
	public void recursive_delete(char[] letters, int p, TrieNode n){
		if(p >= letters.length){
			n.isEnd = false;
			n.include_num--;
			return;
		}

		int pos = letters[p] - 'a';
		recursive_delete(letters, p + 1, n.children[pos]);
		if (n.children[pos].include_num == 0)
			n.children[pos] = null;
		n.include_num--;
	}

	public boolean Find(String str) {
		if (str == null || str.length() == 0) {
			return false;
		}
		TrieNode node = root;
		char[] letters = str.toCharArray();
		int pos = 0;
		for (int i = 0, len = str.length(); i < len; i++) {
			pos = letters[i] - 'a';
			if (node.children[pos] != null) {
				node = node.children[pos];
			} else {
				return false;
			}
		}
		return node.isEnd;
	}
	
	public boolean findPrefix(String str) {
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
	
	public static void main(String[] args){
		Trie t = new Trie();
		t.Insert("cat");
		t.Insert("matt");
		t.Insert("mat");
		t.Insert("map");
		t.Insert("cap");
		t.Insert("dat");
		t.preTraverse(t.root);
		System.out.println();
		System.out.println(t.Find("mat"));
		t.Delete("mat");
		t.preTraverse(t.root);
		System.out.println();
		t.Delete("matt");
		t.preTraverse(t.root);
		System.out.println();
		System.out.println(t.Find("mat"));
		System.out.println(t.Find("matt"));
		System.out.println(t.Find("dat"));
	}
}
