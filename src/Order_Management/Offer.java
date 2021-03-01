package Order_Management;

public class Offer {
	
	
	private String offfname;
	private String desc;
	private float discount;
	private String image;
	

	public Offer(String offfname, String desc, float discount, String image) {
		super();
		this.offfname = offfname;
		this.desc = desc;
		this.discount = discount;
		this.image = image;
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


	public String getImage() {
		return image;
	}


	
}
