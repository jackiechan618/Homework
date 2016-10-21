import java.util.ArrayList;

public class testList {	
	public static void main(String a[]){
		
		/* *****   arrayList    ***** */
		ArrayList list1 = new ArrayList(10000000);
		long t0 = System.currentTimeMillis();
		for(long i = 0; i < 10000000; i++) 
			list1.add(i);
		long t1 = System.currentTimeMillis();
		System.out.println("arraryList:");
		System.out.println("t0="+t0);
		System.out.println("t1="+t1);
		System.out.println("t1-t0 = "+(t1-t0));
		
		/* *******   array    ******* */
		t0 = System.currentTimeMillis();
		int[] array1 = new int[10000000];
		for (int trials = 0; trials < 100; trials++) {
		  for (int i = 0; i < a.length; i++)
		    array1[i] = i;
		}
		t1 = System.currentTimeMillis();
		System.out.println("arrary:");
		System.out.println("t0="+t0);
		System.out.println("t1="+t1);
		System.out.println("t1-t0 = "+(t1-t0));
	}
}
