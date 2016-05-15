import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Basket {

	private JFrame basket;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/Customers";
	static final String USER = "root";
	static final String PASSWORD = "Callash0825";
	private JList<Object> list;
	private DefaultListModel<Object> model; 
	private int customerid;
	
	public Basket(){
	initialise();
	basket.setVisible(true);
	}
	
	public void Basket1(Payment order){
		 GenerateOrderList.getGeneratedOrderList();
	}
	
	public void CheckBasket(int customer_ID){
		customerid = customer_ID;
		JLabel lblNewLabel_2 = new JLabel(String.valueOf(customer_ID));
		lblNewLabel_2.setBounds(622, 38, 111, 16);
		basket.getContentPane().add(lblNewLabel_2);
	}
	
	private void initialise(){
		basket = new JFrame();
		basket.getContentPane().setFont(new Font("Arial", Font.BOLD, 14));
		basket.setBounds(100, 100, 792, 407);
		basket.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		basket.getContentPane().setLayout(null);
		
		JLabel lblNbGardensCall = new JLabel("NB Gardens Call Centre");
		lblNbGardensCall.setBounds(22, 26, 725, 38);
		lblNbGardensCall.setFont(new Font("Arial", Font.BOLD, 18));
		basket.getContentPane().add(lblNbGardensCall);
		
		JLabel lblNewLabel = new JLabel("Items in Basket");
		lblNewLabel.setBounds(32, 79, 239, 16);
		basket.getContentPane().add(lblNewLabel);
		
		
		JButton btnNewButton = new JButton("Proceed to Payment");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				basket.setVisible(false);
				PaymentPage paying = new PaymentPage();
				paying.getpayment(customerid);
			}
		});
		btnNewButton.setBounds(494, 124, 239, 29);
		basket.getContentPane().add(btnNewButton);
		
		JButton btnUpdate = new JButton("Add another Item");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ordering ordering = new Ordering();
				ordering.CreateOrder(customerid);
			}
		});
		btnUpdate.setBounds(22, 347, 182, 29);
		basket.getContentPane().add(btnUpdate);
		JButton btnDeleteItem = new JButton("Delete Selected Item");
		btnDeleteItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String deleteitem = list.getSelectedValue().toString();
				String[] parts = deleteitem.split(",");
				ArrayList<Payment> orders = GenerateOrderList.getGeneratedOrderList().getOrder();
				for (int i = 0; i<orders.size(); i++){
					if(orders.get(i).getProductid() == Integer.parseInt(parts[0])){
						orders.remove(i);
					}
				}
				model.removeElement(list.getSelectedValue());
			}
		});
		btnDeleteItem.setBounds(228, 347, 177, 29);
		basket.getContentPane().add(btnDeleteItem);
		
		JButton btnNewButton_1 = new JButton("Cancel Order");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GenerateOrderList.getGeneratedOrderList();
				ArrayList<Payment> orders = GenerateOrderList.getGeneratedOrderList().getOrder();
				for (int i = 0; i<orders.size(); i++){
					orders.remove(i);
				}
				model.removeAllElements();
				basket.setVisible(false);
		HomeScreen homescreen = new HomeScreen();
		homescreen.CustomersAccount();
			}
		});
		btnNewButton_1.setBounds(494, 204, 226, 29);
		basket.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Account Number");
		lblNewLabel_1.setBounds(482, 38, 128, 16);
		basket.getContentPane().add(lblNewLabel_1);
		
		model = new DefaultListModel<>();
		GenerateOrderList.getGeneratedOrderList();
		ArrayList<Payment> orders = GenerateOrderList.getGeneratedOrderList().getOrder();
		for (int i = 0; i<orders.size(); i++){
			String ordering = orders.get(i).getProductid() + ", " + orders.get(i).getProductName() + ", " + orders.get(i).getQuantity() + ", " + orders.get(i).getCost();
			model.addElement(ordering);
			System.out.println(ordering);
		}
		JScrollPane pane = new JScrollPane();
		pane.setBounds(22, 107, 359, 228);
		basket.getContentPane().add(pane);
		basket.getContentPane().add(pane);
		list = new JList<Object>(model);
		pane.setViewportView(list);
		basket.setVisible(true);
		
		
}
}