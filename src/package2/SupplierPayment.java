package package2;

public class SupplierPayment {
	
	private int id;
	private String suppPayID;
	private String stockid;
	private double totalAmount;
	private String discID;
	private double paidAmount;
	private String lastPayDate;
	private int chequeNo;
	private String invoiceNo;
	private String type;
	private float discpercent;
	
	public SupplierPayment(int id, String suppPayID, String stockid, double totalAmount, String discID,
			double paidAmount, String lastPayDate, int chequeNo, String invoiceNo, String type, float discpercent) {
		super();
		this.id = id;
		this.suppPayID = suppPayID;
		this.stockid = stockid;
		this.totalAmount = totalAmount;
		this.discID = discID;
		this.paidAmount = paidAmount;
		this.lastPayDate = lastPayDate;
		this.chequeNo = chequeNo;
		this.invoiceNo = invoiceNo;
		this.type = type;
		this.discpercent = discpercent;
	}
	
	

	public SupplierPayment(String suppPayID, String stockid, double totalAmount, double paidAmount, String lastPayDate,
			String invoiceNo, String type, float discpercent) {
		super();
		this.suppPayID = suppPayID;
		this.stockid = stockid;
		this.totalAmount = totalAmount;
		this.paidAmount = paidAmount;
		this.lastPayDate = lastPayDate;
		this.invoiceNo = invoiceNo;
		this.type = type;
		this.discpercent = discpercent;
	}



	public int getId() {
		return id;
	}

	public String getSuppPayID() {
		return suppPayID;
	}

	public String getStockid() {
		return stockid;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public String getDiscID() {
		return discID;
	}

	public double getPaidAmount() {
		return paidAmount;
	}

	public String getLastPayDate() {
		return lastPayDate;
	}

	public int getChequeNo() {
		return chequeNo;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public String getType() {
		return type;
	}

	public float getDiscpercent() {
		return discpercent;
	}

	
	
	
}
