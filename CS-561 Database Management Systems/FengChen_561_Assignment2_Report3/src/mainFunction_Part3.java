import java.sql.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*************************************************************************************************************
*	Report 3, Assignment 2                                                                                   *
*	Name:  Feng Chen                                                                                         *
*	CWID:  10400586                                                                                          *
*	Email: fchen6@stevens.edu                                                                                *
*	                                                                                                         *
*	(1).This project is for problem 3. To compile this code, firstly you need to generate the sales table    *
*		in your database. I am using pgAdmin III and when firing up the pgAdmin III, I select the            *
*		database in the server and create the "sales" table, and the sql is:                                 *
*			create table sales                                                                               *
*			(                                                                                                *
*				cust	varchar(20),                                                                         *
*				prod	varchar(20),                                                                         *
*				day	integer,                                                                                 *
*				month	integer,                                                                             *
*				year	integer,                                                                             *
*				state	char(2),                                                                             *
*				quant	integer                                                                              *
*			)                                                                                                *
*		and then insert all those 500 records into the table sales. Then you can run this program, thanks.   *
*                                                                                                            *
*   (2).I have already put the postgresql-9.4-1203.jbdc4.jar in the lib folder in my file and build the path.*
*    	If the code cannot be compiled please rebuild the path way. Because I use my username and password,  *
*    	so before you run the code please be sure that you have changed the user name, password and url of   *
*    	your database to your own username and password along url. And now running the                       *
*    	mainFunction_Part1.java and you can see the report in the console.                                   *
*                                                                                                            *
*	(3).There are two classes, class mainFunction_Part3 and class custAndPord_Statistics. Class              *  
*		mainFunction_Part3 is the main class which contains main function and should be run and will call    *
*		the class custAndPord_Statistics. Class custAndPord_Statistics contains the total, average and       * 
*		minimum quantity of four seasons without considering the year in each of the combination of name and *
*		product. And in class custAndPord_Statistics, four LinkedLists Q1_saleList, Q2_saleList, Q3_saleList *
*		and Q4_saleList are used for recording each sale for four season without considering the year. The   *
*		variable Q1_count, Q2_count, Q3_count, Q4_count are used for recording the time of sales of the      *
*		following quarter had quantities between that quarter’s average sale and minimum sale.               *
*                                                                                                            *
*************************************************************************************************************/


public class mainFunction_Part3 {
	private String user;
	private String password;
	private String url;		
	private String customer;
	private String product;
	private String state;
	private String day;
	private String month;
	private String year;
	private String date;
	private int quantity;
	private String custAndPord;
	private HashMap<String, custAndProd_Statistics> customer_product_map;
		
	public mainFunction_Part3(){
		user ="postgres";
		password ="wind";
		url ="jdbc:postgresql://localhost:5432/postgres";		
		customer_product_map = new HashMap<String, custAndProd_Statistics>();
				
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Success loading Driver!");
		}catch(Exception e) {
			System.out.println("Fail loading Driver!");
			e.printStackTrace();
		}
		
		try{
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("Success connecting server!");
			System.out.println();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Sales");

			while (rs.next()){
				customer = rs.getString("cust");
				product = rs.getString("prod");
				state = rs.getString("state");
				day = rs.getString("day");
				month = rs.getString("month");
				year = rs.getString("year");
				quantity = rs.getInt("quant");
				if(Integer.parseInt(day) < 10) day = "0" + day;
				if(Integer.parseInt(month) < 10) month = "0" + month;
				if(Integer.parseInt(year) < 10) year = "0" + year;
				date = month + "/" + day + "/" + year;
				custAndPord = customer.trim() + " " + product.trim();			
				statisticsProduct(customer, product, custAndPord, quantity, month);		
			}			
			printResult();
		}catch(SQLException e) {
			System.out.println("Connection URL or username or password errors!");
			e.printStackTrace();
		}
	}
	
	public void statisticsProduct(String customer, String product, String custAndPord, int quantity, String m){
		int month = Integer.parseInt(m);
		String quarter = "";
		
		if(month >= 1 && month <= 3)
			quarter = "Q1";
		else if(month >= 4 && month <= 6)
			quarter = "Q2";
		else if(month >= 7 && month <= 9)
			quarter = "Q3";
		else
			quarter = "Q4";
		
		if(customer_product_map.containsKey(custAndPord)){
			custAndProd_Statistics tempTuple = customer_product_map.get(custAndPord);
			customer_product_map.remove(custAndPord);
			tempTuple.upDate(quantity, quarter);
			customer_product_map.put(custAndPord, tempTuple);
		}
		else{
			customer_product_map.put(custAndPord, new custAndProd_Statistics(quantity, 1, quarter));
		}
	}
	
	public void printResult(){	
		Iterator iter = customer_product_map.entrySet().iterator();
		custAndProd_Statistics tempCustAndProdTuple;
		
		String tempCustAndProd = "";
		String customer = "";
		String product = "";
		int before_Q1 = 0;
		int after_Q1 = 0;
		int before_Q2 = 0;
		int after_Q2 = 0;
		int before_Q3 = 0;
		int after_Q3 = 0;
		int before_Q4 = 0;
		int after_Q4 = 0;
		String[] splitStrArray;	
		
		System.out.printf("%-10s","CUSTOMER");
		System.out.printf("%-10s","PRODUCT");
		System.out.printf("%10s","QUARTER");
		System.out.printf("%15s","BEFORE_TOT");
		System.out.printf("%15s","AFTER_TOT");
		System.out.println();
		
		System.out.printf("%-10s","========");
		System.out.printf("%-10s","=======");
		System.out.printf("%10s","=======");
		System.out.printf("%15s","==========");
		System.out.printf("%15s","==========");
		System.out.println();
		
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry)iter.next();
			tempCustAndProdTuple = (custAndProd_Statistics) entry.getValue();
			tempCustAndProd = (String) entry.getKey();
			tempCustAndProdTuple.computeTimes();
			splitStrArray = tempCustAndProd.split("\\s{1,}");
			customer = splitStrArray[0];
			product = splitStrArray[1];

			after_Q1 = tempCustAndProdTuple.getAfterQ1Count();
			before_Q2 = tempCustAndProdTuple.getBeforeQ2Count();
			after_Q2 = tempCustAndProdTuple.getAfterQ2Count();
			before_Q3 = tempCustAndProdTuple.getBeforeQ3Count();
			after_Q3 = tempCustAndProdTuple.getAfterQ3Count();
			before_Q4 = tempCustAndProdTuple.getBeforeQ4Count();
			
			System.out.printf("%-10s", customer);
			System.out.printf("%-10s", product);
			System.out.printf("%10s", "Q1");
			System.out.printf("%15s", "<null>");
			System.out.printf("%15s", (after_Q1 > 0) ? after_Q1 : "<null>");			
			System.out.println();
			
			System.out.printf("%-10s", customer);
			System.out.printf("%-10s", product);
			System.out.printf("%10s", "Q2");
			System.out.printf("%15s", (before_Q2 > 0) ? before_Q2 : "<null>");
			System.out.printf("%15s", (after_Q2 > 0) ? after_Q2 : "<null>");			
			System.out.println();
			
			System.out.printf("%-10s", customer);
			System.out.printf("%-10s", product);
			System.out.printf("%10s", "Q3");
			System.out.printf("%15s", (before_Q3 > 0) ? before_Q3 : "<null>");
			System.out.printf("%15s", (after_Q3 > 0) ? after_Q3 : "<null>");			
			System.out.println();
			System.out.printf("%-10s", customer);
			System.out.printf("%-10s", product);
			System.out.printf("%10s", "Q4");
			System.out.printf("%15s", (before_Q4 > 0) ? before_Q4 : "<null>");
			System.out.printf("%15s", "<null>");			
			System.out.println();
		}	
	}
	
	public static void main(String[] args){
		mainFunction_Part3 myMainFunction = new mainFunction_Part3();
	}
}

