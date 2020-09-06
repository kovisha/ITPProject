package DBUtil;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DBUtil.DBConnect;
import model.Staff;

public class StaffDBUtil {
	
	//Database connection form DBConnect
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	private static ResultSet rs1 = null;
	
	
	
	
	 /*
	  * 
	  * String staffFirstName =  request.getParameter("staffFirstName");
   String staffLastName =  request.getParameter("staffLastName");
   String staffAddress =  request.getParameter("staffAddress");
   String staffemailAddress =  request.getParameter("staffemailAddress");
   String DOB =  request.getParameter("DOB");
   String staffGender =  request.getParameter("staffGender");
   String staffNIC =  request.getParameter("staffNIC");
   String categoryRel =  request.getParameter("categoryRel");
   String joinedDate =  request.getParameter("joinedDate");
   String staffEPF =  request.getParameter("staffEPF");
   String categoryJob =  request.getParameter("categoryJob");
   int staffBasicSalary = Integer.parseInt(request.getParameter("staffBasicSalary"));
   String staffUserName =  request.getParameter("staffUserName");
   String staffPassword =  request.getParameter("staffPassword");
	  * 
	  * */
	
	
	
	
	
	//Mehtod to insert a new book to the data base
	public static boolean insertStaff(String staffID, String staffFirstName, String staffLastName, String staffUserName, 
			String staffPassword, String staffAddress, String staffemailAddress, String dob, String staffNIC, String categoryRel, String staffGender, String staffEPF, 
			String joinedDate, String categoryJob, double staffBasicSalary,String mobNo,String homNo,String filename , String path) {
		
		
		
			
		
		
		boolean isSuccess = false;
		
		
		
		try {
			//creating the connection with the database
			con = DBConnect.getConnection();
			
			stmt = con.createStatement();
			//Insert query
			String sql = "Insert into staff values( 0,'"+staffID+"','"+staffFirstName+"','"+staffLastName+"','"+staffUserName+"','"+staffPassword+"','"+staffAddress+"',"
				+ "'"+staffemailAddress+"','"+dob+"','"+staffNIC+"','"+categoryRel+"','"+staffGender+"','"+staffEPF+"','"+joinedDate+"','"+categoryJob+"','"+staffBasicSalary+"',NULL,'"+filename+"','"+path+"')";
			
			
			//Insert querry for mobile numbers
			String sql1 = "Insert into staffphone values(0,'"+staffID+"','"+mobNo+"','"+homNo+"')";
			
			int rs = stmt.executeUpdate(sql);
			
			int rs1 = stmt.executeUpdate(sql1);
			 
			if(rs > 0 && rs1 > 0) {
				//if rs > 0 assign true to isSuccess boolean value
				isSuccess = true;
			}else {
				//if rs < 0 assign false to isSuccess boolean value
				isSuccess = false;
			}
			 
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		//return isSucces value to BookInsertServlet
		return isSuccess;
	}
	
	
	//staffID,staffFirstName,staffLastName,staffUserName,staffPassword,staffAddress,staffemailAddress,DOB,staffNIC,categoryRel,staffGender,staffEPF,joinedDate,categoryJob,staffBasicSalary,mobNo,homNo
	
	//Method to retrive all rows and display from the book tabe in database
	//Return type list of the book with all data
	public static List<Staff> getStaffList(){

		//creatting an array list type object of book
		ArrayList<Staff> staff = new ArrayList<>();
		
		
		try {
			//creating connection with the database
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			//query
			//String sql = "select * from staff";
			//String sql = "select s.userID,s.fname,s.lanme,s.userName,s.pw,s.address,s.email,s.dob,s.nic,s.religion,s.gender,s.EPFNo,s.joinedDate,s.jobTitle,s.basicSal,sp.phone1,sp.phone2  from staff s, staffphone sp where s.userID = sp.userID";
			//String sql = "s.staffID,s.staffFirstName,s.staffLastName,s.staffUserName,s.staffPassword,s.staffAddress,s.staffemailAddress,s.dob,s.staffNIC,s.categoryRel,s.staffGender,s.staffEPF,s.joinedDate,s.categoryJob,s.staffBasicSalary,sp.mobNo,sp.homNo FROM staff s JOIN staffphone sp WHERE s.userID = sp.staffphone";
			
			String sql = "SELECT s.id,s.userID,s.fname,s.lanme,s.userName,s.pw,s.address,s.email,s.dob,s.nic,s.religion,s.gender,s.EPFNo,s.joinedDate,s.jobTitle,s.basicSal,s.filename,s.path,sp.phone1,sp.phone2  \r\n" + 
					"			FROM staff s JOIN staffphone sp\r\n" + 
					"			ON (s.userID = sp.userID)"; 
			
			
			
			//String sql = "SELECT *\r\n" + 
			//		"			FROM staff s JOIN staffphone sp\r\n" + 
			//		"			ON (s.userID = sp.userID);";
			
			

			
			
			
			
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				//Assigning all retrieved values to the respective variables . if the next boolean value is true
				
				
				//staffID,staffFirstName,staffLastName,staffUserName,staffPassword,staffAddress,staffemailAddress,DOB,staffNIC,categoryRel,staffGender,staffEPF,joinedDate,categoryJob,staffBasicSalary,mobNo,homNo
				
				
				
				int id = rs.getInt(1);
				String staffID = rs.getString(2);
				String staffFirstName = rs.getString(3);
				String staffLastName = rs.getString(4);
				String staffUserName = rs.getString(5);
				String staffPassword = rs.getString(6);
				String staffAddress = rs.getString(7);
				String staffemailAddress = rs.getString(8);
				String dob = rs.getString(9);
				String staffNIC = rs.getString(10);
				String categoryRel = rs.getString(11);
				String staffGender = rs.getString(12);
				String staffEPF = rs.getString(13);
				String joinedDate = rs.getString(14);
				String categoryJob = rs.getString(15);
				double staffBasicSalary = rs.getDouble(16);
				String filename = rs.getString(17);
				String path = rs.getString(18);
				String mobNo = rs.getString(19);
				String homNo = rs.getString(20);
				
				//crrating an obect of book and pass all values to the constructor in the book class
				
				
				//staffID,staffFirstName,staffLastName,staffUserName,staffPassword,staffAddress,staffemailAddress,DOB,staffNIC,categoryRel,staffGender,staffEPF,joinedDate,categoryJob,staffBasicSalary,mobNo,homNo
				
				
				Staff s = new Staff(id,staffID,staffFirstName,staffLastName,staffUserName,staffPassword,staffAddress,staffemailAddress,dob,staffNIC,categoryRel,staffGender,staffEPF,joinedDate,categoryJob,staffBasicSalary,filename,mobNo,homNo);
				
				//passing book object to the array list object
				staff.add(s);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//Returning the book array list object
		return staff;
		
	}
	
	


	//Method to delete a specific data from the table using the passed id
	public static boolean deleteStaff(String id) {
		
		int idStaff = Integer.parseInt(id);
		
		try {
			//creating the connection
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			//query
			String sql = "delete from staff where id = '"+idStaff+"'";
			int rs = stmt.executeUpdate(sql);
			//if result set value is greater than zero data has been deleted
			if(rs > 0) {
				isSuccess = true;
			}else {
				//if result set value is less than zero data has not been deleted
				isSuccess = false;
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		//returning the boolean value
		return isSuccess;
	}

	
	
	//Method to update the book data. This return a boolean value weather the data has been updated to the databse or not	
	public static boolean updateStaff(String id,String staffID, String staffFirstName, String staffLastName, String staffUserName, 
			String staffPassword, String staffAddress, String staffemailAddress, String dob, String staffNIC, String categoryRel, String staffGender, String staffEPF, 
			String joinedDate, String categoryJob, double staffBasicSalary,String mobNo,String homNo,String filename , String path) {
			
			try {
				
				//creating connection with the database
				con = DBConnect.getConnection();
				stmt = con.createStatement();
				
				//Querry
				String sql = "update staff set userID = '"+staffID+"',fname = '"+staffFirstName+"',lanme = '"+staffLastName+"',"
						+ "userName = '"+staffUserName+"',pw= '"+staffPassword+"',address = '"+staffAddress+"',email = '"+staffemailAddress+"',"
						+ "dob = '"+dob+"',nic = '"+staffNIC+"',religion = '"+categoryRel+"',gender = '"+staffGender+"',EPFNo = '"+staffEPF+"',"
						+ "joinedDate = '"+joinedDate+"',jobTitle = '"+categoryJob+"',basicSal = '"+staffBasicSalary+"',filename = '"+filename+"',path = '"+path+"'"
						+ "where id = '"+id+"'";
				
				

				
			//	String sql1 = "update staff set userID = '"+staffID+"',phone1 = '"+mobNo+"',phone2 = '"+homNo+"'"
			//			+ "where id = '"+id+"'";
				
				
				
				int rs = stmt.executeUpdate(sql);
				
				//if result set value is greater than zero data has been updated
				if( rs > 0 ) {
					isSuccess =  true;
				}//if result set value is less than zero data has not been updated
				else {
					isSuccess =  false;
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			//return the boolean value
			return isSuccess;
		}


	
	
	//Mehtod to insert a new book to the data base

	public static boolean insertStaffOT(String staffID,String otDate,String otHours) {
		
			
		
		
		boolean isSuccess = false;
		
		
		
		try {
			//creating the connection with the database
			con = DBConnect.getConnection();
			
			stmt = con.createStatement();
			//Insert query
			String sql = "Insert into ot values( 0,'"+staffID+"','"+otDate+"','"+otHours+"')";
			
			
			int rs = stmt.executeUpdate(sql);
			

			 
			if(rs >  0) {
				//if rs > 0 assign true to isSuccess boolean value
				isSuccess = true;
			}else {
				//if rs < 0 assign false to isSuccess boolean value
				isSuccess = false;
			}
			 
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		//return isSucces value to BookInsertServlet
		return isSuccess;
	}
	
	//insertStaffLeave
	//Mehtod to insert a new book to the data base

	public static boolean insertStaffLeave(String staffID,String leaveDate,String leaveDays) {
		
			
		
		
		boolean isSuccess = false;
		
		
		
		try {
			//creating the connection with the database
			con = DBConnect.getConnection();
			
			stmt = con.createStatement();
			//Insert query
			String sql = "Insert into leave values( 0,'"+staffID+"','"+leaveDate+"','"+leaveDays+"')";
			
			
			int rs = stmt.executeUpdate(sql);
			

			 
			if(rs >  0) {
				//if rs > 0 assign true to isSuccess boolean value
				isSuccess = true;
			}else {
				//if rs < 0 assign false to isSuccess boolean value
				isSuccess = false;
			}
			 
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		//return isSucces value to BookInsertServlet
		return isSuccess;
	}
	
}
