import java.sql.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*************************************************************************************************************
*	Report 2, Assignment 1                                                                                   *
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
*	(3).There are two classes, class mainFunction_Part2 and class Tuple. Class mainFunction_Part2 is         *
*		the main class which contains main function and should be run and will call the other class.         *
*		Class Tuple used for recording the information for each of the combination of name and product       *
*		including the maximun and minimun quantity, and the state and the date they take place respectly.    *
*		In my code, the column of attribute customer is 'cust', the column of attribute product is 'prod,    *
*		the column of attribute state is 'state', the column of attribute quantity is 'quant'.               *
*                                                                                                            *
*************************************************************************************************************/


public class mainFunction_Part2 {
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
		
	public mainFunction_Part2(){
		user ="postgres";
		password ="wind";
		url ="jdbc:postgresql://localhost:5432/postgres";		
		myMap = new HashMap<String, Tuple>();
				
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
				
				if(myMap.containsKey(tempStr)){
					Tuple tempTuple = myMap.get(tempStr);
					
					if(state.equals("NY")){	
						if(Integer.parseInt(year) >= 2000 && Integer.parseInt(year) <= 2005 && tempTuple.getNyMaxQuantity() < quantity){
							myMap.remove(tempStr);
							tempTuple.setNyMaxQuantity(quantity);
							tempTuple.setNyMaxQuantityDate(date);
							myMap.put(tempStr, tempTuple);
						}
					}	
					else if(state.equals("NJ")){		
						if(Integer.parseInt(year) >= 2000 && Integer.parseInt(year) <= 2005 && tempTuple.getNjMaxQuantity() < quantity){
							myMap.remove(tempStr);
							tempTuple.setNjMaxQuantity(quantity);
							tempTuple.setNjMaxQuantityDate(date);
							myMap.put(tempStr, tempTuple);
						}
					}
					else if(state.equals("CT")){		
						if(tempTuple.getCtMinQuantity() > quantity || tempTuple.getCtMinQuantity() == 0){
							myMap.remove(tempStr);
							tempTuple.setCtMinQuantity(quantity);
							tempTuple.setCtMinQuantityDate(date);
							myMap.put(tempStr, tempTuple);
						}
					}
					else ;
				}
				else{
					if(Integer.parseInt(year) >= 2000 && Integer.parseInt(year) <= 2005 && state.equals("NY"))	
						myMap.put(tempStr, new Tuple(tempStr, quantity, 0, 0, date, "", ""));
					else if(Integer.parseInt(year) >= 2000 && Integer.parseInt(year) <= 2005 && state.equals("NJ"))	
						myMap.put(tempStr, new Tuple(tempStr, 0, quantity, 0, "", date, ""));
					else if(state.equals("CT"))	
						myMap.put(tempStr, new Tuple(tempStr, 0, 0, quantity, "", "", date));
					else ;
				}				
			}
			printResult();
		}catch(SQLException e) {
			System.out.println("Connection URL or username or password errors!");
			e.printStackTrace();
		}
	}
	
	public void printResult(){	
		Iterator iter = myMap.entrySet().iterator();
		Tuple tempTuple;
		String customer = "";
		String product = "";
		String[] splitStrArray;
		
		System.out.printf("%-10s","CUSTOMER");
		System.out.printf("%-10s","PRODUCT");
		System.out.printf("%10s","NY_MAX");
		System.out.print("       ");
		System.out.printf("%-10s","DATE");
		System.out.printf("%10s","NJ_MAX");
		System.out.print("       ");
		System.out.printf("%-10s","DATE");
		System.out.printf("%10s","CT_MIN");
		System.out.print("       ");
		System.out.printf("%-10s","DATE");
		System.out.println();
		
		System.out.printf("%-10s","========");
		System.out.printf("%-10s","========");
		System.out.printf("%10s","======");
		System.out.print("       ");
		System.out.printf("%-10s","==========");
		System.out.printf("%10s","======");
		System.out.print("       ");
		System.out.printf("%-10s","==========");
		System.out.printf("%10s","======");
		System.out.print("       ");
		System.out.printf("%-10s","==========");
		System.out.println();
		
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry)iter.next();
			tempTuple = (Tuple) entry.getValue();
			splitStrArray = tempTuple.getNameAndProduct().split("\\s{1,}");
			customer = splitStrArray[0];
			product = splitStrArray[1];

			System.out.printf("%-10s",customer);
			System.out.printf("%-10s",product);
			System.out.printf("%10s",(tempTuple.getNyMaxQuantity() != 0) ? tempTuple.getNyMaxQuantity() : "null");
			System.out.print("       ");
			System.out.printf("%-10s",(!tempTuple.getNyMaxQuantityDate().equals("")) ? tempTuple.getNyMaxQuantityDate() : "null");
			System.out.printf("%10s",(tempTuple.getNjMaxQuantity() != 0) ? tempTuple.getNjMaxQuantity() : "null");
			System.out.print("       ");
			System.out.printf("%-10s",(!tempTuple.getNjMaxQuantityDate().equals("")) ? tempTuple.getNjMaxQuantityDate() : "null");
			System.out.printf("%10s",(tempTuple.getCtMinQuantity() != 0) ? tempTuple.getCtMinQuantity() : "null");
			System.out.print("       ");
			System.out.printf("%-10s",(!tempTuple.getCtMinQuantityDate().equals("")) ? tempTuple.getCtMinQuantityDate() : "null");
			System.out.println();
		}	
	}
	
	public static void main(String[] args){
		mainFunction_Part2 myMainFunction = new mainFunction_Part2();
	}
}
