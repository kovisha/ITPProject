package Delivery;

import java.sql.Date;

public class DeliveryUserDetails {
	
	String deliveryID;
	String orderID;
	String status ;
	Date dateTime ;
	String delType;
	String uID;
	
	

	public DeliveryUserDetails(String deliveryID, String orderID, String status, Date dateTime, String delType,
			String uID) {
		super();
		this.deliveryID = deliveryID;
		this.orderID = orderID;
		this.status = status;
		this.dateTime = dateTime;
		this.delType = delType;
		this.uID = uID;
	}

	public String getuID() {
		return uID;
	}

	public void setuID(String uID) {
		this.uID = uID;
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

	public String getDelType() {
		return delType;
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

	public void setDelType(String delType) {
		this.delType = delType;
	}
	
	
}
