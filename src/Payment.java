

public class Payment {

	private int productid;
	private String productName;
	private int quantity;
	private double cost;
	private int orderid;
	
	public Payment(int prod_id, String productName, int quantity2, double cost){
		
		this.productid = prod_id;
		this.productName = productName;
		this.quantity = quantity2;
		this.cost = cost;
	}
	
	@Override
	public String toString() {
		return "productid [productid=" + productid + ", productname=" + productName
				+ ", quantity=" + quantity + ", cost=" + cost + "]";
	}

	public int getProductid() {
		return productid;
	}

	public String getProductName() {
		return productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getCost() {
		return cost;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
}
