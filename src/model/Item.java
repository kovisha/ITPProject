package model;

public class Item {

	private int id;
	private String catid; //actually item id
	private String itemName;
	private double itemSize;
	private String barcodeID;
	private double itemPrice;
	private int availableQty;
	private String status;
	private String offerName;
	private String categoryName;
	
	public Item(int id, String catid, String itemName, double itemSize, String barcodeID, double itemPrice,
			int availableQty, String status, String offerName, String categoryName) {
		super();
		this.id = id;
		this.catid = catid;
		this.itemName = itemName;
		this.itemSize = itemSize;
		this.barcodeID = barcodeID;
		this.itemPrice = itemPrice;
		this.availableQty = availableQty;
		this.status = status;
		this.offerName = offerName;
		this.categoryName = categoryName;
	}

	public int getId() {
		return id;
	}

	public String getCatid() {
		return catid;
	}

	public String getItemName() {
		return itemName;
	}

	public double getItemSize() {
		return itemSize;
	}

	public String getBarcodeID() {
		return barcodeID;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public int getAvailableQty() {
		return availableQty;
	}

	public String getStatus() {
		return status;
	}

	public String getOfferName() {
		return offerName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	
	
	
	
	
	
}
