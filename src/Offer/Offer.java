package Offer;

import java.io.OutputStream;
import java.sql.Blob;

public class Offer {
	private int id;
	private String offerId;
	private String name;
	private String desc;
	private float discP;
	private String status;
	private double orderMinAmount;
	private double orderMaxAmount;
	private String image;
	
	public Offer(int id, String offerId, String name, String desc, float discP, String status, double orderMinAmount,
			double orderMaxAmount, String image) {
		super();
		this.id = id;
		this.offerId = offerId;
		this.name = name;
		this.desc = desc;
		this.discP = discP;
		this.status = status;
		this.orderMinAmount = orderMinAmount;
		this.orderMaxAmount = orderMaxAmount;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public String getOfferId() {
		return offerId;
	}

	public String getName() {
		return name;
	}

	public String getDesc() {
		return desc;
	}

	public float getDiscP() {
		return discP;
	}

	public String getStatus() {
		return status;
	}

	public double getOrderMinAmount() {
		return orderMinAmount;
	}

	public double getOrderMaxAmount() {
		return orderMaxAmount;
	}

	public String getImage() {
		return image;
	}

}
