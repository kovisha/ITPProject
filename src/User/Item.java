package User;

public class Item {

	
	private String itemName ;
	private Double size ;
	private String price ;
	private String categoryName ;
	private String offerName ;
	
	public Item(String itemName, Double size, String price, String categoryName, String offerName) {
		
		this.itemName = itemName;
		this.size = size;
		this.price = price;
		this.categoryName = categoryName;
		this.offerName = offerName;
	}

	public String getItemName() {
		return itemName;
	}

	public Double getSize() {
		return size;
	}

	public String getPrice() {
		return price;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public String getOfferName() {
		return offerName;
	}
	
	
	
	
}
