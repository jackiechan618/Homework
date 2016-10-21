import java.sql.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*************************************************************************************************************
*	Report 1, Assignment 2                                                                                   *
*	Name:  Feng Chen                                                                                         *
*	CWID:  10400586                                                                                          *
*	Email: fchen6@stevens.edu                                                                                *
*	                                                                                                         *
*	(1).This project is for problem 1. To compile this code, firstly you need to generate the sales table    *
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
*	(3).There are four classes, class mainFunction_Part1, class cust_Statistics, custAndPord_Statistics and  *
*		prod_Statistics. Class mainFunction_Part1 is the main class which contains main function and should  *
*		be run and will call the other three classes. Class cust_Statistics is used for getting the average  * 
*		sale of all product for each customer. Class custndProd_Statistics contains the total quantity and   *
*		average quantity in each of the combination of name and product. Class prod_Statistics records the   *
*		total and average quantity of each product which has been consuming.                                 *
*                                                                                                            *
*************************************************************************************************************/


public class mainFunction_Part1 {
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
	private HashMap<String, cust_Statistics> customer_map;
	private HashMap<String, prod_Statistics> product_map;
		
	public mainFunction_Part1(){
		user ="postgres";
		password ="wind";
		url ="jdbc:postgresql://localhost:5432/postgres";		
		customer_product_map = new HashMap<String, custAndProd_Statistics>();
		customer_map = new HashMap<String, cust_Statistics>();
		product_map = new HashMap<String, prod_Statistics>();
				
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
				statisticsProduct(customer, product, custAndPord, quantity);		
			}			
			printResult();
		}catch(SQLException e) {
			System.out.println("Connection URL or username or password errors!");
			e.printStackTrace();
		}
	}
	
	public void statisticsProduct(String customer, String product, String custAndPord, int quantity){
		if(customer_product_map.containsKey(custAndPord)){
			custAndProd_Statistics tempTuple = customer_product_map.get(custAndPord);
			customer_product_map.remove(custAndPord);
			tempTuple.upDate(quantity);
			customer_product_map.put(custAndPord, tempTuple);
		}
		else{
			customer_product_map.put(custAndPord, new custAndProd_Statistics(quantity, 1));
		}
		
		if(customer_map.containsKey(customer)){
			cust_Statistics tempTuple = customer_map.get(customer);
			customer_map.remove(customer);
			tempTuple.upDate(quantity);
			customer_map.put(customer, tempTuple);
		}
		else{
			customer_map.put(customer, new cust_Statistics(quantity, 1));
		}
		
		if(product_map.containsKey(product)){
			prod_Statistics tempTuple = product_map.get(product);
			product_map.remove(product);
			tempTuple.upDate(quantity);
			product_map.put(product, tempTuple);
		}
		else{
			product_map.put(product, new prod_Statistics(quantity, 1));
		}
	}
	
	public void printResult(){	
		Iterator iter = customer_product_map.entrySet().iterator();
		custAndProd_Statistics tempCustAndProdTuple;
		cust_Statistics tempCustTuple;
		prod_Statistics tempProdTuple;
		
		String tempCustAndProd = "";
		String customer = "";
		String product = "";
		int cust_avg = 0;
		int other_cust_avg = 0;
		int other_prod_avg = 0;	
		String[] splitStrArray;	
		
		System.out.printf("%-10s","CUSTOMER");
		System.out.printf("%-10s","PRODUCT");
		System.out.printf("%10s","CUST_AVG");
		System.out.printf("%15s","OTHER_CUST_AVG");
		System.out.printf("%15s","OTHER_PROD_AVG");
		System.out.println();
		
		System.out.printf("%-10s","========");
		System.out.printf("%-10s","=======");
		System.out.printf("%10s","========");
		System.out.printf("%15s","==============");
		System.out.printf("%15s","==============");
		System.out.println();
		
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry)iter.next();
			tempCustAndProdTuple = (custAndProd_Statistics) entry.getValue();
			tempCustAndProd = (String) entry.getKey();
			splitStrArray = tempCustAndProd.split("\\s{1,}");
			customer = splitStrArray[0];
			product = splitStrArray[1];
			cust_avg = tempCustAndProdTuple.getAverage();			
			
			if(product_map.containsKey(product)){
				tempProdTuple = product_map.get(product);				
				double diffNum = tempProdTuple.getTotallQuantity() - tempCustAndProdTuple.getTotallQuantity();
				int count = tempProdTuple.getCount() - tempCustAndProdTuple.getCount();
				other_cust_avg = (int) (diffNum / count);
			}
			
			if(customer_map.containsKey(customer)){
				tempCustTuple = customer_map.get(customer);				
				double diffNum = tempCustTuple.getTotallQuantity() - tempCustAndProdTuple.getTotallQuantity();
				int count = tempCustTuple.getCount() - tempCustAndProdTuple.getCount();
				other_prod_avg = (int) (diffNum / count);
			}
			
			System.out.printf("%-10s", customer);
			System.out.printf("%-10s", product);
			System.out.printf("%10s", cust_avg);
			System.out.printf("%15s", other_cust_avg);
			System.out.printf("%15s", other_prod_avg);			
			System.out.println();
		}	
	}
	
	public static void main(String[] args){
		mainFunction_Part1 myMainFunction = new mainFunction_Part1();
	}
}

