package Order_Management;

public class Order {
	
	private int id;
	private String orderID;
	private double total;
	private String date;
	private String uid;
	private String off_id;
	
	
	
	public Order(int id, String orderID, double total, String date, String uid, String off_id) {
		super();
		this.id = id;
		this.orderID = orderID;
		this.total = total;
		this.date = date;
		this.uid = uid;
		this.off_id = off_id;
	}



	public int getId() {
		return id;
	}



	public String getOrderID() {
		return orderID;
	}



	public double getTotal() {
		return total;
	}



	public String getDate() {
		return date;
	}



	public String getUid() {
		return uid;
	}



	public String getOff_id() {
		return off_id;
	}




	
}
