
public class Tuple {
	private String nameAndProduct;
	private String stateForMax;
	private String stateForMin;
	private String dataForMax;
	private String dataForMin;
	private int maxQuantity;
	private int minQuantity;
	private long totallQuantity;
	private int count;
	
	public Tuple(String nameAndProduct, String stateForMax, String stateForMin,
			String dataForMax, String dataForMin, int maxQuantity,
			int minQuantity, long totallQuantity, int count) {
		super();
		this.nameAndProduct = nameAndProduct;
		this.stateForMax = stateForMax;
		this.stateForMin = stateForMin;
		this.dataForMax = dataForMax;
		this.dataForMin = dataForMin;
		this.maxQuantity = maxQuantity;
		this.minQuantity = minQuantity;
		this.totallQuantity = totallQuantity;
		this.count = count;
	}
	
	public Tuple(){
		
	}
	
	public String getNameAndProduct() {
		return nameAndProduct;
	}
	public void setNameAndProduct(String nameAndProduct) {
		this.nameAndProduct = nameAndProduct;
	}
	public String getStateForMax() {
		return stateForMax;
	}
	public void setStateForMax(String stateForMax) {
		this.stateForMax = stateForMax;
	}
	public String getStateForMin() {
		return stateForMin;
	}
	public void setStateForMin(String stateForMin) {
		this.stateForMin = stateForMin;
	}
	public String getDataForMax() {
		return dataForMax;
	}
	public void setDataForMax(String dataForMax) {
		this.dataForMax = dataForMax;
	}
	public String getDataForMin() {
		return dataForMin;
	}
	public void setDataForMin(String dataForMin) {
		this.dataForMin = dataForMin;
	}
	public int getMaxQuantity() {
		return maxQuantity;
	}
	public void setMaxQuantity(int maxQuantity) {
		this.maxQuantity = maxQuantity;
	}
	public int getMinQuantity() {
		return minQuantity;
	}
	public void setMinQuantity(int minQuantity) {
		this.minQuantity = minQuantity;
	}
	public long getTotallQuantity() {
		return totallQuantity;
	}
	public void setTotallQuantity(long totallQuantity) {
		this.totallQuantity = totallQuantity;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
