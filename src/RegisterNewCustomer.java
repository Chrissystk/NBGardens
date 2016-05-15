import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;


public class RegisterNewCustomer {
	
	private JFrame registerCustomer;
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
	
	private boolean wantcredit;
	public int customer_ID;
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/Customers";
	static final String USER = "root";
	static final String PASSWORD = "Callash0825";
	
	public void addCustomer() {
		
	}
	public RegisterNewCustomer(){
		initialise();
		getRegDetails();
	}
		private void initialise(){
			registerCustomer = new JFrame();
			registerCustomer.getContentPane().setFont(new Font("Arial", Font.BOLD, 14));
			registerCustomer.setBounds(100, 100, 792, 407);
			registerCustomer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			registerCustomer.getContentPane().setLayout(null);
			
			JLabel lblNbGardensCall = new JLabel("NB Gardens Call Centre");
			lblNbGardensCall.setBounds(22, 26, 725, 38);
			lblNbGardensCall.setFont(new Font("Arial", Font.BOLD, 18));
			registerCustomer.getContentPane().add(lblNbGardensCall);
			
			JLabel lblRegisterNewCustomer = new JLabel("Register New Customer");
			lblRegisterNewCustomer.setBounds(56, 56, 215, 16);
			registerCustomer.getContentPane().add(lblRegisterNewCustomer);
			
			JLabel lblTitle = new JLabel("Title");
			lblTitle.setBounds(42, 108, 106, 16);
			registerCustomer.getContentPane().add(lblTitle);
			
			JLabel lblForename = new JLabel("Forename");
			lblForename.setBounds(42, 145, 106, 16);
			registerCustomer.getContentPane().add(lblForename);
			
			JLabel lblSurname = new JLabel("Surname");
			lblSurname.setBounds(42, 187, 106, 16);
			registerCustomer.getContentPane().add(lblSurname);
			
			JLabel lblPostcode = new JLabel("postcode");
			lblPostcode.setBounds(42, 226, 106, 16);
			registerCustomer.getContentPane().add(lblPostcode);
			
			JLabel lblAddress = new JLabel("Address");
			lblAddress.setBounds(42, 261, 106, 16);
			registerCustomer.getContentPane().add(lblAddress);
			
			JLabel lblDeliveryPostcodeIf = new JLabel("Delivery Postcode if different");
			lblDeliveryPostcodeIf.setBounds(297, 108, 232, 16);
			registerCustomer.getContentPane().add(lblDeliveryPostcodeIf);
			
			JLabel lblDeliveryAddressIf = new JLabel("Delivery Address if different");
			lblDeliveryAddressIf.setBounds(297, 166, 232, 16);
			registerCustomer.getContentPane().add(lblDeliveryAddressIf);
			
			JLabel lblDob = new JLabel("DOB");
			lblDob.setBounds(42, 291, 106, 16);
			registerCustomer.getContentPane().add(lblDob);
			
			JLabel lblEmail = new JLabel("Email");
			lblEmail.setBounds(42, 323, 106, 16);
			registerCustomer.getContentPane().add(lblEmail);
			
			JLabel lblPhone = new JLabel("Phone");
			lblPhone.setBounds(42, 351, 106, 16);
			registerCustomer.getContentPane().add(lblPhone);
			
			textField = new JTextField();
			textField.setBounds(120, 103, 151, 26);
			registerCustomer.getContentPane().add(textField);
			textField.setColumns(10);
			
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(120, 140, 151, 26);
			registerCustomer.getContentPane().add(textField_1);
			
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(120, 182, 151, 26);
			registerCustomer.getContentPane().add(textField_2);
			
			textField_3 = new JTextField();
			textField_3.setColumns(10);
			textField_3.setBounds(120, 221, 151, 26);
			registerCustomer.getContentPane().add(textField_3);
			
			textField_4 = new JTextField();
			textField_4.setColumns(10);
			textField_4.setBounds(120, 254, 409, 26);
			registerCustomer.getContentPane().add(textField_4);
			
			textField_5 = new JTextField();
			textField_5.setColumns(10);
			textField_5.setBounds(120, 289, 151, 26);
			registerCustomer.getContentPane().add(textField_5);
			
			textField_6 = new JTextField();
			textField_6.setColumns(10);
			textField_6.setBounds(120, 319, 151, 26);
			registerCustomer.getContentPane().add(textField_6);
			
			textField_7 = new JTextField();
			textField_7.setColumns(10);
			textField_7.setBounds(120, 351, 151, 26);
			registerCustomer.getContentPane().add(textField_7);
			
			textField_8 = new JTextField();
			textField_8.setColumns(10);
			textField_8.setBounds(297, 140, 151, 26);
			registerCustomer.getContentPane().add(textField_8);
			
			textField_9 = new JTextField();
			textField_9.setColumns(10);
			textField_9.setBounds(297, 194, 361, 26);
			registerCustomer.getContentPane().add(textField_9);
			registerCustomer.setVisible(true);
			
			
		}
			
	
	public void getRegDetails(){
		
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Credit?");
		chckbxNewCheckBox.setBounds(355, 222, 128, 23);
		registerCustomer.getContentPane().add(chckbxNewCheckBox);
		if (chckbxNewCheckBox.isSelected())
		wantcredit = true;
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.setBounds(420, 318, 117, 29);
		registerCustomer.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registerCustomer.setVisible(false);
				HomeScreen homescreen = new HomeScreen();
				homescreen.CustomersAccount();
			}
		});
		btnNewButton_1.setBounds(619, 322, 128, 21);
		registerCustomer.getContentPane().add(btnNewButton_1);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String	title = textField.getText();
			String	forename = textField_1.getText();
			String	surname = textField_2.getText();
			String	postcode = textField_3.getText();
			String	address = textField_4.getText();
			String	dOB = textField_5.getText();
			String	email = textField_6.getText();
			String	phone = textField_7.getText();
			String	deliveryPostcode = textField_8.getText();
			String	deliveryAddress = textField_9.getText();
				if (deliveryPostcode.isEmpty()){
					deliveryPostcode = postcode;
					deliveryAddress = address;
				}
				int credit = 0;
				System.out.println(title);
				if (title.isEmpty() || forename.isEmpty() || surname.isEmpty() || postcode.isEmpty() || dOB.isEmpty() || phone.isEmpty()){
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
					textField_5.setText("");
					textField_6.setText("");
					textField_7.setText("");
					textField_8.setText("");
					chckbxNewCheckBox.setSelected(false);
					}
				else {
				AddToDatabase(title, forename, surname, postcode, address, deliveryPostcode, deliveryAddress, dOB, email, phone, credit);
				CustomerAccountPage customeraccount = new CustomerAccountPage();
				customeraccount.ShowAccountDetails(customer_ID);
				}
			}
		});
		
	
}
		
		public void AddToDatabase(String title, String forename, String surname, String postcode, String address, String deliveryPostcode, String deliveryAddress, String dOB, String email, String phone, float credit){
		
			if (email.isEmpty())
				email = "none";
			Connection conn = null;
			Statement stmt = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			stmt = conn.createStatement();
			String sq13 = "SELECT accountNumber, title, forename, surname, postcode, address, deliveryPostcode, deliveryAddress, dOB, email, phone, credit FROM Customers.Registered";
			ResultSet rs = stmt.executeQuery(sq13);
			rs.last();
			int account_num = rs.getRow() + 1;
			System.out.println(account_num);
			customer_ID = account_num;
			String sq12 = "INSERT INTO Customers.Registered " + "VALUES ('" + account_num + "', '" + title + "', '" + forename + "', '" + surname + "', '" + postcode + "', '" + address + "', '" + deliveryPostcode + "', '" + deliveryAddress + "', '" + dOB + "', '" + email + "', '" + phone + "', '" + credit + "')";
			stmt.executeUpdate(sq12);
			
			
		
		conn.close();
	}catch(SQLException | ClassNotFoundException sqle){
		sqle.printStackTrace();
	}	catch (Exception e) {
		e.printStackTrace();
		
	}
		}
	}

