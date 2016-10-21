import java.sql.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*************************************************************************************************************
*	Report 1, Assignment 1                                                                                   *
*	Name:  Feng Chen                                                                                         *
*	CWID:  10400586                                                                                          *
*	Email: fchen6@stevens                                                                                    *
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
*	(3).There are three classes, class mainFunction_Part1, class productStatistics and Tuple.                *
*		Class mainFunction_Part1 is the main class which contains main function and should be run            *
*		and will call the other two classes. Class productStatistics contains the total quantity and average *
*		quantity in each of the combination of name and product. Class Tuple used for recording the          *
*		information for each of the combination of name and product including the maximun and minimun        *
*		quantity, and the state and date they take place respectly. In my code, the column of attribute      *
*		customer is 'cust', the column of attribute product is 'prod, the column of attribute state          *
*		is 'state', the column of attribute quantity is 'quant'.                                             *
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
	private String tempStr;
	private HashMap<String, Tuple> myMap;
	private HashMap<String, productStatistics> nyProductMap;
	private HashMap<String, productStatistics> njProductMap;
	private HashMap<String, productStatistics> ctProductMap;
	private HashMap<String, productStatistics> paProductMap;
//	private double[][] productAverageQuantity;
//	private HashMap<String, Integer> productAverageQuantityMap;
		
	public mainFunction_Part1(){
		user ="postgres";
		password ="wind";
		url ="jdbc:postgresql://localhost:5432/postgres";		
		myMap = new HashMap<String, Tuple>();
		nyProductMap = new HashMap<String, productStatistics>();
		njProductMap = new HashMap<String, productStatistics>();
		ctProductMap = new HashMap<String, productStatistics>();
		paProductMap = new HashMap<String, productStatistics>();
				
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
				tempStr = customer.trim() + " " + product.trim();
				
				statisticsProduct(state, product, quantity);
				
				if(myMap.containsKey(tempStr)){
					Tuple tempTuple = myMap.get(tempStr);
					myMap.remove(tempStr);
					
					if(tempTuple.getMaxQuantity() < quantity){						
						tempTuple.setMaxQuantity(quantity);
						tempTuple.setStateForMax(state);
						tempTuple.setDataForMax(date);						
					}
					else if(tempTuple.getMinQuantity() > quantity){
						tempTuple.setMinQuantity(quantity);
						tempTuple.setStateForMin(state);
						tempTuple.setDataForMin(date);
					}
					else;
					
					tempTuple.setTotallQuantity(tempTuple.getTotallQuantity() + quantity);
					tempTuple.setCount(tempTuple.getCount() + 1);
					myMap.put(tempStr, tempTuple);
				}
				else{
					myMap.put(tempStr, new Tuple(tempStr, state, state, date, date, quantity, quantity, quantity, 1));
				}				
			}
			
			printResult();
		}catch(SQLException e) {
			System.out.println("Connection URL or username or password errors!");
			e.printStackTrace();
		}
	}
	
	public void statisticsProduct(String state, String product, int quantity){
		HashMap<String, productStatistics> operMap;
		if(state.equals("NY"))
			operMap = nyProductMap;
		else if(state.equals("NJ"))
			operMap = njProductMap;
		else if(state.equals("CT"))
			operMap = ctProductMap;
		else 
			operMap = paProductMap;
		
		if(operMap.containsKey(product)){
			productStatistics temp = (productStatistics) operMap.get(product);
			operMap.remove(product);
			temp.setTotallQuantity(temp.getTotallQuantity() + quantity);
			temp.setCount(temp.getCount() + 1);
			operMap.put(product, temp);
		}
		else
			operMap.put(product, new productStatistics(quantity, 1));
	}
	
	public void printResult(){	
		Iterator iter = myMap.entrySet().iterator();
		Tuple tempTuple;
		String customer = "";
		String product = "";
		String[] splitStrArray;
		double averageQuantity;
		
		System.out.printf("%-10s","CUSTOMER");
		System.out.printf("%-10s","PRODUCT");
		System.out.printf("%10s","MAX_Q");
		System.out.print("       ");
		System.out.printf("%-10s","DATE");
		System.out.print("       ");
		System.out.printf("%-5s","ST");
		System.out.printf("%10s","MIN_Q");
		System.out.print("       ");
		System.out.printf("%-10s","DATE");
		System.out.print("       ");
		System.out.printf("%-5s","ST");
		System.out.printf("%10s","AVG_Q");
		System.out.println();
		
		System.out.printf("%-10s","========");
		System.out.printf("%-10s","========");
		System.out.printf("%10s","=====");
		System.out.print("       ");
		System.out.printf("%-10s","==========");
		System.out.print("       ");
		System.out.printf("%-5s","==");
		System.out.printf("%10s","=====");
		System.out.print("       ");
		System.out.printf("%-10s","==========");
		System.out.print("       ");
		System.out.printf("%-5s","==");
		System.out.printf("%10s","=====");
		System.out.println();
		
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry)iter.next();
			tempTuple = (Tuple) entry.getValue();
			splitStrArray = tempTuple.getNameAndProduct().split("\\s{1,}");
			customer = splitStrArray[0];
			product = splitStrArray[1];
			if(tempTuple.getCount() > 1)
				averageQuantity = tempTuple.getTotallQuantity() / (double)tempTuple.getCount();
			else
				averageQuantity = tempTuple.getMaxQuantity();
			
			System.out.printf("%-10s",customer);
			System.out.printf("%-10s",product);
			System.out.printf("%10s",tempTuple.getMaxQuantity());
			System.out.print("       ");
			System.out.printf("%-10s",tempTuple.getDataForMax());
			System.out.print("       ");
			System.out.printf("%-5s",tempTuple.getStateForMax());
			System.out.printf("%10s",tempTuple.getMinQuantity());
			System.out.print("       ");
			System.out.printf("%-10s",tempTuple.getDataForMin());
			System.out.print("       ");
			System.out.printf("%-5s",tempTuple.getStateForMin());
			System.out.printf("%10s",(int) averageQuantity);
			System.out.println();
		}	
	}
	
	public static void main(String[] args){
		mainFunction_Part1 myMainFunction = new mainFunction_Part1();
	}
	
//	public void calculateAverageQuantity(){
//		int num = Integer.MIN_VALUE;
//		num = Math.max(num, nyProductMap.size());
//		num = Math.max(num, njProductMap.size());
//		num = Math.max(num, ctProductMap.size());
//		num = Math.max(num, paProductMap.size());
//		
//		productAverageQuantity = new double[4][num];
//		productAverageQuantityMap = new HashMap<String, Integer>();
//		HashMap<String, productStatistics> tempMap;
//		for(int i = 0; i < 4; ++i){
//			if(i == 0) tempMap = nyProductMap;
//			else if(i == 1) tempMap = njProductMap;
//			else if(i == 2) tempMap = ctProductMap;
//			else tempMap = paProductMap;
//			Iterator iter = tempMap.entrySet().iterator();
//			int count = 0;
//			while(iter.hasNext()){
//				Map.Entry entry = (Map.Entry)iter.next();
//				productStatistics tempInfo = (productStatistics) entry.getValue();
//				String product = (String) entry.getKey();
//				if(!productAverageQuantityMap.containsKey(product))
//					productAverageQuantityMap.put(product, count++);		
//				productAverageQuantity[i][productAverageQuantityMap.get(product)] = tempInfo.getTotallQuantity() / tempInfo.getCount();
//			}
//		}		
//	}
}

