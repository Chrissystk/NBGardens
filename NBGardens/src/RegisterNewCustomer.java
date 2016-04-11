import java.util.Scanner;


public class RegisterNewCustomer {
	
	
	
	public void addCustomer(Customer customer) {
		GenerateRegisteredCustomers.getGenerateRegisteredCustomers().addCustomer(customer);
		//customers.add(customer);
	}
	
	public void getRegDetails(){
		Scanner scan1 = new Scanner(System.in);
		Scanner scan5 = new Scanner(System.in);
		int accountNum = GenerateRegisteredCustomers.getGenerateRegisteredCustomers().size();
		System.out.println(accountNum);
		String address;
		String email;
		String deliveryAddress;
		String deliveryPostcode;
		String dOB;
		String forename;
		String surname;
		String postcode;
		String phone;
		System.out.println("Can I take your Title please?");
		
		String title = scan1.nextLine();
		
		System.out.println("Can I take your First name please?");
		forename = scan1.nextLine();
		System.out.println("Can I take your surname please?");
		surname = scan1.nextLine();
		System.out.println("Can I take your postcode please?");
		
		
		postcode = scan1.next();

		System.out.println("Can I take your Address please?");
		
		address = scan5.nextLine();
		
		System.out.println("Is your delivery address the same as your home address?");
		
		String question = scan1.next();
		
		if (question.equalsIgnoreCase("yes")){

		deliveryAddress = address;
		deliveryPostcode = postcode;
		}
		else {
			System.out.println("Can I take the postcode for you delivery address please?");
			
			deliveryPostcode = scan1.next();
		
			System.out.println("Can I take your delivery address please?");
			
			deliveryAddress = scan5.nextLine();
		
		}
		
		System.out.println("Can I take your Date of Birth please? write in form of dd/mm/yyyy");
		
		dOB = scan1.next();
		
		System.out.println("Can I take your email address please? If have none type none");
		
		email = scan1.next();
		
		System.out.println("Can I take your phone number please?");
		
		phone = scan1.next();
		
		addCustomer(new Customer(title, forename, surname, postcode, address, deliveryPostcode, deliveryAddress, dOB, email, phone));
		GenerateRegisteredCustomers.getGenerateRegisteredCustomers().printArraylist(accountNum);
		
		
	}

}
