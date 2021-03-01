package Order_Management;

public class Category {
	
	private int id ; 
	private String catid;
	private String catName;


	

	public Category(int id, String catid, String catName) {
		super();
		this.id = id;
		this.catid = catid;
		this.catName = catName;
	}




	public int getId() {
		return id;
	}




	public String getCatid() {
		return catid;
	}




	public String getCatName() {
		return catName;
	}



}
