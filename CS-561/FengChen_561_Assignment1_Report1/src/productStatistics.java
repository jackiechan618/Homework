
public class productStatistics {
	private double totallQuantity;
	private int count;
	private double average;
	
	public productStatistics(double totallQuantity, int count) {
		this.totallQuantity = totallQuantity;
		this.count = count;
	}
	
	public productStatistics(){
		
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
}
