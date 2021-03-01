package package1;

public class Supplier {

	private int id;
	private String stockname;
	private float stocksize;
	private String supplierID;
	private String name;
	private String status;
	private String address;
	private String email;
	private String phone1;
	private String phone2;
	private String description;
	
	/*********************************************************************************Constructors****************************************************************/
	
	public Supplier(int id, String supplierID, String name, String status, String address, String email,String phone1, String phone2,String description) {
		 
		super();
		this.id = id;
		this.supplierID = supplierID;
		this.name = name;
		this.status = status;
		this.address = address;
		this.email = email;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.description = description;
	}
	
	public Supplier(String supplierID, String name, String status, String address, String email, String phone1,
			String phone2, String description) {
		super();
		this.supplierID = supplierID;
		this.name = name;
		this.status = status;
		this.address = address;
		this.email = email;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.description = description;
	}

	public Supplier(String supplierID, String name,String stockname, float stocksize, String status, String address,
			String email, String phone1, String phone2, String description) {
		super();
		
		this.supplierID = supplierID;
		this.name = name;
		this.stockname = stockname;
		this.stocksize = stocksize;
		this.status = status;
		this.address = address;
		this.email = email;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.description = description;
	}
	
	public Supplier( String name,String stockname, float stocksize) {
	super();
	this.name = name;
	this.stockname = stockname;
	this.stocksize = stocksize;
	
	}

	/*********************************************************************Getters & Setters***********************************************************/
	
	public int getId() {
		return id;
	}
	
	public float getStocksize() {
		return stocksize;
	}

	public String getStockname() {
		return stockname;
	}

	public String getSupplierID() {
		return supplierID;
	}

	public String getName() {
		return name;
	}

	public String getStatus() {
		return status;
	}

	public String getAddress() {
		return address;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone1() {
		return phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public String getDescription() {
		return description;
	}

}
