import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class UpdateAccount {
	
	private JFrame account;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/Customers";
	static final String USER = "root";
	static final String PASSWORD = "Callash0825";
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	
	public UpdateAccount(){
		initialise();
		
	}
	
	public void AccountUpdate(int customer_ID){
		
		FindCustomerDetails(customer_ID);
		JButton btnNewButton = new JButton("Update");
		btnNewButton.setBounds(624, 200, 149, 29);
		account.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateDatabase(customer_ID);
				account.setVisible(false);
				CustomerAccountPage customerAccount = new CustomerAccountPage();
				customerAccount.ShowAccountDetails(customer_ID);
			}
		});
		
		
		
		JButton btnOrder = new JButton("Cancel");
		btnOrder.setBounds(656, 334, 117, 29);
		account.getContentPane().add(btnOrder);
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				account.setVisible(false);
				CustomerAccountPage customerAccount = new CustomerAccountPage();
				customerAccount.getcustomerdetails(customer_ID);
			}
		});
		
	}

	private void initialise(){
		account = new JFrame();
		account.getContentPane().setFont(new Font("Arial", Font.BOLD, 14));
		account.setBounds(100, 100, 792, 407);
		account.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		account.getContentPane().setLayout(null);
		
		JLabel lblNbGardensCall = new JLabel("NB Gardens Call Centre");
		lblNbGardensCall.setBounds(22, 26, 725, 38);
		lblNbGardensCall.setFont(new Font("Arial", Font.BOLD, 18));
		account.getContentPane().add(lblNbGardensCall);
		
		JLabel lblCustomerAccountDetails = new JLabel("Customer Account Details");
		lblCustomerAccountDetails.setBounds(74, 76, 198, 16);
		account.getContentPane().add(lblCustomerAccountDetails);
		
		JLabel lblAccountNumber = new JLabel("Account Number");
		lblAccountNumber.setBounds(22, 121, 117, 16);
		account.getContentPane().add(lblAccountNumber);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(22, 149, 117, 16);
		account.getContentPane().add(lblTitle);
		
		JLabel lblForename = new JLabel("Forename");
		lblForename.setBounds(22, 177, 117, 16);
		account.getContentPane().add(lblForename);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setBounds(22, 205, 117, 16);
		account.getContentPane().add(lblSurname);
		
		JLabel lblPostcode = new JLabel("Postcode");
		lblPostcode.setBounds(22, 233, 117, 16);
		account.getContentPane().add(lblPostcode);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(22, 261, 117, 16);
		account.getContentPane().add(lblAddress);
		
		JLabel lblDeliveryPostcode = new JLabel("Delivery Postcode");
		lblDeliveryPostcode.setBounds(22, 289, 117, 16);
		account.getContentPane().add(lblDeliveryPostcode);
		
		JLabel lblDeliveryAddress = new JLabel("Delivery Address");
		lblDeliveryAddress.setBounds(22, 317, 117, 16);
		account.getContentPane().add(lblDeliveryAddress);
		
		JLabel lblDob = new JLabel("DOB");
		lblDob.setBounds(339, 121, 117, 16);
		account.getContentPane().add(lblDob);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(339, 149, 117, 16);
		account.getContentPane().add(lblEmail);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(339, 177, 117, 16);
		account.getContentPane().add(lblPhone);
		
		JLabel lblCredit = new JLabel("Credit");
		lblCredit.setBounds(339, 205, 117, 16);
		account.getContentPane().add(lblCredit);
		account.setVisible(true);
		
	
		
		textField = new JTextField();
		textField.setBounds(142, 147, 130, 26);
		account.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(142, 177, 130, 26);
		account.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(142, 205, 130, 26);
		account.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(142, 228, 130, 26);
		account.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(142, 256, 443, 26);
		account.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(142, 284, 130, 26);
		account.getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(142, 312, 443, 26);
		account.getContentPane().add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(410, 116, 130, 26);
		account.getContentPane().add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(410, 144, 130, 26);
		account.getContentPane().add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(410, 172, 130, 26);
		account.getContentPane().add(textField_9);
		
		account.setVisible(true);
		
		
		
	}
	
	public void FindCustomerDetails(int customerID){
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
		stmt = conn.createStatement();
		String sq12 = "SELECT accountNumber, title, forename, surname, postcode, address, deliveryPostcode, deliveryAddress, dOB, email, phone, credit FROM Customers.Registered";
		ResultSet rs = stmt.executeQuery(sq12);
		while (rs.next()) {
			if (customerID==rs.getInt("accountNumber")){
				JLabel lblNewLabel = new JLabel(rs.getString("accountNumber"));
				lblNewLabel.setBounds(170, 121, 61, 16);
				account.getContentPane().add(lblNewLabel);
				
				JLabel lblNewLabel_1 = new JLabel(rs.getString("credit"));
				lblNewLabel_1.setBounds(410, 205, 110, 16);
				account.getContentPane().add(lblNewLabel_1);
				account.setVisible(true);
				
				textField.setText(rs.getString("title"));
				textField_1.setText(rs.getString("forename"));
				textField_2.setText(rs.getString("surname"));
				textField_3.setText(rs.getString("postcode"));
				textField_4.setText(rs.getString("address"));
				textField_5.setText(rs.getString("deliveryPostcode"));
				textField_6.setText(rs.getString("deliveryAddress"));
				textField_7.setText(rs.getString("dOB"));
				textField_8.setText(rs.getString("email"));
				textField_9.setText(rs.getString("phone"));
				
			}
		}
		
		conn.close();
	}catch(SQLException | ClassNotFoundException sqle){
		sqle.printStackTrace();
	}	catch (Exception e) {
		e.printStackTrace();
		
	}
	}
	
	public void UpdateDatabase(int customer_ID){
		Connection conn1 = null;
		Statement stmt1 = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		conn1 = DriverManager.getConnection(DB_URL, USER, PASSWORD);
		stmt1 = conn1.createStatement();
		
		String sq14 = "UPDATE Customers.Registered SET title = '"+ textField.getText() +"', forename = '"+ textField_1.getText()+"', surname = '"+ textField_2.getText() +"' +"
				+ ", postcode = '"+ textField_3.getText() +"', address'"+ textField_4.getText() +"', deliveryPostcode = '"+ textField_5.getText() +"', deliveryAddress = '"+ textField_6.getText() +"' +"
						+ ", dOB = '"+ textField_7.getText()+"', email = '"+ textField_8.getText() +"', phone = '"+textField_9.getText()+"' WHERE accountNumber = '"+ customer_ID +"'";
		
		stmt1.executeUpdate(sq14);
		conn1.close();
	}catch(SQLException | ClassNotFoundException sqle){
		sqle.printStackTrace();
	}	catch (Exception e) {
		e.printStackTrace();
		
	}
		
	}
	
	}

