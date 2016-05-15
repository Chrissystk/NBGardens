import java.util.ArrayList;


public class GenerateRegisteredCustomers {
	
	private static GenerateRegisteredCustomers generateRegisteredCustomers = new GenerateRegisteredCustomers();
	
	
	private ArrayList<Customer> customers = new ArrayList<Customer>();
	
	private GenerateRegisteredCustomers(){
		addCustomer(new Customer("Miss", "Anna", "Smith", "M252BH", "33 Garden Road Manchester", "M252BH", "33 Garden Road, Manchester", "15/12/1991", "ASmith@email.com", "01617231845"));
		customers.get(0).setAccountNumber(1);
		customers.get(0).setCredit(250.00);
		addCustomer(new Customer("Mrs", "Chloe", "Tree", "B112SA", "65 St Annes Road Birmingham", "B104QA", "101 Systems Close, Birmingham", "21/06/1982", "CTree@email.com", "01772312849"));
		customers.get(1).setAccountNumber(2);
		customers.get(1).setCredit(571.69);
		addCustomer(new Customer("Mr", "Andrew", "Hall", "PR76TB", "22 Linden Drive Preston", "PR76TB", "22 Linden Drive, Preston", "10/01/1964", "None", "07718375271"));
		customers.get(2).setAccountNumber(3);
		customers.get(2).setCredit(1000.00);
		
	}
	
	
	public void addCustomer(Customer customer) {
		customers.add(setAccountNo(customer));
//		customers.add(setCreditNo(customer));
	}
	

	public Customer findByAccountNumber(int accountNumber){
	for(Customer c: customers){
		if(c.getAccountNumber() == accountNumber)
			return c;
		}
		return null;
	}
	
	public Customer findbypostcode(String postcode){
		for(Customer c: customers){
			if(c.getPostcode().equalsIgnoreCase(postcode))
				return c;
		}
		return null;
	}
	
	public Customer findByName(String name) {
		for(Customer c: customers) {
			if(c.getSurname().equalsIgnoreCase(name))
				return c;
		}
		return null;
	}
	

	public void updateCustomerTitle(int accountnum, String title){
		customers.get(accountnum).setTitle(title);
		
	}
		
	public void updateCustomerFName(int accountnum, String fname){
		customers.get(accountnum).setForename(fname);
	}
	
	public void updateCustomerSname(int accountnum, String sName){
		customers.get(accountnum).setSurname(sName);
	}
	
	public void updateCustomerPcode(int accountnum, String pCode ){
		customers.get(accountnum).setPostcode(pCode);
	}
	
	public void updateCustomerAddress(int accountnum, String address){
		customers.get(accountnum).setAddress(address);
	}
	
	public void updateCustomerDPCode(int accountnum, String delPCode){
		customers.get(accountnum).setDeliverPostcode(delPCode);
	}
	
	public void updateCustomerDAddress(int accountnum, String dAddress){
		customers.get(accountnum).setDeliveryAddress(dAddress);
	}
	
	public void updateCustomerDOB(int accountnum, String dOB){
		customers.get(accountnum).setdOB(dOB);
	}
	
	public void updateCustomerEmail(int accountnum, String email){
		customers.get(accountnum).setEmail(email);
	}
	
	public void updateCustomerPhone(int accountnum, String phone){
		customers.get(accountnum).setPhone(phone);
	}
	public void updateCustomerCredit(int accountnum, double credit){
		customers.get(accountnum).setCredit(credit);
	
	}

	
	private Customer setAccountNo(Customer customer) {
		int accountNumber = customers.size();
		int accountNum = accountNumber + 1;
		customer.setAccountNumber(accountNum);
		return customer;
	}
	
	@SuppressWarnings("unused")
	private void creditadd(Customer customer){
		int accountNumber = customers.size();
		customers.get(accountNumber).setCredit(0.00);
	}
	
	
	public void printArraylist(int i){
		
			System.out.println(customers.get(i).toString());
	}
	public String get_delivery_address(int i){
		String del_address = customers.get(i).getDeliveryAddress();
	
		return del_address;
		
	}
	
	
	public String get_delivery_postcode(int i){
		String del_postcode = customers.get(i).getDeliverPostcode();
	
		return del_postcode;
		
	}
	
	public double get_credit_limit(int i){
		double credit = customers.get(i).getCredit();
		
		return credit;
	}
	
	public int size(){
		return customers.size();
	}
	
		
	public static GenerateRegisteredCustomers getGenerateRegisteredCustomers(){
		return generateRegisteredCustomers;
	}
	
}
