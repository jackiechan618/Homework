import java.util.LinkedList;
import java.util.LinkedList;


public class BackTracking {
	private int queen_num;        
	private int sum;	    
	private int[] x;	    
	
	public BackTracking(){
		queen_num = 8;        
		sum = 0;
		x = new int[queen_num+1];
	}
	
	public void backtrack_recursive(int row) {
		if(row <= queen_num){        
			 for(int i = 1; i <= queen_num; i++) {
				 x[row] = i;                
		            if(valid_recursive(row)) {        	            	
		            	backtrack_recursive(row+1);   
		            }
		        }
		}		
		else {  
	        sum++;      
	        for(int m = 1; m <= queen_num; m++) {
	            System.out.print(x[m] + ", "); 
	        }
	        System.out.println();
	    }	       
	}
	
	public boolean valid_recursive(int row) {
	    for(int j = 1; j < row; j++){
	    	if(Math.abs(x[row] - x[j]) == Math.abs(row-j) || x[j] == x[row]){
	    		return false;    
		    }
		}
	    return true;
	}
		
	public int getSum_recursive() {
		return sum;
	}
	
	
	public static void main(String[] args){
		BackTracking test = new BackTracking();
	    test.backtrack_recursive(1);   
	    System.out.println("recursive result is " + test.getSum_recursive());
	}
}
