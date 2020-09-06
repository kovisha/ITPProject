package User;

public class Offer {
	
	
	private String offfname;
	private String desc;
	private float discount;
	
	
	public Offer( String offfname, String desc, float discount) {
		
		
		this.offfname = offfname;
		this.desc = desc;
		this.discount = discount;
	}
	
	
	public String getOfffname() {
		return offfname;
	}

	public String getDesc() {
		return desc;
	}

	public float getDiscount() {
		return discount;
	}

	
}
