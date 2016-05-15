import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class SignIn {

	private JFrame frame1;
	public int employeenum;
	private JTextField forename;
	private JTextField surname;
	public boolean account_found;
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/employees";
	static final String USER = "root";
	static final String PASSWORD = "Callash0825";
	
	
	public SignIn(){
		initialise();
	}
	
	
	
	public void FindUser(){
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Arial", Font.BOLD, 14));
		btnLogin.setBounds(536, 231, 149, 47);
		frame1.getContentPane().add(btnLogin);
		frame1.setVisible(true);
				btnLogin.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
			
						String firstname = forename.getText();
						String secondname = surname.getText();
			
						Database(firstname, secondname);
			
			
		
				if(account_found == true){
					frame1.setVisible(false);
					HomeScreen homescreen = new HomeScreen();
					homescreen.CustomersAccount();
					
					}
				else {
					forename.setText(null);
					surname.setText(null);
					JLabel lblIncorrectForenameOr = new JLabel("Incorrect Forename or Surname entered please try again");
					lblIncorrectForenameOr.setFont(new Font("Arial", Font.PLAIN, 14));
					lblIncorrectForenameOr.setHorizontalAlignment(SwingConstants.CENTER);
					lblIncorrectForenameOr.setForeground(Color.RED);
					lblIncorrectForenameOr.setBounds(6, 62, 780, 16);
					frame1.getContentPane().add(lblIncorrectForenameOr);
					
				}
					
				
			

			
					
	}
	});
				
}
				
	
		
	private void Database(String firstname, String secondname){
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
		stmt = conn.createStatement();
		String sq12 = "SELECT idemployees, Forename, Surname  FROM employees.employees";
		ResultSet rs = stmt.executeQuery(sq12);
		account_found = false;
		while (rs.next()) {
			
			String userforename = rs.getString("Forename");
			String usersurname = rs.getString("Surname");
			if (userforename.equalsIgnoreCase(firstname) && usersurname.equalsIgnoreCase(secondname))
			account_found = true;
			employeenum = rs.getInt("idemployees");
		}
		conn.close();
	}catch(SQLException | ClassNotFoundException sqle){
		sqle.printStackTrace();
	}	catch (Exception e) {
		e.printStackTrace();
		
	}
			
				
	}
	private void initialise(){
		frame1 = new JFrame();
		frame1.getContentPane().setFont(new Font("Arial", Font.BOLD, 14));
		frame1.setBounds(100, 100, 792, 407);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.getContentPane().setLayout(null);
		
		JLabel lblNbGardensCall = new JLabel("NB Gardens Call Centre");
		lblNbGardensCall.setFont(new Font("Arial", Font.BOLD, 18));
		lblNbGardensCall.setBounds(22, 26, 725, 38);
		frame1.getContentPane().add(lblNbGardensCall);
		
		JLabel lblPleaseProvieYour = new JLabel("Please Provie your name to sign in to the System");
		lblPleaseProvieYour.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseProvieYour.setFont(new Font("Arial", Font.BOLD, 16));
		lblPleaseProvieYour.setBounds(6, 99, 780, 16);
		frame1.getContentPane().add(lblPleaseProvieYour);
		
		JLabel lblForename = new JLabel("Forename");
		lblForename.setFont(new Font("Arial", Font.BOLD, 14));
		lblForename.setHorizontalAlignment(SwingConstants.CENTER);
		lblForename.setBounds(61, 175, 149, 38);
		frame1.getContentPane().add(lblForename);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setHorizontalAlignment(SwingConstants.CENTER);
		lblSurname.setFont(new Font("Arial", Font.BOLD, 14));
		lblSurname.setBounds(61, 243, 149, 38);
		frame1.getContentPane().add(lblSurname);
		
		forename = new JTextField();
		forename.setBounds(222, 178, 174, 32);
		frame1.getContentPane().add(forename);
		forename.setColumns(10);
		
		surname = new JTextField();
		surname.setColumns(10);
		surname.setBounds(222, 243, 174, 32);
		frame1.getContentPane().add(surname);
		
	}
	
	
	
	

	
}

