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
		while (rs.next()) {
			int id = rs.getInt("idproducts");
			String product_name = rs.getString("product_name");
			String keywords = rs.getString("keywords");
			int num_stock = rs.getInt("num_stock");
			float price = rs.getFloat("price");
			System.out.println("ID: " + id + ", product name: " + product_name + ", keyword: "
					+ keywords + ", num_stock: " + num_stock + " and price: " + price);
		}
		
		System.out.println("Do you know the product number?");
		Scanner scan7 = new Scanner(System.in);
		String id_known = scan7.next();
		if (id_known.equalsIgnoreCase("yes")){
			System.out.println("What is the product number?");
			Scanner scan8 = new Scanner(System.in);
			prod_id = scan8.nextInt();
			String sq11 = "SELECT idproducts, product_name, keywords, num_stock, price FROM products FOR "
		}
		
	}
	catch(SQLException | ClassNotFoundException sqle){
		sqle.printStackTrace();
	}	catch (Exception e) {
		e.printStackTrace();
	}
	}
	
}