import java.util.Scanner;

public class FindRegisteredCustomersDetails {

	public void findCustomerDetails(Customer customer) {
		GenerateRegisteredCustomers.getGenerateRegisteredCustomers();

	}

	public int getDetails() {
		System.out.println("Do you know your account number?");
		Scanner scan2 = new Scanner(System.in);
		String accountknown = scan2.next();
		if (accountknown.equalsIgnoreCase("yes")) {
			System.out.println("Can you give me your account number please?");
			int accountNumber = scan2.nextInt();
			Customer customerID = GenerateRegisteredCustomers
					.getGenerateRegisteredCustomers().findByAccountNumber(
							accountNumber);
			System.out.println(customerID.toString());
			scan2.close();
			return customerID.getAccountNumber();
		}
		System.out.println("Can I take your postcode please?");
		String postcode = scan2.next();
		System.out.println("Can I take your Surname?");
		String name = scan2.next();
		Customer customerName = GenerateRegisteredCustomers
				.getGenerateRegisteredCustomers().findByName(name);
		Customer customerpostcode = GenerateRegisteredCustomers
				.getGenerateRegisteredCustomers().findbypostcode(postcode);
		System.out.println("using postcode" + customerpostcode.toString());
		System.out.println("Using Name" + customerName.toString());
		System.out.println(customerName);
		System.out.println(customerpostcode);
		scan2.close();
		if (customerName.equals(customerpostcode)) {
			System.out.println("Account found check they are up todate");
			return customerName.getAccountNumber();
		}
	
		System.out.println("No account found");
		return -1;
	}

}
