
public class prod_Statistics {
	private double totallQuantity;
	private int count;
	private double average;
	
	public prod_Statistics(double totallQuantity, int count) {
		this.totallQuantity = totallQuantity;
		this.count = count;
	}
	
	public prod_Statistics(){
		
	}
	
	public double getTotallQuantity() {
		return totallQuantity;
	}
	public void setTotallQuantity(double totallQuantity) {
		this.totallQuantity = totallQuantity;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getAverage() {
		if(count != 0)
			average = totallQuantity / count;
		else
			average = 0;
		return (int) average;
	}
	public void upDate(int sQuant){
		totallQuantity += sQuant;
		count++;
	}
}
