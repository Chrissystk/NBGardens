import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class HomeScreen {
	
	private JFrame home;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public int customer_ID; 
	public boolean customerfound;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/Customers";
	static final String USER = "root";
	static final String PASSWORD = "Callash0825";
	
	public HomeScreen(){
		initialise();
	}
	private void initialise(){
		home = new JFrame();
		home.getContentPane().setFont(new Font("Arial", Font.BOLD, 14));
		home.setBounds(100, 100, 792, 407);
		home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		home.getContentPane().setLayout(null);
		
		JLabel lblNbGardensCall = new JLabel("NB Gardens Call Centre");
		lblNbGardensCall.setBounds(22, 26, 725, 38);
		lblNbGardensCall.setFont(new Font("Arial", Font.BOLD, 18));
		home.getContentPane().add(lblNbGardensCall);
		
		JLabel lblSigninToRegistered = new JLabel("Signin to Registered Customers account or click create new account");
		lblSigninToRegistered.setBounds(6, 76, 780, 29);
		lblSigninToRegistered.setFont(new Font("Arial", Font.BOLD, 14));
		lblSigninToRegistered.setHorizontalAlignment(SwingConstants.CENTER);
		home.getContentPane().add(lblSigninToRegistered);
		
		JLabel lblRegisteredCustomersSignin = new JLabel("Registered Customers Signin using either");
		lblRegisteredCustomersSignin.setBounds(73, 129, 406, 16);
		home.getContentPane().add(lblRegisteredCustomersSignin);
		
		textField = new JTextField();
		textField.setBounds(217, 157, 130, 26);
		home.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblAccountNumber = new JLabel("Account Number");
		lblAccountNumber.setBounds(66, 162, 117, 16);
		home.getContentPane().add(lblAccountNumber);
		
		JLabel lblOr = new JLabel("or");
		lblOr.setBounds(189, 209, 94, 16);
		home.getContentPane().add(lblOr);
		
		JLabel lblName = new JLabel("Postcode");
		lblName.setBounds(66, 251, 117, 16);
		home.getContentPane().add(lblName);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setBounds(66, 290, 117, 16);
		home.getContentPane().add(lblSurname);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(217, 246, 130, 26);
		home.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(217, 285, 130, 26);
		home.getContentPane().add(textField_2);
		
		
	}
		
	public void CustomersAccount(){
		JButton btnSignin = new JButton("Sign In");
		btnSignin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String account_num = textField.getText();
				String postcode = textField_1.getText();
				String surname = textField_2.getText();
				if (!account_num.isEmpty()) 
					FindAccount(account_num, postcode, surname);
				else if(!postcode.isEmpty() && !surname.isEmpty())
					FindAccount(account_num, postcode, surname);
					
				else
					customerfound = false;
				
				if (customerfound==true){
					home.setVisible(false);
					CustomerAccountPage customeraccountpage = new CustomerAccountPage();
					customeraccountpage.ShowAccountDetails(customer_ID);
				}
				else{
					textField.setText(null);
					textField_1.setText(null);
					textField_2.setText(null);
					JLabel lblIncorrectForenameOr = new JLabel("Incorrect Forename or Surname entered please try again");
					lblIncorrectForenameOr.setFont(new Font("Arial", Font.PLAIN, 14));
					lblIncorrectForenameOr.setHorizontalAlignment(SwingConstants.CENTER);
					lblIncorrectForenameOr.setForeground(Color.RED);
					lblIncorrectForenameOr.setBounds(6, 62, 780, 16);
					home.getContentPane().add(lblIncorrectForenameOr);
				}
			}
		});
		btnSignin.setBounds(424, 246, 117, 29);
		home.getContentPane().add(btnSignin);
		
		JButton btnRegisterNewCustomer = new JButton("Register New Customer");
		btnRegisterNewCustomer.setBounds(533, 157, 196, 29);
		home.getContentPane().add(btnRegisterNewCustomer);
		home.setVisible(true);
		btnRegisterNewCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home.setVisible(false);
				RegisterNewCustomer newcustomer = new RegisterNewCustomer();
				newcustomer.addCustomer();
			}
		});
		
}
	public void FindAccount(String account_num, String postcode, String surname){
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
		stmt = conn.createStatement();
		String sq12 = "SELECT accountNumber, title, forename, surname, postcode, address, deliveryPostcode, deliveryAddress, dOB, email, phone, credit FROM Customers.Registered";
		ResultSet rs = stmt.executeQuery(sq12);
		customerfound = false;
		while (rs.next()) {
		if (account_num.equalsIgnoreCase(rs.getString("accountNumber"))){
			customerfound = true;
			customer_ID = rs.getInt("accountNumber");

		}
		
		else
			if (surname.equalsIgnoreCase(rs.getString("surname")) && postcode.equalsIgnoreCase(rs.getString("postcode"))){
				customerfound = true;
				customer_ID = rs.getInt("accountNumber");	
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
	
	
	