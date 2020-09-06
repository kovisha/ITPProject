package Delivery;

import java.sql.Date;

public class DeliveryStaff {
	
	private int id;
	private String SID;
	private String name;
	private int ordDelivered;
	private int totOrdDelivered;
	private Date date;
	private double rating;
	private double avgRating;
	
	public DeliveryStaff(int id, String sID, String name, int ordDelivered, int totOrdDelivered, Date date,
			double rating, double avgRating) {
		super();
		this.id = id;
		SID = sID;
		this.name = name;
		this.ordDelivered = ordDelivered;
		this.totOrdDelivered = totOrdDelivered;
		this.date = date;
		this.rating = rating;
		this.avgRating = avgRating;
	}

	public int getId() {
		return id;
	}

	public String getSID() {
		return SID;
	}

	public String getName() {
		return name;
	}

	public int getOrdDelivered() {
		return ordDelivered;
	}

	public int getTotOrdDelivered() {
		return totOrdDelivered;
	}

	
	public double getRating() {
		return rating;
	}

	public double getAvgRating() {
		return avgRating;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setSID(String sID) {
		SID = sID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOrdDelivered(int ordDelivered) {
		this.ordDelivered = ordDelivered;
	}

	public void setTotOrdDelivered(int totOrdDelivered) {
		this.totOrdDelivered = totOrdDelivered;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public void setAvgRating(double avgRating) {
		this.avgRating = avgRating;
	}

	
	
	
}
