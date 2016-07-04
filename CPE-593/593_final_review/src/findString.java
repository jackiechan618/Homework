import java.util.HashSet;

public class findString {
	private String str = "this is a ttta test ttttattta";
	public boolean naive(String testStr){
		char[] c1 = str.toCharArray();
		char[] c2 = testStr.toCharArray();
		
		int j = 0;
		for(int i = 0; i < c1.length; ++i){
			while((i+j) < c1.length && j < c2.length && c2[j] == c1[i+j])
				j++;
			if(j != c2.length)
				j = 0;
			else
				return true;
		}
		return false;
	}
	
	public void KMP(String testStr){		
		int[] offset = new int[256];
		HashSet<Character> myset = new HashSet<Character>();
		for(int i = 0; i < 256; ++i)
			offset[i] = testStr.length();
		for(int i = 0; i < testStr.length(); ++i){
			offset[testStr.charAt(i)] = testStr.length()-i-1;
			myset.add(testStr.charAt(i));
		}
			
		for(int i = testStr.length()-1; i < str.length();){			
			while (i < str.length() && myset.contains(str.charAt(i))) {
				i += offset[str.charAt(i)];
				int pos = Integer.MAX_VALUE;
				if (i < str.length() && (pos = checkStr(str, testStr, i, testStr.length()-1, testStr.length())) < 0){
					System.out.println(testStr);
					i++;
				}
				else if(pos != Integer.MAX_VALUE){
					i = pos;
					i += offset[str.charAt(pos)];
				}
			}
			i += testStr.length();
		}
	}
	
	public int checkStr(String s1, String s2, int end1, int end2, int len){
		for(int i = 0; i < len; ++i)
			if(s1.charAt(end1-i) != s2.charAt(end2-i))
				return (end1-i);
		return -1;
	}
	
	public static void main(String[] args){
		findString f = new findString();
		String testStr = "ttta";
		System.out.println(f.naive(testStr));
		f.KMP(testStr);
	}
}
