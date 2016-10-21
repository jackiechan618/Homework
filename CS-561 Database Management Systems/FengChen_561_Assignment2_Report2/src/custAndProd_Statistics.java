
public class custAndProd_Statistics {
	private double Q1_totallQuantity;
	private double Q2_totallQuantity;
	private double Q3_totallQuantity;
	private double Q4_totallQuantity;
	private int Q1_count;
	private int Q2_count;
	private int Q3_count;
	private int Q4_count;
	private double Q1_average;
	private double Q2_average;
	private double Q3_average;
	private double Q4_average;
	
	public custAndProd_Statistics(int quaintity, int count, String quarter) {
		super();
		if(quarter.equals("Q1")){
			Q1_totallQuantity = quaintity;
			Q1_count = count;
			Q2_totallQuantity = Q3_totallQuantity = Q4_totallQuantity = 0;
			Q2_count = Q3_count = Q4_count = 0;
		}
		else if(quarter.equals("Q2")){
			Q2_totallQuantity = quaintity;
			Q2_count = count;
			Q1_totallQuantity = Q3_totallQuantity = Q4_totallQuantity = 0;
			Q1_count = Q3_count = Q4_count = 0;
		}
		else if(quarter.equals("Q3")){
			Q3_totallQuantity = quaintity;
			Q3_count = count;
			Q1_totallQuantity = Q2_totallQuantity = Q4_totallQuantity = 0;
			Q1_count = Q2_count = Q4_count = 0;
		}
		else{
			Q4_totallQuantity = quaintity;
			Q4_count = count;
			Q1_totallQuantity = Q2_totallQuantity = Q3_totallQuantity = 0;
			Q1_count = Q2_count = Q3_count = 0;
		}
		Q1_average = 0;
		Q2_average = 0;
		Q3_average = 0;
		Q4_average = 0;
	}
	
	public custAndProd_Statistics(){
		
	}
	
	public double getQ1_totallQuantity() {
		return Q1_totallQuantity;
	}
	public void setQ1_totallQuantity(double q1_totallQuantity) {
		Q1_totallQuantity = q1_totallQuantity;
	}
	public double getQ2_totallQuantity() {
		return Q2_totallQuantity;
	}
	public void setQ2_totallQuantity(double q2_totallQuantity) {
		Q2_totallQuantity = q2_totallQuantity;
	}
	public double getQ3_totallQuantity() {
		return Q3_totallQuantity;
	}
	public void setQ3_totallQuantity(double q3_totallQuantity) {
		Q3_totallQuantity = q3_totallQuantity;
	}
	public double getQ4_totallQuantity() {
		return Q4_totallQuantity;
	}
	public void setQ4_totallQuantity(double q4_totallQuantity) {
		Q4_totallQuantity = q4_totallQuantity;
	}
	public int getQ1_count() {
		return Q1_count;
	}
	public void setQ1_count(int q1_count) {
		Q1_count = q1_count;
	}
	public int getQ2_count() {
		return Q2_count;
	}
	public void setQ2_count(int q2_count) {
		Q2_count = q2_count;
	}
	public int getQ3_count() {
		return Q3_count;
	}
	public void setQ3_count(int q3_count) {
		Q3_count = q3_count;
	}
	public int getQ4_count() {
		return Q4_count;
	}
	public void setQ4_count(int q4_count) {
		Q4_count = q4_count;
	}
	public double getQ1_average() {		
		Q1_average = Q1_totallQuantity / Q1_count;
		return Q1_average;
	}
	public void setQ1_average(double q1_average) {
		Q1_average = q1_average;
	}
	public double getQ2_average() {
		Q2_average = Q2_totallQuantity / Q2_count;
		return Q2_average;
	}
	public void setQ2_average(double q2_average) {
		Q2_average = q2_average;
	}
	public double getQ3_average() {
		Q3_average = Q3_totallQuantity / Q3_count;
		return Q3_average;
	}
	public void setQ3_average(double q3_average) {
		Q3_average = q3_average;
	}
	public double getQ4_average() {
		Q4_average = Q4_totallQuantity / Q4_count;
		return Q4_average;
	}
	public void setQ4_average(double q4_average) {
		Q4_average = q4_average;
	}
	public void upDate(int quant, String quarter){
		if(quarter.equals("Q1")){
			Q1_totallQuantity += quant;
			Q1_count++;
		}
		else if(quarter.equals("Q2")){
			Q2_totallQuantity += quant;
			Q2_count++;
		}
		else if(quarter.equals("Q3")){
			Q3_totallQuantity += quant;
			Q3_count++;
		}
		else{
			Q4_totallQuantity += quant;
			Q4_count++;
		}		
	}
}
