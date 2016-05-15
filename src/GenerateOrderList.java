import java.awt.List;
import java.util.ArrayList;

public class GenerateOrderList {

	private static GenerateOrderList generateorderlist = new GenerateOrderList();
	private ArrayList<Payment> orders = new ArrayList<Payment>();
	private int num_orders = orders.size();
	private double totalCost;
	
	private GenerateOrderList(){}
	
	public void addOrder(Payment order){
		orders.add(setOrderid(order));
	}
	
	
	private Payment setOrderid(Payment order) {
		int ordernumber = orders.size();
		int orderNum = ordernumber + 1;
		order.setOrderid(orderNum);
		return order;
	}
	public double TotalCost(){
		
		for (int i=0; i< num_orders; i++){
			totalCost = totalCost + orders.get(i).getCost();
		}
		System.out.println(totalCost);
	return totalCost;
	}
	
	public static GenerateOrderList getGeneratedOrderList(){
		return generateorderlist;
	}
	
	public ArrayList<Payment> getOrder(){
		return orders;
	}
}
