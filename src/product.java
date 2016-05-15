
import java.sql.*;
import java.text.DecimalFormat;
import java.util.Scanner;


public class product{
	
	public void product(Customer customer){
		GenerateRegisteredCustomers.getGenerateRegisteredCustomers();
	
	}
	
	public int prod_id, stock_num;
	public float prod_price;
	public String name_prod;
	boolean orderplaced = false;
	public float total_cost = 0;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/products";
	static final String DB_URL1 = "jdbc:mysql://localhost/orders";
	static final String USER = "root";
	static final String PASSWORD = "Callash0825";
		public void ReadDatabase( int customerID){
			int arrayelement = customerID - 1;
	//	String del_address = GenerateRegisteredCustomers.getGenerateRegisteredCustomers().get_delivery_address(arrayelement);
	//	String del_postcode = GenerateRegisteredCustomers.getGenerateRegisteredCustomers().get_delivery_postcode(arrayelement);
			Connection conn = null;
			Statement stmt = null;
			Connection conn1 = null;
	//		Statement stmt1 = null;
			
	try {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Connecting to database NB ...");
		conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
		conn1 = DriverManager.getConnection(DB_URL1, USER, PASSWORD);
		
		System.out.println("Creating statement...");
		stmt = conn.createStatement();
//		stmt1 = conn1.createStatement();
		String sq12 = "SELECT idproducts, product_name, keywords, num_stock, price  FROM products";
		
		
		boolean ordering = true;
		
		while(ordering == true){
			ResultSet rs = stmt.executeQuery(sq12);
			boolean product_found = false;
		System.out.println("Do you want to search for the order by product number, product name or by keywords?");
		System.out.println("Type 1 for productid, 2 for product name or 3 for keywords");
		Scanner scan7 = new Scanner(System.in);
		Scanner scan9 = new Scanner(System.in);
		Scanner scan8 = new Scanner(System.in);
		int searchby = scan8.nextInt();
		if (searchby == 1){
			System.out.println("What is the product number?");
			 prod_id = scan8.nextInt();
		while (rs.next()) {
			int id = rs.getInt("idproducts");
			if(id == prod_id){
				product_found = true;
			String product_name = rs.getString("product_name");
			String keywords = rs.getString("keywords");
			int num_stock = rs.getInt("num_stock");
			float price = rs.getFloat("price");
			
			System.out.println("ID: " + id + ", product name: " + product_name + ", keyword: "
					+ keywords + ", num_stock: " + num_stock + " and price: " + price);
			System.out.println("Is this the product you want?");
			String ans = scan7.next();
			if(ans.equalsIgnoreCase("yes")){
			stock_num = num_stock;
			prod_price = price;
			name_prod =product_name;
			}
			}
		}
		}
		else if (searchby == 2){
		
				System.out.println("What is the product name?");
				name_prod = scan9.nextLine();
				while (rs.next()) {
				int id = rs.getInt("idproducts");
				String product_name = rs.getString("product_name");
				if(product_name.equalsIgnoreCase(name_prod)){
					product_found = true;
					System.out.println("Product Found!!!");
					String keywords = rs.getString("keywords");
					int num_stock = rs.getInt("num_stock");
					float price = rs.getFloat("price");					
		System.out.println("ID: " + id + ", product name: " + product_name + ", keyword: "
							+ keywords + ", num_stock: " + num_stock + " and price: " + price);
		System.out.println("Is this the product you want?");
		String ans = scan7.next();
		if(ans.equalsIgnoreCase("yes")){
		stock_num = num_stock;
		prod_price = price;
		prod_id = id;
				}
			
		}
				}
		}
		
			
		else if(searchby == 3) {
			System.out.println("Can you type a keyword please?");
			String keyword = scan9.nextLine();
			
		
			while (rs.next()) {
			int id = rs.getInt("idproducts");
			String product_name = rs.getString("product_name");
			String keywords = rs.getString("keywords");
			int num_stock = rs.getInt("num_stock");
			float price = rs.getFloat("price");
			boolean match1 = keywords.contains(keyword);
			System.out.println("the keyword match is " + match1);
			if (match1 == true){
				product_found = true;
			System.out.println("ID: " + id + ", product name: " + product_name + ", keyword: "
					+ keywords + ", num_stock: " + num_stock + " and price: " + price);
			}
			}
			System.out.println("Please type the product ID number of the product you want");
			prod_id = scan8.nextInt();
			ResultSet rs3 = stmt.executeQuery(sq12);
			rs3.next();
				int id = rs3.getInt("idproducts");
				if(id == prod_id){
				product_found = true;
			    String product_name = rs3.getString("product_name");
				String keywords = rs3.getString("keywords");
				int num_stock = rs3.getInt("num_stock");
				float price = rs3.getFloat("price");
				System.out.println("ID: " + id + ", product name: " + product_name + ", keyword: "
						+ keywords + ", num_stock: " + num_stock + " and price: " + price);
				System.out.println("Is this the product you want?");
				String ans = scan7.next();
				if(ans.equalsIgnoreCase("yes")){
				stock_num = num_stock;
				prod_price = price;
				name_prod =product_name;
				}
				
		
			
		}
		}

	else {
		System.out.println("Error incorrect search parameter typed");
	}
		if(product_found == true){
		
				System.out.println("How many do you want to order?");
				int amount_order = scan8.nextInt();
				float cost = amount_order * prod_price;
	//			int stock_now  = stock_num - amount_order;
				
//				addOrder(new Payment(prod_id, name_prod, amount_order, cost));
				
	//			GenerateOrderList.getgenerateorderlist().TotalCost();
				
				//String sq14 = "UPDATE nb.products SET num_stock = " + stock_now + "WHERE product_ID = " + id;
	//			String sq13 = "INSERT INTO orders.orders " + "VALUES (" + customerID + ", '" + del_postcode + "', '" + del_address + "', " + prod_id + ", '" + name_prod + "', " + amount_order + ", " + cost + ")";
	//			String sq14 = "update products.products set num_stock = '"+ stock_now + "' where idproducts = " + prod_id;
	
	//			stmt.executeUpdate(sq14);
	//			stmt1.executeUpdate(sq13);
				
			
				System.out.println("Do you want to place another order?");
				String answer = scan7.next();
				if(answer.equalsIgnoreCase("yes")){
					System.out.println("More orders being placed");
					orderplaced = true;
					
				} else {
						ordering = false;
						conn.close();
						conn1.close();
					}
				}
		
		else {
		System.out.println("Do you wish to try again?");
		String answer = scan7.next();
		if(answer.equalsIgnoreCase("yes")){
				ordering = false;
				conn.close();
				conn1.close();
			}
		}
		scan7.close();
		scan8.close();
		scan9.close();
	}

	}
	catch(SQLException | ClassNotFoundException sqle){
		sqle.printStackTrace();
	}	catch (Exception e) {
		e.printStackTrace();
	}
	DecimalFormat df = new DecimalFormat("#.##");
	df.format(total_cost);
	 System.out.println("The total cost of your order is £" + total_cost);
		GenerateRegisteredCustomers.getGenerateRegisteredCustomers();
		double credit = GenerateRegisteredCustomers.getGenerateRegisteredCustomers().get_credit_limit(arrayelement);
		System.out.println("You currently have £" + credit );
			credit = credit - total_cost;
			System.out.println("Your remaining credit is now £");
			System.out.format("%.2f%n", credit);
			
		}

	
		}
		

