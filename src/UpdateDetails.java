import java.util.Scanner;


public class UpdateDetails {

	public void findCustomerDetails(Customer customer){
		GenerateRegisteredCustomers.getGenerateRegisteredCustomers();
		
		
	}
	
	public void updateDetails(int customerID){
		int arrayelement = customerID - 1;
		Scanner scan3 = new Scanner(System.in);
		Scanner scan4 = new Scanner(System.in);
		boolean update = true;
		while (update == true){
		System.out.println("What do you wish to update?");
		System.out.println("Title, FirstName, Surname, Postcode, Address, delivery-postcode, delivery-address, DOB, email, phone");
		String newValue = scan3.next();
		if(newValue.equalsIgnoreCase("title")){
			System.out.println("What title is it now?");
			String title = scan3.next();
			GenerateRegisteredCustomers.getGenerateRegisteredCustomers().updateCustomerTitle(arrayelement, title);
			GenerateRegisteredCustomers.getGenerateRegisteredCustomers().printArraylist(arrayelement);
			System.out.println("Update done do you wish to do another update?");
			String carry = scan3.next();
			if(carry.equalsIgnoreCase("no")){
				update = false;
			}
			}
		else if(newValue.equalsIgnoreCase("Firstname")){
			System.out.println("What firstname is it now?");
			String fname = scan3.next();
			GenerateRegisteredCustomers.getGenerateRegisteredCustomers().updateCustomerFName(arrayelement, fname);
			GenerateRegisteredCustomers.getGenerateRegisteredCustomers().printArraylist(arrayelement);
			System.out.println("Update done do you wish to do another update?");
			String carry = scan3.next();
			if(carry.equalsIgnoreCase("no")){
				update = false;
			}
		}
		else if(newValue.equalsIgnoreCase("Surname")){
			System.out.println("What surname is it now?");
			String sname = scan3.next();
			GenerateRegisteredCustomers.getGenerateRegisteredCustomers().updateCustomerSname(arrayelement, sname);
			GenerateRegisteredCustomers.getGenerateRegisteredCustomers().printArraylist(arrayelement);
			System.out.println("Update done do you wish to do another update?");
			String carry = scan3.next();
			if(carry.equalsIgnoreCase("no")){
				update = false;
			}
		}
		else if(newValue.equalsIgnoreCase("postcode")){
			System.out.println("What postcode is it now?");
			String postcode = scan3.next();
			GenerateRegisteredCustomers.getGenerateRegisteredCustomers().updateCustomerPcode(arrayelement, postcode);
			GenerateRegisteredCustomers.getGenerateRegisteredCustomers().printArraylist(arrayelement);
			System.out.println("Update done do you wish to do another update?");
			String carry = scan3.next();
			if(carry.equalsIgnoreCase("no")){
				update = false;
			}
		}
		else if(newValue.equalsIgnoreCase("Address")){
			System.out.println("What Address is it now?");
			String address = scan4.nextLine();
			GenerateRegisteredCustomers.getGenerateRegisteredCustomers().updateCustomerAddress(arrayelement, address);
			GenerateRegisteredCustomers.getGenerateRegisteredCustomers().printArraylist(arrayelement);
			System.out.println("Update done do you wish to do another update?");
			String carry = scan3.nextLine();
			if(carry.equalsIgnoreCase("no")){
				update = false;
			}
		}
		else if(newValue.equalsIgnoreCase("delivery-postcode")){
			System.out.println("What delivery-postcode is it now?");
			String dPCode = scan3.next();
			GenerateRegisteredCustomers.getGenerateRegisteredCustomers().updateCustomerDPCode(arrayelement, dPCode);
			GenerateRegisteredCustomers.getGenerateRegisteredCustomers().printArraylist(arrayelement);
			System.out.println("Update done do you wish to do another update?");
			String carry = scan3.next();
			if(carry.equalsIgnoreCase("no")){
				update = false;
			}
		}
		else if(newValue.equalsIgnoreCase("delivery-address")){
			System.out.println("What delivery address is it now?");
			String dAddress  = scan4.nextLine();
			GenerateRegisteredCustomers.getGenerateRegisteredCustomers().updateCustomerDAddress(arrayelement, dAddress);
			GenerateRegisteredCustomers.getGenerateRegisteredCustomers().printArraylist(arrayelement);
			System.out.println("Update done do you wish to do another update?");
			String carry = scan3.next();
			if(carry.equalsIgnoreCase("no")){
				update = false;
			}
		}
		else if(newValue.equalsIgnoreCase("DOB")){
			System.out.println("What date of birth is it now?");
			String dOB = scan3.next();
			GenerateRegisteredCustomers.getGenerateRegisteredCustomers().updateCustomerDOB(arrayelement, dOB);
			GenerateRegisteredCustomers.getGenerateRegisteredCustomers().printArraylist(arrayelement);
			System.out.println("Update done do you wish to do another update?");
			String carry = scan3.next();
			if(carry.equalsIgnoreCase("no")){
				update = false;
			}
		}
		else if(newValue.equalsIgnoreCase("email")){
			System.out.println("What email is it now?");
			String email = scan3.next();
			GenerateRegisteredCustomers.getGenerateRegisteredCustomers().updateCustomerEmail(arrayelement, email);
			GenerateRegisteredCustomers.getGenerateRegisteredCustomers().printArraylist(arrayelement);
			System.out.println("Update done do you wish to do another update?");
			String carry = scan3.next();
			if(carry.equalsIgnoreCase("no")){
				update = false;
			}
		}
		else if(newValue.equalsIgnoreCase("phone")){
			System.out.println("What phonenumber is it now?");
			String phone = scan3.next();
			GenerateRegisteredCustomers.getGenerateRegisteredCustomers().updateCustomerPhone(arrayelement, phone);
			GenerateRegisteredCustomers.getGenerateRegisteredCustomers().printArraylist(arrayelement);
			System.out.println("Update done do you wish to do another update?");
			String carry = scan3.next();
			if(carry.equalsIgnoreCase("no")){
				update = false;
			}
		}
		else{
			System.out.println("Incorrect Value put do you want to try again?");
			String carry = scan3.next();
			if(carry.equalsIgnoreCase("no")){
				update = false;
			}
		}
		}
	}
}
