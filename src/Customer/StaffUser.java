package Customer;

//------------------------------------ MODEL CLASS OF CUSTOMERS --------------------------------------------------------
public class StaffUser {
	
	//variables
	private int id;
	private String userID;
	private String fname;
	private String lname;
	private String userName;
	private String pw;
	private String address;
	private String email;
	private String dob;
	private String nic;
	private String religion;
	private String gender;
	private int epfNo;
	private String joinedDate;
	private String jobTitle;
	private double basicSal;
	
	//default constructor
	public StaffUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	//overloaded constructor
	public StaffUser(int id, String userID, String fname, String lname, String userName, String pw, String address,
			String email, String dob, String nic, String religion, String gender, int epfNo, String joinedDate,
			String jobTitle, double basicSal) {
		super();
		this.id = id;
		this.userID = userID;
		this.fname = fname;
		this.lname = lname;
		this.userName = userName;
		this.pw = pw;
		this.address = address;
		this.email = email;
		this.dob = dob;
		this.nic = nic;
		this.religion = religion;
		this.gender = gender;
		this.epfNo = epfNo;
		this.joinedDate = joinedDate;
		this.jobTitle = jobTitle;
		this.basicSal = basicSal;
	}


	/******************************************** SETTERS AND GETTERS **************************************************************/
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUserID() {
		return userID;
	}


	public void setUserID(String userID) {
		this.userID = userID;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
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


	public String getNic() {
		return nic;
	}


	public void setNic(String nic) {
		this.nic = nic;
	}


	public String getReligion() {
		return religion;
	}


	public void setReligion(String religion) {
		this.religion = religion;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public int getEpfNo() {
		return epfNo;
	}


	public void setEpfNo(int epfNo) {
		this.epfNo = epfNo;
	}


	public String getJoinedDate() {
		return joinedDate;
	}


	public void setJoinedDate(String joinedDate) {
		this.joinedDate = joinedDate;
	}


	public String getJobTitle() {
		return jobTitle;
	}


	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}


	public double getBasicSal() {
		return basicSal;
	}


	public void setBasicSal(double basicSal) {
		this.basicSal = basicSal;
	}
	
	
	
	
	

}
