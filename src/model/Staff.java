package model;

public class Staff {
 //staffID,staffFirstName,staffLastName,staffUserName,staffPassword,staffAddress,staffemailAddress,dob,staffNIC,categoryRel,staffGender,staffEPF,joinedDate,categoryJob,staffBasicSalary,mobNo,homNo
	                          
         
	
	
	int id;
	String staffID;
    String staffFirstName;
    String staffLastName;
    String staffUserName;
    String staffPassword;
    String staffAddress;
    String staffemailAddress;
    String dob;
    String staffNIC;
    String categoryRel;
    String staffGender;
    String staffEPF;
    String joinedDate;
    String categoryJob;
    double staffBasicSalary;
    private String filename;
    
    String mobNo;
    String homNo;
    
    
    
    //constructor


	public Staff(int id, String staffID, String staffFirstName, String staffLastName, String staffUserName,
			String staffPassword, String staffAddress, String staffemailAddress, String dob, String staffNIC,
			String categoryRel, String staffGender, String staffEPF, String joinedDate, String categoryJob,
			double staffBasicSalary,String filename, String mobNo, String homNo) {
		super();
		this.id = id;
		this.staffID = staffID;
		this.staffFirstName = staffFirstName;
		this.staffLastName = staffLastName;
		this.staffUserName = staffUserName;
		this.staffPassword = staffPassword;
		this.staffAddress = staffAddress;
		this.staffemailAddress = staffemailAddress;
		this.dob = dob;
		this.staffNIC = staffNIC;
		this.categoryRel = categoryRel;
		this.staffGender = staffGender;
		this.staffEPF = staffEPF;
		this.joinedDate = joinedDate;
		this.categoryJob = categoryJob;
		this.staffBasicSalary = staffBasicSalary;
		this.filename = filename;
		this.mobNo = mobNo;
		this.homNo = homNo;
	}



	public int getId() {
		return id;
	}



	public String getStaffID() {
		return staffID;
	}



	public String getStaffFirstName() {
		return staffFirstName;
	}



	public String getStaffLastName() {
		return staffLastName;
	}



	public String getStaffUserName() {
		return staffUserName;
	}



	public String getStaffPassword() {
		return staffPassword;
	}



	public String getStaffAddress() {
		return staffAddress;
	}



	public String getStaffemailAddress() {
		return staffemailAddress;
	}



	public String getDob() {
		return dob;
	}



	public String getStaffNIC() {
		return staffNIC;
	}



	public String getCategoryRel() {
		return categoryRel;
	}



	public String getStaffGender() {
		return staffGender;
	}



	public String getStaffEPF() {
		return staffEPF;
	}



	public String getJoinedDate() {
		return joinedDate;
	}



	public String getCategoryJob() {
		return categoryJob;
	}



	public double getStaffBasicSalary() {
		return staffBasicSalary;
	}



	public String getFilename() {
		return filename;
	}



	public String getMobNo() {
		return mobNo;
	}



	public String getHomNo() {
		return homNo;
	}



	public void setId(int id) {
		this.id = id;
	}



	public void setStaffID(String staffID) {
		this.staffID = staffID;
	}



	public void setStaffFirstName(String staffFirstName) {
		this.staffFirstName = staffFirstName;
	}



	public void setStaffLastName(String staffLastName) {
		this.staffLastName = staffLastName;
	}



	public void setStaffUserName(String staffUserName) {
		this.staffUserName = staffUserName;
	}



	public void setStaffPassword(String staffPassword) {
		this.staffPassword = staffPassword;
	}



	public void setStaffAddress(String staffAddress) {
		this.staffAddress = staffAddress;
	}



	public void setStaffemailAddress(String staffemailAddress) {
		this.staffemailAddress = staffemailAddress;
	}



	public void setDob(String dob) {
		this.dob = dob;
	}



	public void setStaffNIC(String staffNIC) {
		this.staffNIC = staffNIC;
	}



	public void setCategoryRel(String categoryRel) {
		this.categoryRel = categoryRel;
	}



	public void setStaffGender(String staffGender) {
		this.staffGender = staffGender;
	}



	public void setStaffEPF(String staffEPF) {
		this.staffEPF = staffEPF;
	}



	public void setJoinedDate(String joinedDate) {
		this.joinedDate = joinedDate;
	}



	public void setCategoryJob(String categoryJob) {
		this.categoryJob = categoryJob;
	}



	public void setStaffBasicSalary(double staffBasicSalary) {
		this.staffBasicSalary = staffBasicSalary;
	}



	public void setFilename(String filename) {
		this.filename = filename;
	}



	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}



	public void setHomNo(String homNo) {
		this.homNo = homNo;
	}

	
    
	/*
	 * public Staff(String staffFirstName, String staffLastName, String
	 * staffAddress, String staffemailAddress, String dOB, String staffGender,
	 * String staffNIC, String categoryRel, String joinedDate, String staffEPF,
	 * String categoryJob, int staffBasicSalary, String staffUserName, String
	 * staffPassword) { super(); this.staffFirstName = staffFirstName;
	 * this.staffLastName = staffLastName; this.staffAddress = staffAddress;
	 * this.staffemailAddress = staffemailAddress; DOB = dOB; this.staffGender =
	 * staffGender; this.staffNIC = staffNIC; this.categoryRel = categoryRel;
	 * this.joinedDate = joinedDate; this.staffEPF = staffEPF; this.categoryJob =
	 * categoryJob; this.staffBasicSalary = staffBasicSalary; this.staffUserName =
	 * staffUserName; this.staffPassword = staffPassword; }
	 * 
	 * 
	 * 
	 * public Staff(int id, String userID, String fname, String lname, String
	 * userName, String pw, String address, String email, String dob2, String nic,
	 * String religion, String gender, String epfNo, String joinDate, String
	 * jobTitle, double basicSal) { // TODO Auto-generated constructor stub }
	 * 
	 * 
	 */
	

	
    
	
}
