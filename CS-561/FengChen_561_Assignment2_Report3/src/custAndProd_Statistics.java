import java.util.LinkedList;


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
	private int Q1_minimum;
	private int Q2_minimum;
	private int Q3_minimum;
	private int Q4_minimum;
	private int beforeQ1Count;
	private int afterQ1Count;
	private int beforeQ2Count;
	private int afterQ2Count;
	private int beforeQ3Count;
	private int afterQ3Count;
	private int beforeQ4Count;
	private int afterQ4Count;
	private LinkedList<Integer> Q1_saleList;
	private LinkedList<Integer> Q2_saleList;
	private LinkedList<Integer> Q3_saleList;
	private LinkedList<Integer> Q4_saleList;
	
	
	public custAndProd_Statistics(int quaintity, int count, String quarter) {
		super();
		Q1_saleList = new LinkedList<Integer>();
		Q2_saleList = new LinkedList<Integer>();
		Q3_saleList = new LinkedList<Integer>();
		Q4_saleList = new LinkedList<Integer>();
		Q1_minimum = Integer.MAX_VALUE;
		Q2_minimum = Integer.MAX_VALUE;
		Q3_minimum = Integer.MAX_VALUE;
		Q4_minimum = Integer.MAX_VALUE;
		
		if(quarter.equals("Q1")){
			Q1_totallQuantity = quaintity;
			Q1_minimum = quaintity;
			Q1_count = count;
			Q1_saleList.add(quaintity);
			Q2_totallQuantity = Q3_totallQuantity = Q4_totallQuantity = 0;
			Q2_count = Q3_count = Q4_count = 0;
		}
		else if(quarter.equals("Q2")){
			Q2_totallQuantity = quaintity;
			Q2_minimum = quaintity;
			Q2_count = count;
			Q2_saleList.add(quaintity);
			Q1_totallQuantity = Q3_totallQuantity = Q4_totallQuantity = 0;
			Q1_count = Q3_count = Q4_count = 0;
		}
		else if(quarter.equals("Q3")){
			Q3_totallQuantity = quaintity;
			Q3_minimum = quaintity;
			Q3_count = count;
			Q3_saleList.add(quaintity);
			Q1_totallQuantity = Q2_totallQuantity = Q4_totallQuantity = 0;
			Q1_count = Q2_count = Q4_count = 0;
		}
		else{
			Q4_totallQuantity = quaintity;
			Q4_minimum = quaintity;
			Q4_count = count;
			Q4_saleList.add(quaintity);
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
			Q1_saleList.add(quant);
			if(Q1_minimum > quant)
				Q1_minimum = quant;		
		}
		else if(quarter.equals("Q2")){
			Q2_totallQuantity += quant;
			Q2_count++;
			Q2_saleList.add(quant);
			if(Q2_minimum > quant)
				Q2_minimum = quant;	
		}
		else if(quarter.equals("Q3")){
			Q3_totallQuantity += quant;
			Q3_count++;
			Q3_saleList.add(quant);
			if(Q3_minimum > quant)
				Q3_minimum = quant;	
		}
		else{
			Q4_totallQuantity += quant;
			Q4_count++;
			Q4_saleList.add(quant);
			if(Q4_minimum > quant)
				Q4_minimum = quant;	
		}		
	}
	public void computeTimes(){
		getQ1_average();
		getQ2_average();
		getQ3_average();
		getQ4_average();
		
		beforeQ1Count = 0;
		afterQ1Count = 0;  
		beforeQ2Count = 0; 
		afterQ2Count = 0;  
		beforeQ3Count = 0;  
		afterQ3Count = 0;
		beforeQ4Count = 0;  
		afterQ4Count = 0;
		
		for(int i = 0; i < Q1_saleList.size(); ++i){
			if(Q1_saleList.get(i) >= Q2_minimum && Q1_saleList.get(i) <= Q2_average)
				beforeQ2Count++;
		}		
		for(int i = 0; i < Q2_saleList.size(); ++i){
			if(Q2_saleList.get(i) >= Q1_minimum && Q2_saleList.get(i) <= Q1_average)
				afterQ1Count++;
			if(Q2_saleList.get(i) >= Q3_minimum && Q2_saleList.get(i) <= Q3_average)
				beforeQ3Count++;
		}
		for(int i = 0; i < Q3_saleList.size(); ++i){
			if(Q3_saleList.get(i) >= Q2_minimum && Q3_saleList.get(i) <= Q2_average)
				afterQ2Count++;
			if(Q3_saleList.get(i) >= Q4_minimum && Q3_saleList.get(i) <= Q4_average)
				beforeQ4Count++;
		}
		for(int i = 0; i < Q4_saleList.size(); ++i){
			if(Q4_saleList.get(i) >= Q3_minimum && Q4_saleList.get(i) <= Q3_average)
				afterQ3Count++;
		}
	}

	public int getBeforeQ1Count() {
		return beforeQ1Count;
	}
	public int getAfterQ1Count() {
		return afterQ1Count;
	}
	public int getBeforeQ2Count() {
		return beforeQ2Count;
	}
	public int getAfterQ2Count() {
		return afterQ2Count;
	}
	public int getBeforeQ3Count() {
		return beforeQ3Count;
	}
	public int getAfterQ3Count() {
		return afterQ3Count;
	}
	public int getBeforeQ4Count() {
		return beforeQ4Count;
	}
	public int getAfterQ4Count() {
		return afterQ4Count;
	}	
}
