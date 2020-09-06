package model;

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
	
	public Stock(int stockID, String id, String stockName, int qtyAvailable, double stockSize, int reOrderLevel,
			int qtySupplied, String suppliedDate, int storeQty, String supplierName, 
			String categoryName) {
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

	
}
