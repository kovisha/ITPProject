package Installment;

public class installment {
	
	private int id;
	private String installmentId;
	private String payId;
	private Double totAmount;
	private Double downPay;
	private int remainInstalls;
	private String typeId;
	
	public installment(int id, String installmentId, String payId, Double totAmount, Double downPay,
			int remainInstalls, String typeId) {
		super();
		this.id = id;
		this.installmentId = installmentId;
		this.payId = payId;
		this.totAmount = totAmount;
		this.downPay = downPay;
		this.remainInstalls = remainInstalls;
		this.typeId = typeId;
	}

	public int getId() {
		return id;
	}

	public String getInstallmentId() {
		return installmentId;
	}

	public String getPayId() {
		return payId;
	}

	public Double getTotAmount() {
		return totAmount;
	}

	public Double getDownPay() {
		return downPay;
	}

	public int getRemainInstalls() {
		return remainInstalls;
	}

	public String getTypeId() {
		return typeId;
	}
}
