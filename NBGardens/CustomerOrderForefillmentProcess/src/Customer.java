
public class Customer {

	private int accountNumber;
	private String title;
	private String forename;
	private String surname;
	private String postcode;
	private String address;
	private String deliverPostcode;
	private String deliveryAddress;
	private String dOB;


	private String email;
	private String phone;
	private double credit;
	
	public Customer(String title, String forename, String surname, String postcode, 
			String address, String deliveryPostcode, String deliveryAddress, String dOB, String email, String phone){
		
		this.title = title;
		this.forename = forename;
		this.surname = surname;
		this.postcode = postcode;
		this.address = address;
		this.deliverPostcode = deliveryPostcode;
		this.deliveryAddress = deliveryAddress;
		this.dOB = dOB;
		this.email = email;
		this.phone = phone;
		
		
		
	}



	@Override
	public String toString() {
		return "Customer [accountNumber=" + accountNumber + ", title=" + title
				+ ", forename=" + forename + ", surname=" + surname
				+ ", postcode=" + postcode + ", address=" + address
				+ ", deliverPostcode=" + deliverPostcode + ", deliveryAddress="
				+ deliveryAddress + ", dOB=" + dOB + ", email=" + email
				+ ", phone=" + phone + ", credit=" + credit + "]";
	}



	public int getAccountNumber() {
		return accountNumber;
	}

	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}



	public void setForename(String forename) {
		this.forename = forename;
	}



	public void setSurname(String surname) {
		this.surname = surname;
	}



	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public void setDeliverPostcode(String deliverPostcode) {
		this.deliverPostcode = deliverPostcode;
	}



	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}



	public void setdOB(String dOB) {
		this.dOB = dOB;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getForename() {
		return forename;
	}

	public String getSurname() {
		return surname;
	}

	public String getPostcode() {
		return postcode;
	}

	public String getAddress() {
		return address;
	}

	public String getDeliverPostcode() {
		return deliverPostcode;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public String getdOB() {
		return dOB;
	}
	
	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public double getCredit() {
		return credit;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}
	
}
