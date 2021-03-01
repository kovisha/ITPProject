package Order_Management;

public class ShoppingCart {
	
	private int id; 
	private String itemid;
	private String itemName;
	private double price ;
	private double discount;
	private int qty;
	private double netAmount;
	private String offername;
	private String category ;
	
	
	

	public ShoppingCart(int id, String itemid, String itemName, double price, double discount, int qty,
			double netAmount, String offername, String category) {
		super();
		this.id = id;
		this.itemid = itemid;
		this.itemName = itemName;
		this.price = price;
		this.discount = discount;
		this.qty = qty;
		this.netAmount = netAmount;
		this.offername = offername;
		this.category = category;
	}




	public int getId() {
		return id;
	}




	public String getItemid() {
		return itemid;
	}




	public String getItemName() {
		return itemName;
	}




	public double getPrice() {
		return price;
	}




	public double getDiscount() {
		return discount;
	}




	public int getQty() {
		return qty;
	}




	public double getNetAmount() {
		return netAmount;
	}




	public String getOffername() {
		return offername;
	}




	public String getCategory() {
		return category;
	}



	
	
/*	public ShoppingCart(int id, String itemName, double price,double discount,int qty) {
		
		this.id = id;
		this.itemName = itemName;
		this.price = price;
		this.discount = discount;
		this.qty = qty;
		
	}*/

	/*public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}*/

	
	
	
	

}
