import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerAccountPage {

	private JFrame account;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/Customers";
	static final String USER = "root";
	static final String PASSWORD = "Callash0825";
	
	public CustomerAccountPage(){
		initialise();
	}
	
	public void ShowAccountDetails(int customer_ID){
		getcustomerdetails(customer_ID);
		JButton btnNewButton = new JButton("Update Account");
		btnNewButton.setBounds(567, 144, 149, 29);
		account.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				account.setVisible(false);
				UpdateAccount updateaccount = new UpdateAccount();
				updateaccount.AccountUpdate(customer_ID);
				
			}
		});
		
		
		JButton btnOrder = new JButton("Order");
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				account.setVisible(false);
				Ordering wantorder =  new Ordering();
				wantorder.CreateOrder(customer_ID);
			}
			
			
		});
		btnOrder.setBounds(592, 220, 117, 29);
		account.getContentPane().add(btnOrder);
		account.setVisible(true);
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
		
		
	
	
		
		
	}
	
	public void getcustomerdetails(int customerID){
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
				lblNewLabel.setBounds(169, 121, 103, 16);
				account.getContentPane().add(lblNewLabel);
				
				JLabel label = new JLabel(rs.getString("title"));
				label.setBounds(169, 149, 103, 16);
				account.getContentPane().add(label);
				
				JLabel label_1 = new JLabel(rs.getString("forename"));
				label_1.setBounds(169, 177, 103, 16);
				account.getContentPane().add(label_1);
				
				JLabel label_2 = new JLabel(rs.getString("surname"));
				label_2.setBounds(169, 205, 103, 16);
				account.getContentPane().add(label_2);
				
				JLabel label_3 = new JLabel(rs.getString("postcode"));
				label_3.setBounds(169, 233, 103, 16);
				account.getContentPane().add(label_3);
				
				JLabel label_4 = new JLabel(rs.getString("address"));
				label_4.setBounds(169, 261, 287, 16);
				account.getContentPane().add(label_4);
				
				JLabel label_5 = new JLabel(rs.getString("deliveryPostcode"));
				label_5.setBounds(169, 289, 93, 16);
				account.getContentPane().add(label_5);
				
				JLabel label_6 = new JLabel(rs.getString("deliveryAddress"));
				label_6.setBounds(169, 317, 287, 16);
				account.getContentPane().add(label_6);
				
				JLabel label_7 = new JLabel(rs.getString("dOB"));
				label_7.setBounds(452, 121, 103, 16);
				account.getContentPane().add(label_7);
				
				JLabel label_8 = new JLabel(rs.getString("email"));
				label_8.setBounds(452, 149, 103, 16);
				account.getContentPane().add(label_8);
				
				JLabel label_9 = new JLabel(rs.getString("phone"));
				label_9.setBounds(452, 177, 103, 16);
				account.getContentPane().add(label_9);
				
				JLabel label_10 = new JLabel(rs.getString("credit"));
				label_10.setBounds(452, 205, 103, 16);
				account.getContentPane().add(label_10);
				
				
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

