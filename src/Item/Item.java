package Item;

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
	private String image;
	
	public Item(int id, String catid, String itemName, double itemSize, String barcodeID, double itemPrice,
			int availableQty, String status, String offerName, String categoryName, String image) {
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
		this.image = image;
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

	public String getImage() {
		return image;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCatid(String catid) {
		this.catid = catid;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setItemSize(double itemSize) {
		this.itemSize = itemSize;
	}

	public void setBarcodeID(String barcodeID) {
		this.barcodeID = barcodeID;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public void setAvailableQty(int availableQty) {
		this.availableQty = availableQty;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
	
	
	
	
}
