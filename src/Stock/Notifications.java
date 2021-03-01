package Stock;

public class Notifications {

	private int id;
	private String stockName;
	private String supplierName;
	private int reOrderLevel;
	private double stockSize;
	private String reshelfDate;
	private int reshelfQty;
	
	public Notifications(int id, String stockName, String supplierName, int reOrderLevel, double stockSize,
			String reshelfDate, int reshelfQty) {
		super();
		this.id = id;
		this.stockName = stockName;
		this.supplierName = supplierName;
		this.reOrderLevel = reOrderLevel;
		this.stockSize = stockSize;
		this.reshelfDate = reshelfDate;
		this.reshelfQty = reshelfQty;
	}

	public int getId() {
		return id;
	}

	public String getStockName() {
		return stockName;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public int getReOrderLevel() {
		return reOrderLevel;
	}

	public double getStockSize() {
		return stockSize;
	}

	public String getReshelfDate() {
		return reshelfDate;
	}

	public int getReshelfQty() {
		return reshelfQty;
	}

	
	
	
	
}
