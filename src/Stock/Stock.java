package Stock;

public class Stock {

	private int stockID;
	private String id;
	private String stockName;
	private int qtyAvailable;
	private double stockSize;
	private int reOrderLevel;
	private int qtySupplied;
	private String suppliedDate;
	private int storeQty;
	private String supplierName;
	//private String offerName;
	private String categoryName;
	private String image;
	
	public Stock(int stockID, String id, String stockName, int qtyAvailable, double stockSize, int reOrderLevel,
			int qtySupplied, String suppliedDate, int storeQty, String supplierName, String categoryName,
			String image) {
		super();
		this.stockID = stockID;
		this.id = id;
		this.stockName = stockName;
		this.qtyAvailable = qtyAvailable;
		this.stockSize = stockSize;
		this.reOrderLevel = reOrderLevel;
		this.qtySupplied = qtySupplied;
		this.suppliedDate = suppliedDate;
		this.storeQty = storeQty;
		this.supplierName = supplierName;
		this.categoryName = categoryName;
		this.image = image;
	}

	public int getStockID() {
		return stockID;
	}

	public String getId() {
		return id;
	}

	public String getStockName() {
		return stockName;
	}

	public int getQtyAvailable() {
		return qtyAvailable;
	}

	public double getStockSize() {
		return stockSize;
	}

	public int getReOrderLevel() {
		return reOrderLevel;
	}

	public int getQtySupplied() {
		return qtySupplied;
	}

	public String getSuppliedDate() {
		return suppliedDate;
	}

	public int getStoreQty() {
		return storeQty;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public String getImage() {
		return image;
	}

	public void setStockID(int stockID) {
		this.stockID = stockID;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public void setQtyAvailable(int qtyAvailable) {
		this.qtyAvailable = qtyAvailable;
	}

	public void setStockSize(double stockSize) {
		this.stockSize = stockSize;
	}

	public void setReOrderLevel(int reOrderLevel) {
		this.reOrderLevel = reOrderLevel;
	}

	public void setQtySupplied(int qtySupplied) {
		this.qtySupplied = qtySupplied;
	}

	public void setSuppliedDate(String suppliedDate) {
		this.suppliedDate = suppliedDate;
	}

	public void setStoreQty(int storeQty) {
		this.storeQty = storeQty;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
	
	
}
