package userPayment;

import java.sql.Date;

public class userPayment {
	
	private int id;
	private String payId;
	private String receiptNo;
	private String paytype;
	private Date paydate;
	private Double totAmount;
	private String orderId;
	
	public userPayment(int id, String payId, String receiptNo, String paytype, Date paydate, Double totAmount,
			String orderId) {
		super();
		this.id = id;
		this.payId = payId;
		this.receiptNo = receiptNo;
		this.paytype = paytype;
		this.paydate = paydate;
		this.totAmount = totAmount;
		this.orderId = orderId;
	}

	public int getId() {
		return id;
	}

	public String getPayId() {
		return payId;
	}

	public String getReceiptNo() {
		return receiptNo;
	}

	public String getPaytype() {
		return paytype;
	}

	public Date getPaydate() {
		return paydate;
	}

	public Double getTotAmount() {
		return totAmount;
	}

	public String getOrderId() {
		return orderId;
	}
	
}
