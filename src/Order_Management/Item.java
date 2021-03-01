package Order_Management;

public class Item {

	private String itemId;
	private String itemName ;
	private Double size ;
	private Double price ;
	private String categoryName ;
	private String offerName ;
	private Double discount;
	private String image;
	private int qtyAvailabale ;

	public Item(String itemId, String itemName, Double size, Double price, String categoryName, String offerName,
			Double discount, String image, int qtyAvailabale) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.size = size;
		this.price = price;
		this.categoryName = categoryName;
		this.offerName = offerName;
		this.discount = discount;
		this.image = image;
		this.qtyAvailabale = qtyAvailabale;
	}

	public String getItemId() {
		return itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public Double getSize() {
		return size;
	}

	public Double getPrice() {
		return price;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public String getOfferName() {
		return offerName;
	}

	public Double getDiscount() {
		return discount;
	}

	public String getImage() {
		return image;
	}

	public int getQtyAvailabale() {
		return qtyAvailabale;
	}


	
}
