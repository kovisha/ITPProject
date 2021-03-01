package Delivery;

import java.sql.Date;

public class DeliveryDetails {
	
	private String id;
	private String uID;
	private String deliveryID;
	private String orderID;
	private String status;
	private Date dateTime;
	private double amount;
	private String address;
	private String delType;
	



	public DeliveryDetails(String id, String uID, String deliveryID, String orderID, String status, Date dateTime,
			double amount, String address, String delType) {
		super();
		this.id = id;
		this.uID = uID;
		this.deliveryID = deliveryID;
		this.orderID = orderID;
		this.status = status;
		this.dateTime = dateTime;
		this.amount = amount;
		this.address = address;
		this.delType = delType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getuID() {
		return uID;
	}

	public String getDeliveryID() {
		return deliveryID;
	}

	public String getOrderID() {
		return orderID;
	}

	public String getStatus() {
		return status;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public double getAmount() {
		return amount;
	}

	public void setuID(String uID) {
		this.uID = uID;
	}

	public void setDeliveryID(String deliveryID) {
		this.deliveryID = deliveryID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDelType() {
		return delType;
	}

	public void setDelType(String delType) {
		this.delType = delType;
	}


	
}
