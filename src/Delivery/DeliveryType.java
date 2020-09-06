package Delivery;

public class DeliveryType {

	private String typeName;
	private double charges;
	
	public DeliveryType(String typeName, double charges) {
		super();
		this.typeName = typeName;
		this.charges = charges;
	}

	public String getTypeName() {
		return typeName;
	}

	public double getCharges() {
		return charges;
	}

	
}
