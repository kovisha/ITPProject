package Staff;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
    String image;
   
    String mobNo;
    String homNo;
    
    String OTMonth;
    int totOThours;
	
	

    //Leave

	String leaveMonth;
	int leavedays;
	int workingDays;
	int totLeaveDays;
	int totHalfDays;
	double leaveDeductAmnt;
	double halfdayDeductAmnt;
	
	double salary;
	
	




	//EPF calculation
	double epfEmployerContribution;
	double epfEmployeeContribution;
    double epf;
    
    //OT
    double otRate;
    double otAmount;
	/* int otHours; */
	
    //ETF
    double etf;
	
	 

  
    
    
    //constructor

	

	//Common constructor

	public Staff(int id, String staffID, String staffFirstName, String staffLastName, String staffUserName,
			String staffPassword, String staffAddress, String staffemailAddress, String dob, String staffNIC,
			String categoryRel, String staffGender, String staffEPF, String joinedDate, String categoryJob,
			double staffBasicSalary, String filename, String mobNo, String homNo, String oTMonth, int totOThours,
			String leaveMonth, int leavedays, int workingDays, int totLeaveDays, int totHalfDays,
			double leaveDeductAmnt, double halfdayDeductAmnt, double epfEmployerContribution,
			double epfEmployeeContribution, double epf, double otRate, double otAmount, double etf) {
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
		
		this.mobNo = mobNo;
		this.homNo = homNo;
		OTMonth = oTMonth;
		this.totOThours = totOThours;
		this.leaveMonth = leaveMonth;
		this.leavedays = leavedays;
		this.workingDays = workingDays;
		this.totLeaveDays = totLeaveDays;
		this.totHalfDays = totHalfDays;
		this.leaveDeductAmnt = leaveDeductAmnt;
		this.halfdayDeductAmnt = halfdayDeductAmnt;
		this.epfEmployerContribution = epfEmployerContribution;
		this.epfEmployeeContribution = epfEmployeeContribution;
		this.epf = epf;
		this.otRate = otRate;
		this.otAmount = otAmount;
		this.etf = etf;
	}




	//Constructor for leave
	public Staff(String staffID, String staffFirstName, String staffLastName, String leaveMonth, int workingDays,
			int totLeaveDays, int totHalfDays) {
		
		this.staffID = staffID;
		this.staffFirstName = staffFirstName;
		this.staffLastName = staffLastName;
		this.leaveMonth = leaveMonth;
		this.workingDays = workingDays;
		this.totLeaveDays = totLeaveDays;
		this.totHalfDays = totHalfDays;
		
		
		
		
	}
	

	

	//Constructor ot leave and salary details
	public Staff(String staffFirstName2, String staffLastName2, String staffID2, double staffBasicSalary2,
			String otMonth2, int otHours2, String leaveMonth2, int leavedays2) {
		// TODO Auto-generated constructor stub
	}

	//constructor ot details
	public Staff(String staffFirstName2, String staffLastName2, String staffID2, int totOThours2, String oTMonth2) {
		// TODO Auto-generated constructor stub
		this.staffFirstName = staffFirstName2;
		this.staffLastName = staffLastName2;
		this.staffID = staffID2;
		this.totOThours = totOThours2;
		this.OTMonth = oTMonth2;
	}


	//Constructor leave and ot and salary details
	public Staff(String staffFirstName2, String staffLastName2, String staffID2, int totOThours2, String oTMonth2,
			int totLeaveDays2, int totHalfDays2, String leaveMonth2, double staffBasicSalary2, int workingDays2) {
		// TODO Auto-generated constructor stub
		this.staffFirstName = staffFirstName2;
		this.staffLastName = staffLastName2;
		this.staffID = staffID2;
		this.totOThours = totOThours2;
		this.OTMonth = oTMonth2;
		this.totLeaveDays = totLeaveDays2;
		this.totHalfDays = totHalfDays2;
		this.leaveMonth = leaveMonth2;
		this.staffBasicSalary = staffBasicSalary2;
		this.workingDays = workingDays2;
	}



	
	//Constructor staff and salary details of an deleted staff
	public Staff(int id, String staffID, String staffFirstName, String staffLastName, String staffUserName,
			String staffPassword, String staffAddress, String staffemailAddress, String dob, String staffNIC,
			String categoryRel, String staffGender, String staffEPF, String joinedDate, String categoryJob,
			double staffBasicSalary, String image, String mobNo, String homNo) {
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
		this.image = image;
		this.mobNo = mobNo;
		this.homNo = homNo;
	}


	

	//Constructor to staffDetails
	public Staff(int id2, String staffID2, String staffFirstName2, String staffLastName2, String staffUserName2,
			String staffPassword2, String staffAddress2, String staffemailAddress2, String dob2, String staffNIC2,
			String categoryRel2, String staffGender2, String staffEPF2, String joinedDate2, String categoryJob2,
			double staffBasicSalary2, String mobNo2, String homNo2) {
		// TODO Auto-generated constructor stub
	}


	//Getters and Setters for workingDays 
	public int getWorkingDays() {
		return workingDays;
	}




	public void setWorkingDays(int workingDays) {
		this.workingDays = workingDays;
	}

	//Getters and Setters for totLeaveDays
	public int getTotLeaveDays() {
		return totLeaveDays;
	}


	public void setTotLeaveDays(int totLeaveDays) {
		this.totLeaveDays = totLeaveDays;
	}


	//Getters and Setters for totHalfDays
	public int getTotHalfDays() {
		return totHalfDays;
	}


	public void setTotHalfDays(int totHalfDays) {
		this.totHalfDays = totHalfDays;
	}


	
	//Getters and Setters for OTMonth

	public String getOTMonth() {
		return OTMonth;
	}


	public void setOTMonth(String oTMonth) {
		OTMonth = oTMonth;
	}

	//Getters and Setters for totOThours
	public int getTotOThours() {
		return totOThours;
	}


	public void setTotOThours(int totOThours) {
		this.totOThours = totOThours;
	}

	
	//Setter for id
	public void setId(int id) {
		this.id = id;
	}

	//Setter for dob
	public void setDob(String dob) {
		this.dob = dob;
	}

	//Setter for categoryRel
	public void setCategoryRel(String categoryRel) {
		this.categoryRel = categoryRel;
	}

	//Setter for joinedDate
	public void setJoinedDate(String joinedDate) {
		this.joinedDate = joinedDate;
	}

	//Setter for categoryJob
	public void setCategoryJob(String categoryJob) {
		this.categoryJob = categoryJob;
	}


	
	//Setter for homNo
	public void setHomNo(String homNo) {
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



	public String getStaffAddress() {
		return staffAddress;
	}



	public String getStaffemailAddress() {
		return staffemailAddress;
	}



	public String getDob() {
		return dob;
	}



	public String getStaffGender() {
		return staffGender;
	}



	public String getStaffNIC() {
		return staffNIC;
	}



	public String getCategoryRel() {
		return categoryRel;
	}



	public String getJoinedDate() {
		return joinedDate;
	}



	public String getStaffEPF() {
		return staffEPF;
	}



	public String getCategoryJob() {
		return categoryJob;
	}



	public double getStaffBasicSalary() {
		return staffBasicSalary;
	}



	public String getStaffUserName() {
		return staffUserName;
	}



	public String getStaffPassword() {
		return staffPassword;
	}



	public String getMobNo() {
		return mobNo;
	}



	public String getHomNo() {
		return homNo;
	}


	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}

	public String getLeaveMonth() {
		return leaveMonth;
	}


	public void setLeaveMonth(String leaveMonth) {
		this.leaveMonth = leaveMonth;
	}


	public int getLeavedays() {
		return leavedays;
	}


	public void setLeavedays(int leavedays) {
		this.leavedays = leavedays;
	}


	//EPF calculation
	
	
	public double getEpfEmployerContribution() {
		
		epfEmployerContribution = staffBasicSalary * 12 / 100;
		
		return epfEmployerContribution;
	}


	public void setEpfEmployerContribution(double epfEmployerContribution) {
		this.epfEmployerContribution = epfEmployerContribution;
	}


	public double getEpfEmployeeContribution() {
		
		epfEmployeeContribution = staffBasicSalary * 8 / 100;
		
		return epfEmployeeContribution;
		
	}


	public void setEpfEmployeeContribution(double epfEmployeeContribution) {
		this.epfEmployeeContribution = epfEmployeeContribution;
	}


	public double getEpf() {
		
		epf = staffBasicSalary * 12 / 100 + staffBasicSalary * 8 / 100;
		
		return epf;
	}


	public void setEpf(double epf) {
		this.epf = epf;
	}

	
    //OT calculation
	public double getOtRate() {
	
		otRate = staffBasicSalary * 1.5 /240;
		
		return otRate;
	}

	public void setOtRate(double otRate) {
		this.otRate = otRate;
	}


	//OT Amount calculation
	 public double getOtAmount() {
	  
	  otAmount = getTotOThours() * staffBasicSalary * 1.5 /240;
	  
	  return otAmount; }
	 


	public void setOtAmount(double otAmount) {
		this.otAmount = otAmount;
	}
	
	
	
	
	//ETF calculation
	
	public double getEtf() {
		
		etf = staffBasicSalary * 3 / 100;
		
		return etf;
	}


	public void setEtf(double etf) {
		this.etf = etf;
	}

	
    
	//Leave deductions calculation
	
	public double getLeaveDeductAmnt() {
		
		double num = staffBasicSalary * totLeaveDays / workingDays;
		
		 BigDecimal bd = new BigDecimal(num).setScale(2, RoundingMode.HALF_UP);
		 leaveDeductAmnt = bd.doubleValue();
		
		return leaveDeductAmnt;
	}


	public void setLeaveDeductAmnt(double leaveDeductAmnt) {
		this.leaveDeductAmnt = leaveDeductAmnt;
	}


	//Half day dedcution calculation
	public double getHalfdayDeductAmnt() {
		
		double num = staffBasicSalary * totHalfDays / (workingDays * 2);
		
		 BigDecimal bd = new BigDecimal(num).setScale(2, RoundingMode.HALF_UP);
		 halfdayDeductAmnt = bd.doubleValue();
		
		return halfdayDeductAmnt;
	}


	public void setHalfdayDeductAmnt(double halfdayDeductAmnt) {
		this.halfdayDeductAmnt = halfdayDeductAmnt;
	}
	

	//Basic salary calculation
	public double getSalary() {
		
		double num = (staffBasicSalary - epfEmployeeContribution) + otAmount - (leaveDeductAmnt + halfdayDeductAmnt);
		
		BigDecimal bd = new BigDecimal(num).setScale(2, RoundingMode.HALF_UP);
		salary = bd.doubleValue();
		
		
		
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}
	
}
