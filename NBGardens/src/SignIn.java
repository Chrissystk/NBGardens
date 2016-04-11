import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class SignIn {

	
	public void SignIn(){}
		
	
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/nb";
	static final String USER = "root";
	static final String PASSWORD = "consulting";
		
	public void FindUser(){
		Connection conn = null;
		Statement stmt = null;
		
			
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to database NB ...");
			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			stmt = conn.createStatement();
			String sq12 = "SELECT idemployees, Forename, Surname  FROM employees.employees";
			boolean account_found = false;
			while (account_found == false){
			System.out.println("Sign in please give your forename");
			Scanner scan11 = new Scanner(System.in);
			String forename = scan11.next();
			System.out.println("Please give your Surname please");
			String surname = scan11.next();
			ResultSet rs = stmt.executeQuery(sq12);
			
			while (rs.next()) {
				int id = rs.getInt("idemployees");
				String userforename = rs.getString("Forename");
				String usersurname = rs.getString("Surname");
				if (userforename.equalsIgnoreCase(forename))
					{
					if (usersurname.equalsIgnoreCase(surname)){
					
					
				System.out.println("Welcome " + userforename + " " + usersurname);
				account_found = true;
				}
					}
				if(account_found == false){
					System.out.println("Error employee name not registered please try again!");
					}
				}
			}
			conn.close();
			}catch(SQLException | ClassNotFoundException sqle){
			sqle.printStackTrace();
		}	catch (Exception e) {
			e.printStackTrace();
		}
	
}
}
