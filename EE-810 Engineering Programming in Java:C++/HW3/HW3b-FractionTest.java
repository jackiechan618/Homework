
public class FractionTest {
	private int num, den, error_flag = 0;
	
	public FractionTest(int x, int y){
		this.num=x;         
		this.den=y;
	}
	
	public FractionTest(){
		this.num=0;         
		this.den=1;
	}
	
	public FractionTest Reduction(FractionTest original){		
		double min = 1.0;
		int negative_flag_num = 0,negative_flag_den = 0;
		
	    if(original.num == 0) original.den = 0;
	    else if(original.den == 0) original.error_flag = 1; 
	    else{
	      error_flag = 0;
	      
	      if(original.num < 0) {
	    	  original.num = -original.num; 
	    	  negative_flag_num = 1;
	      }
	      if(original.den < 0) {
	    	  original.den = -original.den; 
	    	  negative_flag_den = 1;
	      }
	      else ;
	      
	      if (original.num < original.den)
	       min=original.num;
	      else
	       min=original.den;

	      for (int i=2;i<=min;i++)
	      {
	     
	       if(i>original.num || i>original.den)
	        break; 
	       else if(original.num%i==0 && original.den%i==0)
	       {
	    	   original.num/=i;
	    	   original.den/=i;
	    	   i=1;
	       }
	      }
	    }
	    if(negative_flag_num == 1) original.num = -original.num;
	    if(negative_flag_den == 1) original.den = -original.den;
		return original;
	}
	
	public FractionTest add(FractionTest right){
		FractionTest ans=new FractionTest( );
		ans.den=this.den*right.den;
		ans.num=this.num*right.den+this.den*right.num;
		ans = Reduction(ans);
		return ans;
	}
	
	public FractionTest sub(FractionTest right){
		FractionTest ans=new FractionTest( );
		ans.den=this.den*right.den;
		ans.num=this.num*right.den-this.den*right.num;
		ans = Reduction(ans);
		return ans;
	}
	
	public FractionTest mult(FractionTest right){
		FractionTest ans=new FractionTest( );
		ans.den=this.den*right.den;
		ans.num=this.num*right.num;
		ans = Reduction(ans);
		return ans;
	}
	
	public FractionTest neg(){
		FractionTest ans=new FractionTest( );
		ans.den=this.den;
		ans.num=-this.num;
		ans = Reduction(ans);
		return ans;
	}	
	
	public String toString(){
		if(this.error_flag == 0) return num + "/" + den;
		else return "error: den = 0";
	}

	public static void main(String[] args) {
		for (int i = 1; i < 3; i++) {
			FractionTest f1 = new FractionTest(i,2);
			FractionTest f2 = new FractionTest(i,3);
			System.out.println(f1.add(f2));  
			System.out.println(f1.sub(f2));  
			System.out.println(f1.mult(f2)); 
			System.out.println(f1.neg());    
		}
		System.out.println(new FractionTest(1,2).add(new FractionTest(1,2)));
		System.out.println(new FractionTest(1,2).mult(new FractionTest(2,1)));
	}
}
