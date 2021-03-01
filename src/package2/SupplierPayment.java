package package2;

public class SupplierPayment {
	
	private int id;
	private String suppPayID;
	private String suppliername;
	private String stockname;
	private float stocksize;
	private String supplieddate;
	private String invoiceNo;
	private String lastPayDate;
	private String stockid;
	private String type;
	private float discpercent;
	private double totalAmount;
	private int chequeNo;
	private double paidAmount;
	
	private double netAmount;
	private double dueAmount;
	private String discID;
	
	/*********************************************************************Constructors***********************************************************/
	
	public SupplierPayment(String suppPayID, String suppliername, String stockname, float stocksize,
			String supplieddate, String invoiceNo, String lastPayDate, String stockid, String type, float discpercent,
			double totalAmount, int chequeNo, double paidAmount) {
		super();
		this.suppPayID = suppPayID;
		this.suppliername = suppliername;
		this.stockname = stockname;
		this.stocksize = stocksize;
		this.supplieddate = supplieddate;
		this.invoiceNo = invoiceNo;
		this.lastPayDate = lastPayDate;
		this.stockid = stockid;
		this.type = type;
		this.discpercent = discpercent;
		this.totalAmount = totalAmount;
		this.chequeNo = chequeNo;
		this.paidAmount = paidAmount;
	}

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

	/*********************************************************************Getters & Setters***********************************************************/
	
	public SupplierPayment(double paidAmount) {
		super();
		this.paidAmount = paidAmount;
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

	public double getNetAmount() {
		
		netAmount = totalAmount * ((100 - discpercent) / 100);
		String str = String.format("%1.2f", netAmount);
		netAmount = Double.valueOf(str);
		return netAmount;
		
	}

	public double getDueAmount() {
		dueAmount = netAmount - paidAmount;
		return dueAmount;
	}

	public String getSuppliername() {
		return suppliername;
	}

	public String getStockname() {
		return stockname;
	}

	public String getSupplieddate() {
		return supplieddate;
	}

	public float getStocksize() {
		return stocksize;
	}

}
