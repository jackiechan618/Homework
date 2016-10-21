
public class Tuple {
	private String nameAndProduct;
	private int nyMaxQuantity;
	private int njMaxQuantity;
	private int ctMinQuantity;
	private String nyMaxQuantityDate;
	private String njMaxQuantityDate;
	private String ctMinQuantityDate;
	
	public Tuple(String nameAndProduct, int nyMaxQuantity, int njMaxQuantity,
			int ctMinQuantity, String nyMaxQuantityDate,
			String njMaxQuantityDate, String ctMinQuantityDate) {
		super();
		this.nameAndProduct = nameAndProduct;
		this.nyMaxQuantity = nyMaxQuantity;
		this.njMaxQuantity = njMaxQuantity;
		this.ctMinQuantity = ctMinQuantity;
		this.nyMaxQuantityDate = nyMaxQuantityDate;
		this.njMaxQuantityDate = njMaxQuantityDate;
		this.ctMinQuantityDate = ctMinQuantityDate;
	}	
	
	public Tuple(){
		
	}

	public String getNameAndProduct() {
		return nameAndProduct;
	}

	public void setNameAndProduct(String nameAndProduct) {
		this.nameAndProduct = nameAndProduct;
	}

	public int getNyMaxQuantity() {
		return nyMaxQuantity;
	}

	public void setNyMaxQuantity(int nyMaxQuantity) {
		this.nyMaxQuantity = nyMaxQuantity;
	}

	public int getNjMaxQuantity() {
		return njMaxQuantity;
	}

	public void setNjMaxQuantity(int njMaxQuantity) {
		this.njMaxQuantity = njMaxQuantity;
	}

	public int getCtMinQuantity() {
		return ctMinQuantity;
	}

	public void setCtMinQuantity(int ctMinQuantity) {
		this.ctMinQuantity = ctMinQuantity;
	}

	public String getNyMaxQuantityDate() {
		return nyMaxQuantityDate;
	}

	public void setNyMaxQuantityDate(String nyMaxQuantityDate) {
		this.nyMaxQuantityDate = nyMaxQuantityDate;
	}

	public String getNjMaxQuantityDate() {
		return njMaxQuantityDate;
	}

	public void setNjMaxQuantityDate(String njMaxQuantityDate) {
		this.njMaxQuantityDate = njMaxQuantityDate;
	}

	public String getCtMinQuantityDate() {
		return ctMinQuantityDate;
	}

	public void setCtMinQuantityDate(String ctMinQuantityDate) {
		this.ctMinQuantityDate = ctMinQuantityDate;
	}
}
