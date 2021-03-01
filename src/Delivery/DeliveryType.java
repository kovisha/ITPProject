package Delivery;

public class DeliveryType {

	private int id;
	private String typeName;
	private double charges;
	
	

	public DeliveryType(int id, String typeName, double charges) {
		super();
		this.id = id;
		this.typeName = typeName;
		this.charges = charges;
	}

	public String getTypeName() {
		return typeName;
	}

	public double getCharges() {
		return charges;
	}
	
	public int getId() {
		return id;
	}


	
}
