package Order_Management;

public class User {
	
	
	//variables
	//private int ID;
	private int iD;
	private String userID;
	private String uName;
	private String pw;
	private String address;
	private String email;
	private String dob;
	private String anniversary;
	private String occupation;
	private String loyaltyCardNo;
	private String loyaltyExpiry;
	private int loyaltyPoints;
	private String phone;
	private String fName;
	private String lName;


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(int iD, String userID, String uName, String pw, String address, String email, String dob,
			String anniversary, String occupation, String loyaltyCardNo, String loyaltyExpiry, int loyaltyPoints,
			String phone, String fName, String lName) {
		super();
		this.iD = iD;
		this.userID = userID;
		this.uName = uName;
		this.pw = pw;
		this.address = address;
		this.email = email;
		this.dob = dob;
		this.anniversary = anniversary;
		this.occupation = occupation;
		this.loyaltyCardNo = loyaltyCardNo;
		this.loyaltyExpiry = loyaltyExpiry;
		this.loyaltyPoints = loyaltyPoints;
		this.phone = phone;
		this.fName = fName;
		this.lName = lName;
	}


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


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
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


	public String getAnniversary() {
		return anniversary;
	}


	public void setAnniversary(String anniversary) {
		this.anniversary = anniversary;
	}


	public String getOccupation() {
		return occupation;
	}


	public void setOccupation(String occupation) {
		this.occupation = occupation;
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

	
	
	//constructor
	/*
	 * public User(int iD, String userID, String uName, String pw, String address,
	 * String email, String dob, String anniversary, String occupation, String
	 * loyaltyCardNo, String loyaltyExpiry, int loyaltyPoints, String phone, String
	 * fName , String lName) { super(); this.iD = iD; this.userID = userID;
	 * this.uName = uName; this.pw = pw; this.address = address; this.email = email;
	 * this.dob = dob; this.anniversary = anniversary; this.occupation = occupation;
	 * this.loyaltyCardNo = loyaltyCardNo; this.loyaltyExpiry = loyaltyExpiry;
	 * this.loyaltyPoints = loyaltyPoints; this.phone = phone; this.fName = fName;
	 * this.lName = lName; }
	 * 
	 * 
	 * //getters and setters public int getID() { return iD; }
	 * 
	 * public void setID(int iD) { iD = iD; }
	 * 
	 * 
	 * 
	 * public String getUserID() { return userID; }
	 * 
	 * public void setUserID(String userID) { userID = userID; }
	 * 
	 * 
	 * 
	 * public String getUName() { return uName; }
	 * 
	 * public void setUName(String uName) { uName = uName; }
	 * 
	 * 
	 * 
	 * public String getPw() { return pw; }
	 * 
	 * public void setPw(String pw) { this.pw = pw; }
	 * 
	 * 
	 * 
	 * 
	 * public String getAddress() { return address; }
	 * 
	 * public void setAddress(String address) { this.address = address; }
	 * 
	 * 
	 * 
	 * public String getEmail() { return email; }
	 * 
	 * public void setEmail(String email) { this.email = email; }
	 * 
	 * 
	 * 
	 * 
	 * public String getDob() { return dob; }
	 * 
	 * public void setDob(String dob) { this.dob = dob; }
	 * 
	 * 
	 * 
	 * 
	 * public String getAnniversary() { return anniversary; }
	 * 
	 * public void setAnniversary(String anniversary) { this.anniversary =
	 * anniversary; }
	 * 
	 * 
	 * 
	 * 
	 * public String getOccupation() { return occupation; }
	 * 
	 * public void setOccupation(String occupation) { this.occupation = occupation;
	 * }
	 * 
	 * 
	 * 
	 * 
	 * public String getLoyaltyCardNo() { return loyaltyCardNo; }
	 * 
	 * public void setLoyaltyCardNo(String loyaltyCardNo) { this.loyaltyCardNo =
	 * loyaltyCardNo; }
	 * 
	 * 
	 * 
	 * 
	 * public String getLoyaltyExpiry() { return loyaltyExpiry; }
	 * 
	 * public void setLoyaltyExpiry(String loyaltyExpiry) { this.loyaltyExpiry =
	 * loyaltyExpiry; }
	 * 
	 * 
	 * 
	 * 
	 * public int getLoyaltyPoints() { return loyaltyPoints; }
	 * 
	 * public void setLoyaltyPoints(int loyaltyPoints) { this.loyaltyPoints =
	 * loyaltyPoints; }
	 * 
	 * 
	 * 
	 * public String getPhone() { return phone; }
	 * 
	 * public void setPhone(String phone) { this.phone = phone; }
	 * 
	 * 
	 * 
	 * 
	 * public String getFName() { return fName; }
	 * 
	 * public void setFName(String fName) { this.fName = fName; }
	 * 
	 * 
	 * public String getLName() { return fName; }
	 * 
	 * public void setLName(String lName) { this.lName = lName; }
	 */
	
	
	
	
	
	
	
	
	
	

}
