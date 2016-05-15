import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class PaymentPage {
	
	private JFrame payment;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/Customers";
	static final String USER = "root";
	static final String PASSWORD = "Callash0825";
	private JList<Object> list;
	private DefaultListModel<Object> model; 
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private double totalcost;
	private int customerID;
	private double credit;

	public PaymentPage(){
		
	}
	public void Basket1(Payment order){
		 GenerateOrderList.getGeneratedOrderList();
	}
	
	public void getpayment(int customerid){
		customerID = customerid;
		FindCustomerDetails(customerID);
		initialise();
		
	}
	
	private void initialise(){
		payment = new JFrame();
		payment.getContentPane().setFont(new Font("Arial", Font.BOLD, 14));
		payment.setBounds(100, 100, 792, 407);
		payment.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		payment.getContentPane().setLayout(null);
		
	
		JLabel lblNbGardensCall = new JLabel("NB Gardens Call Centre");
		lblNbGardensCall.setBounds(22, 26, 725, 38);
		lblNbGardensCall.setFont(new Font("Arial", Font.BOLD, 18));
		payment.getContentPane().add(lblNbGardensCall);
		
		
		model = new DefaultListModel<>();
		GenerateOrderList.getGeneratedOrderList();
		ArrayList<Payment> orders = GenerateOrderList.getGeneratedOrderList().getOrder();
		for (int i = 0; i<orders.size(); i++){
			String ordering = orders.get(i).getProductid() + ", " + orders.get(i).getProductName() + ", " + orders.get(i).getQuantity() + ", £" + orders.get(i).getCost();
			model.addElement(ordering);
			totalcost += orders.get(i).getCost();
			System.out.println(ordering);
		}
		JScrollPane pane = new JScrollPane();
		pane.setBounds(22, 76, 317, 228);
		payment.getContentPane().add(pane);
		payment.getContentPane().add(pane);
		list = new JList<Object>(model);
		pane.setViewportView(list);
		
		
		JButton btnPayByCredit = new JButton("Pay By Credit");
		btnPayByCredit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(credit >= totalcost){
				GenerateOrderList.getGeneratedOrderList();
				ArrayList<Payment> orders = GenerateOrderList.getGeneratedOrderList().getOrder();
				for (int i = 0; i<orders.size(); i++){
					orders.remove(i);
				}
				payment.setVisible(false);
				HomeScreen homescreen = new HomeScreen();
				homescreen.CustomersAccount();
			}
			}
		});
		btnPayByCredit.setBounds(630, 76, 117, 29);
		payment.getContentPane().add(btnPayByCredit);
		
		JLabel lblNewLabel = new JLabel("Credit available = £" + String.valueOf(credit));
		lblNewLabel.setBounds(401, 76, 229, 29);
		payment.getContentPane().add(lblNewLabel);
		
		JLabel lblTotalCost = new JLabel("Total Cost = £" + String.valueOf(totalcost));
		lblTotalCost.setBounds(42, 333, 296, 16);
		payment.getContentPane().add(lblTotalCost);
		
		JLabel lblCardPayment = new JLabel("Card Payment");
		lblCardPayment.setBounds(529, 135, 117, 16);
		payment.getContentPane().add(lblCardPayment);
		
		JLabel lblNameAsAppears = new JLabel("Name as appears on card");
		lblNameAsAppears.setBounds(374, 173, 172, 16);
		payment.getContentPane().add(lblNameAsAppears);
		
		JLabel lblCardNumber = new JLabel("Card Number");
		lblCardNumber.setBounds(374, 247, 117, 16);
		payment.getContentPane().add(lblCardNumber);
		
		JLabel lblCardType = new JLabel("Card Type");
		lblCardType.setBounds(374, 211, 117, 16);
		payment.getContentPane().add(lblCardType);
		
		JLabel lblExpiryDatemmyy = new JLabel("Expiry Date (mm/yy)");
		lblExpiryDatemmyy.setBounds(374, 287, 155, 16);
		payment.getContentPane().add(lblExpiryDatemmyy);
		
		JLabel lblCsv = new JLabel("CSV");
		lblCsv.setBounds(374, 321, 117, 16);
		payment.getContentPane().add(lblCsv);
		
		textField = new JTextField();
		textField.setBounds(558, 168, 209, 26);
		payment.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(558, 206, 209, 26);
		textField_1.setColumns(10);
		payment.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(558, 242, 209, 26);
		textField_2.setColumns(10);
		payment.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(558, 282, 106, 26);
		textField_3.setColumns(10);
		payment.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setBounds(558, 316, 58, 26);
		textField_4.setColumns(10);
		payment.getContentPane().add(textField_4);
		
		JButton btnPayByCard = new JButton("Pay By Card");
		btnPayByCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().isEmpty() || textField_1.getText().isEmpty() || textField_2.getText().isEmpty() || textField_4.getText().isEmpty() || textField_3.getText().isEmpty()){
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
				}
				else {
					GenerateOrderList.getGeneratedOrderList();
					ArrayList<Payment> orders = GenerateOrderList.getGeneratedOrderList().getOrder();
					for (int i = 0; i<orders.size(); i++){
						orders.remove(i);
					}
					payment.setVisible(false);
					HomeScreen homescreen = new HomeScreen();
					homescreen.CustomersAccount();
				} 
					
			}
		});
		btnPayByCard.setBounds(650, 333, 117, 29);
		payment.getContentPane().add(btnPayByCard);
		
		JButton btnCancelOrder = new JButton("Cancel Order");
		btnCancelOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GenerateOrderList.getGeneratedOrderList();
				ArrayList<Payment> orders = GenerateOrderList.getGeneratedOrderList().getOrder();
				for (int i = 0; i<orders.size(); i++){
					orders.remove(i);
				}
				payment.setVisible(false);
				HomeScreen homescreen = new HomeScreen();
				homescreen.CustomersAccount();
			}
		});
		btnCancelOrder.setBounds(21, 350, 190, 29);
		payment.getContentPane().add(btnCancelOrder);
payment.setVisible(true);
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
				credit = rs.getDouble("credit");
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



