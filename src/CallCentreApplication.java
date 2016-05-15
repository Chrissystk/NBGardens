import java.awt.EventQueue;

import javax.swing.JFrame;

public class CallCentreApplication {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CallCentreApplication window = new CallCentreApplication();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CallCentreApplication() {
		SignIn signin = new SignIn();
		signin.FindUser();
		
	}

	

}
