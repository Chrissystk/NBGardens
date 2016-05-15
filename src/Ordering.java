import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;


public class Ordering {
	private JFrame ordering;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/products";
	static final String USER = "root";
	static final String PASSWORD = "Callash0825";
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public ArrayList<Payment> orders = new ArrayList<Payment>();
	private JTextField textField_3;
	private JList<Object> list;
	private DefaultListModel<Object> model; 
	private int customerid;
	
	
	public Ordering(){
		
		initialise();
	}
	
	public void addOrder(Payment order){
		GenerateOrderList.getGeneratedOrderList().addOrder(order);
		
	}
	
	public void CreateOrder(int customer_ID){
		customerid = customer_ID;
		
		JLabel lblNewLabel = new JLabel(String.valueOf(customer_ID));
		lblNewLabel.setBounds(662, 38, 61, 16);
		ordering.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Add to Basket");
		btnNewButton.setBounds(485, 248, 117, 29);
		ordering.getContentPane().add(btnNewButton);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(285, 248, 117, 29);
		ordering.getContentPane().add(btnSearch);
		ordering.setVisible(true);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String prod_ID = textField.getText();
				String product_name = textField_1.getText();
				String keywords = textField_2.getText();
				String quantity = textField_3.getText();
				
				if(prod_ID.isEmpty() && product_name.isEmpty() && keywords.isEmpty()){
					
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					
				}
				else {
					if(prod_ID.isEmpty())
						prod_ID = "-1";
					if (product_name.isEmpty())
						product_name = "none";
					if (keywords.isEmpty())
						keywords = "none";
					if(quantity.isEmpty())
						quantity="1";
					FindProduct(Integer.valueOf(prod_ID), product_name, keywords, Integer.valueOf(quantity));
					
				}
			}
				
			});	
					
					btnNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
						
						
						String prod = list.getSelectedValue().toString();
						String[] parts = prod.split(",");
						for (int i=0; i<4; i++){
						System.out.println(parts[i]);
						}
						addOrder(new Payment(Integer.valueOf(parts[0]), parts[1], Integer.valueOf(parts[2]), Double.valueOf(parts[3])));
						
					
						
				
							
						}
			
		
		});
		
		JButton btnNewButton_1 = new JButton("Go To Basket");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ordering.setVisible(false);
				Basket basket = new Basket();
				basket.CheckBasket(customer_ID);
			}
		});
		btnNewButton_1.setBounds(91, 321, 117, 29);
		ordering.getContentPane().add(btnNewButton_1);
		
	}
	
private void initialise(){
	ordering = new JFrame();
	ordering.getContentPane().setFont(new Font("Arial", Font.BOLD, 14));
	ordering.setBounds(100, 100, 792, 407);
	ordering.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	ordering.getContentPane().setLayout(null);
	
	JLabel lblNbGardensCall = new JLabel("NB Gardens Call Centre");
	lblNbGardensCall.setBounds(22, 26, 725, 38);
	lblNbGardensCall.setFont(new Font("Arial", Font.BOLD, 18));
	ordering.getContentPane().add(lblNbGardensCall);
	
	JLabel lblCustomerorderingDetails = new JLabel("Customer ordering Details");
	lblCustomerorderingDetails.setBounds(74, 76, 198, 16);
	ordering.getContentPane().add(lblCustomerorderingDetails);
	
	JLabel lblorderingNumber = new JLabel("Account Number");
	lblorderingNumber.setBounds(526, 38, 117, 16);
	ordering.getContentPane().add(lblorderingNumber);
	
	
	JLabel lblProductid = new JLabel("Product_ID");
	lblProductid.setBounds(32, 117, 111, 16);
	ordering.getContentPane().add(lblProductid);
	
	JLabel lblProductName = new JLabel("Product Name");
	lblProductName.setBounds(32, 164, 111, 16);
	ordering.getContentPane().add(lblProductName);
	
	JLabel lblKeywords = new JLabel("Keywords");
	lblKeywords.setBounds(32, 215, 111, 16);
	ordering.getContentPane().add(lblKeywords);
	
	textField = new JTextField();
	textField.setBounds(141, 112, 258, 26);
	ordering.getContentPane().add(textField);
	textField.setColumns(10);
	
	textField_1 = new JTextField();
	textField_1.setColumns(10);
	textField_1.setBounds(141, 159, 258, 26);
	ordering.getContentPane().add(textField_1);
	
	textField_2 = new JTextField();
	textField_2.setColumns(10);
	textField_2.setBounds(141, 210, 258, 26);
	ordering.getContentPane().add(textField_2);
	
	model = new DefaultListModel<>();
	list = new JList<Object>(model);
	JScrollPane pane = new JScrollPane(list);
	pane.setBounds(485, 91, 284, 145);
	ordering.getContentPane().add(pane);
	ordering.add(pane);
	ordering.setVisible(true);
	

	
	JButton btnNewSearch = new JButton("New Search");
	btnNewSearch.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			
			model.removeAllElements();
			textField.setText("");
			textField_1.setText("");
			textField_2.setText("");
		}
	});
	btnNewSearch.setBounds(642, 248, 117, 29);
	ordering.getContentPane().add(btnNewSearch);
	

	
	JButton btnCancelOrder = new JButton("Cancel Order");
	btnCancelOrder.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			GenerateOrderList.getGeneratedOrderList();
			ArrayList<Payment> orders = GenerateOrderList.getGeneratedOrderList().getOrder();
			for (int i = 0; i<orders.size(); i++){
				orders.remove(i);
			}
			model.removeAllElements();
			ordering.setVisible(false);
			HomeScreen homescreen = new HomeScreen();
			homescreen.CustomersAccount();
		}
	});
	btnCancelOrder.setBounds(297, 321, 117, 29);
	ordering.getContentPane().add(btnCancelOrder);
	
	JButton btnBackToAccount = new JButton("Back to Account Details");
	btnBackToAccount.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			ordering.setVisible(false);
			CustomerAccountPage accountpage = new CustomerAccountPage();
			accountpage.getcustomerdetails(customerid);
		}
	});
	btnBackToAccount.setBounds(526, 321, 197, 29);
	ordering.getContentPane().add(btnBackToAccount);
	
	JLabel lblQuantity = new JLabel("Quantity");
	lblQuantity.setBounds(32, 267, 61, 16);
	ordering.getContentPane().add(lblQuantity);
	
	textField_3 = new JTextField();
	textField_3.setBounds(109, 262, 51, 26);
	ordering.getContentPane().add(textField_3);
	textField_3.setColumns(10);
	
	
	ordering.setVisible(true);
}

private void FindProduct(int prod_id, String prod_name, String keywords2, int quantity) {
	Connection conn = null;
	Statement stmt = null;
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
	
	conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
	stmt = conn.createStatement();
	String sq12 = "SELECT idproducts, product_name, keywords, num_stock, price  FROM products.products";
	System.out.println("Connecting to database");
	ResultSet rs = stmt.executeQuery(sq12);
	
	while (rs.next()) {
		String templistitem;
		int id_product = rs.getInt("idproducts");
	if(!(prod_id<=-1) && prod_id == id_product){
		System.out.println("productID");
		double cost =quantity * rs.getDouble("price");
		templistitem =rs.getString("idproducts") + "," + rs.getString("product_name") + "," + String.valueOf(quantity) +", "+ String.valueOf(cost);
		model.addElement(templistitem);
	}
	else if(!prod_name.isEmpty() && prod_name.equalsIgnoreCase(rs.getString("product_name"))){
		System.out.println("product_name");
		double cost =quantity * rs.getDouble("price");
		templistitem = rs.getString("idproducts") + "," + rs.getString("product_name") + "," + String.valueOf(quantity) +", "+ String.valueOf(cost);
		model.addElement(templistitem);
	}	
	else if (rs.getString("keywords").contains(keywords2) == true){
		System.out.println("keywords");
		double cost =quantity * rs.getDouble("price");
		templistitem = rs.getString("idproducts") + "," + rs.getString("product_name") + "," + String.valueOf(quantity) +", "+ String.valueOf(cost);
		model.addElement(templistitem);
		System.out.println(model.toString());
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