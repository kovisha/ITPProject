package userPayment;

import java.sql.Date;

public class yourPayDetails {
	private Date lastOrderPayDate;
	private Double lastOrderPayValue;
	private Double dueInstall;
	private Double monthlyInstall;
	
	public yourPayDetails(Date lastOrderPayDate, Double lastOrderPayValue, Double dueInstall, Double monthlyInstall) {
		super();
		this.lastOrderPayDate = lastOrderPayDate;
		this.lastOrderPayValue = lastOrderPayValue;
		this.dueInstall = dueInstall;
		this.monthlyInstall = monthlyInstall;
	}

	public Date getLastOrderPayDate() {
		return lastOrderPayDate;
	}

	public Double getLastOrderPayValue() {
		return lastOrderPayValue;
	}

	public Double getDueInstall() {
		return dueInstall;
	}

	public Double getMonthlyInstall() {
		return monthlyInstall;
	}

}
