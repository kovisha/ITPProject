package Customer;

//------------------------------------ MODEL CLASS TO GET THE ORDERS OF CUSTOMERS --------------------------------------------------------
public class CustomerOrder {
	
	//attributes
	private int iD;
	private String userID;
	private String uName;
	private String address;
	private String email;
	private String dob;
	private String loyaltyCardNo;
	private String loyaltyExpiry;
	private int loyaltyPoints;
	private String phone;
	private String fName;
	private String lName;
	private String orderDate;
	private String orderID;
	
	//default constructor
	public CustomerOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	//overloaded constructor
	public CustomerOrder(int iD, String userID, String uName, String address, String email, String dob,
			String loyaltyCardNo, String loyaltyExpiry, int loyaltyPoints, String phone, String fName, String lName,
			String orderDate, String orderID) {
		super();
		this.iD = iD;
		this.userID = userID;
		this.uName = uName;
		this.address = address;
		this.email = email;
		this.dob = dob;
		this.loyaltyCardNo = loyaltyCardNo;
		this.loyaltyExpiry = loyaltyExpiry;
		this.loyaltyPoints = loyaltyPoints;
		this.phone = phone;
		this.fName = fName;
		this.lName = lName;
		this.orderDate = orderDate;
		this.orderID = orderID;
	}


	/******************************************** SETTERS AND GETTERS **************************************************************/
	public int getiD() {
		return iD;
	}


	public void setiD(int iD) {
		this.iD = iD;
	}


	public String getUserID() {
		return userID;
	}


	public void setUserID(String userID) {
		this.userID = userID;
	}


	public String getuName() {
		return uName;
	}


	public void setuName(String uName) {
		this.uName = uName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public String getLoyaltyCardNo() {
		return loyaltyCardNo;
	}


	public void setLoyaltyCardNo(String loyaltyCardNo) {
		this.loyaltyCardNo = loyaltyCardNo;
	}


	public String getLoyaltyExpiry() {
		return loyaltyExpiry;
	}


	public void setLoyaltyExpiry(String loyaltyExpiry) {
		this.loyaltyExpiry = loyaltyExpiry;
	}


	public int getLoyaltyPoints() {
		return loyaltyPoints;
	}


	public void setLoyaltyPoints(int loyaltyPoints) {
		this.loyaltyPoints = loyaltyPoints;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getfName() {
		return fName;
	}


	public void setfName(String fName) {
		this.fName = fName;
	}


	public String getlName() {
		return lName;
	}


	public void setlName(String lName) {
		this.lName = lName;
	}


	public String getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}


	public String getOrderID() {
		return orderID;
	}


	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	
	
	
	
	

}
