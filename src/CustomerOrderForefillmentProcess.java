import java.util.Scanner;
public class CustomerOrderForefillmentProcess {

	public static void main(String[] args)
	{
		
		int currentID= -1;
		SignIn signin = new SignIn();
		signin.FindUser();
		
		System.out.println("Hello NB Gardens, Are you are registered Customer?");
		Scanner scanIn = new Scanner(System.in);
		Scanner scann = new Scanner(System.in);
		String isRegistered = scanIn.nextLine();
		System.out.println(isRegistered);
		if (isRegistered.equalsIgnoreCase("no")){
			RegisterNewCustomer register = new RegisterNewCustomer();
			register.getRegDetails();
		}
		else {
			FindRegisteredCustomersDetails findDetails = new FindRegisteredCustomersDetails();
			currentID = findDetails.getDetails();
		
		
		System.out.println("Do you need to update your details?");
		String needupdate = scanIn.next();
		if (needupdate.equalsIgnoreCase("yes")){
			UpdateDetails update = new UpdateDetails();
			update.updateDetails(currentID);
		}
		
		product prod = new product();
		prod.ReadDatabase(currentID);
		
	
		
	}
	}
}
	