import java.sql.*;
import java.util.Scanner;


public class product{
	
	public product(){}
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/nb";
	static final String USER = "root";
	static final String PASSWORD = "consulting";
		public void ReadDatabase(){
			Connection conn = null;
			Statement stmt = null;
			
	try {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Connecting to database...");
		conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
		
		System.out.println("Creating statement...");
		stmt = conn.createStatement();
		String sq12 = "SELECT idproducts, product_name, keywords, num_stock, price FROM products";
		ResultSet rs = stmt.executeQuery(sq12);
		boolean ordering = true;

		while(ordering == true){
			boolean product_found = false;
		System.out.println("Do you want to search for the order by product number, product name or by keywords?");
		System.out.println("Type 1 for productid, 2 for product name or 3 for keywords");
		Scanner scan7 = new Scanner(System.in);
		Scanner scan9 = new Scanner(System.in);
		Scanner scan8 = new Scanner(System.in);
		int searchby = scan8.nextInt();
		if (searchby == 1){
			System.out.println("What is the product number?");
			int prod_id = scan8.nextInt();
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
			}
		}
		}
		else if (searchby == 2){
		
				System.out.println("What is the product name?");
				String prod_name = scan9.nextLine();
				while (rs.next()) {
				int id = rs.getInt("idproducts");
				String product_name = rs.getString("product_name");
				if(product_name.equalsIgnoreCase(prod_name)){
					product_found = true;
					System.out.println("Product Found!!!");
					String keywords = rs.getString("keywords");
					int num_stock = rs.getInt("num_stock");
					float price = rs.getFloat("price");					
		System.out.println("ID: " + id + ", product name: " + product_name + ", keyword: "
							+ keywords + ", num_stock: " + num_stock + " and price: " + price);
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
	}

	else {
		System.out.println("Error incorrect search parameter typed");
	}
		if(product_found == true){
			{
		}
		System.out.println("Do you wish to add another item to your order or try again?");
		String answer = scan7.next();
		if(answer.equalsIgnoreCase("yes")){
			System.out.println("More orders being placed");
		} else {
				ordering = false;
			}
		}
		}
	}
	catch(SQLException | ClassNotFoundException sqle){
		sqle.printStackTrace();
	}	catch (Exception e) {
		e.printStackTrace();
	}
	}
	
}