package Staff;


import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;



//import DBUtil.DBConnect;
//import Model.Staff;

public class StaffDBUtil {
	
	//Database connection form DBConnect
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	private static ResultSet rs1 = null;
	
	

	//Staff Insert
	public static boolean insertStaff(String staffFirstName, String staffLastName, String staffUserName,
			String staffPassword, String staffAddress, String staffemailAddress, String dob, String staffNIC,
			String categoryRel, String staffGender, String staffEPF, String joinedDate, String categoryJob,
			double staffBasicSalary, String mobNo, String homNo, Part img)
    {
       
        boolean isSuccess = false;
       
        StaffIDGenerator stfid = new StaffIDGenerator();		//Creating object for StaffIDGenerator class 
	    String staffID = stfid.staffIDgenerator();				//Assigning the new calue
       
        try{
            con = DBConnect.getConnection();					//Get the connection with the DB
            													//Insert query to insert
            String sql= "Insert into staff(userID,fname,lanme,userName,pw,address,email,dob,nic,religion,gender,EPFNo,joinedDate,jobTitle,basicSal,image) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            InputStream inp = img.getInputStream();				//img as InputStream
            PreparedStatement ps = con.prepareStatement(sql);	//creating a preparestatement type objecet with connection
            ps.setString(1,staffID);							//Passing each value to the releavent column number
            ps.setString(2,staffFirstName);
            ps.setString(3,staffLastName);
            ps.setString(4,staffUserName);
            ps.setString(5,staffPassword);
            ps.setString(6,staffAddress);
            ps.setString(7,staffemailAddress);
            ps.setString(8,dob);
            ps.setString(9,staffNIC);
            ps.setString(10,categoryRel);
            ps.setString(11,staffGender);
            ps.setString(12,staffEPF);
            ps.setString(13,joinedDate);
            ps.setString(14,categoryJob);
            ps.setDouble(15,staffBasicSalary);
            ps.setBlob(16,inp);
            													//Inserting the staff phone to a seperate table
            													//Insert query to insert staff
			
			  String sql1= "Insert into staffphone (userID,phone1,phone2) values(?,?,?)";
			  PreparedStatement ps1 = con.prepareStatement(sql1); 
			  ps1.setString(1,staffID);
			  ps1.setString(2,mobNo); 
			  ps1.setString(3,homNo);
			 
            
            
            
            int rs = ps.executeUpdate();						//Exectue update statement for staff
            
			
			int rs1 = ps1.executeUpdate();						//Exectue update statement for staffphone
			 
         
            if(rs > 0 && rs1 > 0) {								//IF both were task was succssfull
                isSuccess = true;
            }
            else {
                isSuccess = false;
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();								//Print exception type
        }
       
        return isSuccess;										//Retuen the boolean value true of false
    }

	
	
	
	//Retreive staff details from the DB
	public static List<Staff> getStaffList(ServletResponse response)
    {
        ArrayList<Staff> staff = new ArrayList<>();				//Create an arraytype list of object of Staff
        
        try {    
            
            con=DBConnect.getConnection();						//Get the connection with DB
            													//Query to retreive data from the DB
            PreparedStatement ps= con.prepareStatement("SELECT s.id,s.userID,s.fname,s.lanme,s.userName,s.pw,s.address,s.email,s.dob,s.nic,s.religion,s.gender,s.EPFNo,s.joinedDate,s.jobTitle,s.basicSal,s.image,sp.phone1,sp.phone2  FROM staff s JOIN staffphone sp ON (s.userID = sp.userID)");
            ResultSet rs=ps.executeQuery();						//store the the result in rs varibale of type ResultSet
            
            while(rs.next())									//Iterate through a column to retreive all row datas
            {

                
                int id = rs.getInt(1);							//Store each data in the relevant variable
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
				Blob img = rs.getBlob(17);
				String mobNo = rs.getString(18);
				String homNo = rs.getString(19);
                

                InputStream inputStream = img.getBinaryStream();			//Retrieve the image of which is in binary form BLOB
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;
                 
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                 
                byte[] imageBytes = outputStream.toByteArray();
                 
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                 
                inputStream.close();
                outputStream.close();
                
                
                
                //Retrieve constrcutor in DBUtil
                Staff s = new Staff(id,staffID,staffFirstName,staffLastName,staffUserName,staffPassword,staffAddress,staffemailAddress,dob,staffNIC,categoryRel,staffGender,staffEPF,joinedDate,categoryJob,staffBasicSalary,base64Image,mobNo,homNo);
				
				//passing book object to the array list object
				staff.add(s);
                
           
                
    
            }
            
        }
        catch(Exception ex) {
            ex.printStackTrace();				//Print exception type
        }
        
        return staff;							//Return staff value
    }
	


	//Delete staff
	public static boolean deleteStaff(String staffID) {
		
		try {
			
			con = DBConnect.getConnection();					//creating the connection
			stmt = con.createStatement();
			
			
			String sql = "delete from staff where userID = '"+staffID+"'"; //query to delete from the staff table
			
			String sql1 = "delete from staffphone where userID = '"+staffID+"'";	//query to delete from the staffphone table
			
			
			int rs = stmt.executeUpdate(sql);					//execute update result statement for staff
			int rs1 = stmt.executeUpdate(sql1);					//execute update result statement for staffphone
			
																//if result set value is greater than zero data has been deleted
			if(rs > 0  && rs1 > 0 ) {
				isSuccess = true;
			}else {
																//if result set value is less than zero data has not been deleted
				isSuccess = false;
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();								//Print exception type
		}
		//returning the boolean value
		return isSuccess;
	}

	
	
	//updateStaff	without image
	public static boolean updateStaff(String id,String staffID, String staffFirstName, String staffLastName, String staffUserName, 
			String staffPassword, String staffAddress, String staffemailAddress, String dob, String staffNIC, String categoryRel, String staffGender, String staffEPF, 
			String joinedDate, String categoryJob, double staffBasicSalary,String mobNo,String homNo) {
			
			try {
				
				con = DBConnect.getConnection();			//creating connection with the database
				stmt = con.createStatement();
				
															//Querry staff table
				String sql = "update staff set fname = '"+staffFirstName+"',lanme = '"+staffLastName+"',"
						+ "userName = '"+staffUserName+"',pw= '"+staffPassword+"',address = '"+staffAddress+"',email = '"+staffemailAddress+"',"
						+ "dob = '"+dob+"',nic = '"+staffNIC+"',religion = '"+categoryRel+"',gender = '"+staffGender+"',EPFNo = '"+staffEPF+"',"
						+ "joinedDate = '"+joinedDate+"',jobTitle = '"+categoryJob+"',basicSal = '"+staffBasicSalary+"'"
						+ "where userID = '"+staffID+"'";
															//Querry staffphone table
				String sql1 = "update staffphone set phone1 = '"+mobNo+"',phone2 = '"+homNo+"' where userID = '"+staffID+"'";
				
				

				
				int rs = stmt.executeUpdate(sql);			///Executeupdate and result of it for staff table
				
				int rs1 = stmt.executeUpdate(sql1);			///Executeupdate and result of it for staffphone table
				
															//if result set value is greater than zero data has been updated
				if( rs > 0  && rs1 > 0) {					//In both tables
					isSuccess =  true;
				}											//if result set value is less than zero data has not been updated
				else {
					isSuccess =  false;
				}
				
			}catch(Exception e) {
				e.printStackTrace();						//Print exception type
			}
			
			
			return isSuccess;								//return the boolean value
		}


	
	
	
	
	//Update staff with image
	public static boolean updateStaff2(String id, String staffID, String staffFirstName, String staffLastName,
			String staffUserName, String staffPassword, String staffAddress, String staffemailAddress, String dob,
			String staffNIC, String categoryRel, String staffGender, String staffEPF, String joinedDate,
			String categoryJob, double staffBasicSalary, String mobNo, String homNo, Part img) {
		
	
        boolean isSuccess = false;
       
        try{
            con = DBConnect.getConnection();
           
            String sql= "update staff set fname=?,lanme=?,userName=?,pw=?,address=?,email=?,dob=?,nic=?,religion=?,gender=?,EPFNo=?,joinedDate=?,jobTitle=?,basicSal=?,image=? where userID='"+staffID+"'";
            
            
            String sql1= "update staffphone set phone1=?, phone2=? where userID='"+staffID+"'";
            
            
            InputStream inp = img.getInputStream();
            PreparedStatement ps = con.prepareStatement(sql);
            PreparedStatement ps1 = con.prepareStatement(sql1);
            
            ps.setString(1,staffFirstName);
            ps.setString(2,staffLastName);
            ps.setString(3,staffUserName);
            ps.setString(4,staffPassword);
            ps.setString(5,staffAddress);
            ps.setString(6,staffemailAddress);
            ps.setString(7,dob);
            ps.setString(8,staffNIC);
            ps.setString(9,categoryRel);
            ps.setString(10,staffGender);
            ps.setString(11,staffEPF);
            ps.setString(12,joinedDate);
            ps.setString(13,categoryJob);
            ps.setDouble(14,staffBasicSalary);
            ps.setBlob(15,inp);
            
            
            ps1.setString(1,mobNo);
            ps1.setString(2,homNo);
            
            
            int rs = ps.executeUpdate();
            
            int rs1 = ps1.executeUpdate();
           
            if(rs > 0 && rs1 > 0) {
                isSuccess = true;
            }
            else {
                isSuccess = false;
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
       
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
	public static boolean insertStaffLeave(String staffID,String leaveDate,int workingDays,int totLeaveDays,int totHalfDays) {
		
		boolean isSuccess = false;
		
		try {
			//creating the connection with the database
			con = DBConnect.getConnection();
			
			stmt = con.createStatement();
			//Insert query
			String sql = "insert into udssuper.leave values( 0,'"+staffID+"','"+leaveDate+"','"+workingDays+"','"+totLeaveDays+"','"+totHalfDays+"')";
		
				int rs = stmt.executeUpdate(sql);
			 
			if(rs >  0) {
				//if rs > 0 assign true to isSuccess boolean value
				isSuccess = true;
			}else {
				//if rs < 0 assign false to isSuccess boolean value
				isSuccess = false;
			}
			 
		}catch(Exception e){
			e.printStackTrace();		//Print exception type
		}
		
		//return isSucces value to BookInsertServlet
		return isSuccess;
	}



	
	//Retrieve staff salary details
	public static List<Staff> getStaffSalaryList(String categoryMonth, String categoryYear){

		//creatting an array list type object of book
		ArrayList<Staff> staffSalary = new ArrayList<>();
		
		try {
			//creating connection with the database
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			String sql = "select s.fname,s.lanme,o.userId,o.otSUM,o.OTMonth,l.leaveSUM,l.halfSUM,l.leaveMonth,s.basicSal,l.workingDays\r\n" + 
					"from ot_month o,leave_month l,udssuper.staff s\r\n" + 
					"where o.userId = l.userId and o.userId = s.userID and month(o.OTMonth) = '"+categoryMonth+"' and year(o.OTMonth) = '"+categoryYear+"' and month(l.leaveMonth) = '"+categoryMonth+"' and year(l.leaveMonth) = '"+categoryYear+"'";
			
			
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				//Assigning all retrieved values to the respective variables . if the next boolean value is true
				
				
				//staffID,staffFirstName,staffLastName,staffUserName,staffPassword,staffAddress,staffemailAddress,DOB,staffNIC,categoryRel,staffGender,staffEPF,joinedDate,categoryJob,staffBasicSalary,mobNo,homNo
				
			
				
				String staffFirstName = rs.getString(1);
				String staffLastName = rs.getString(2);
				String staffID = rs.getString(3);
				int totOThours = rs.getInt(4);
				String OTMonth = rs.getString(5);
				int totLeaveDays = rs.getInt(6); 
				int totHalfDays = rs.getInt(7);
				String leaveMonth = rs.getString(8);
				double staffBasicSalary = rs.getDouble(9);
				int workingDays = rs.getInt(10); 
				
				//crrating an obect of book and pass all values to the constructor in the book class
				Staff s = new Staff(staffFirstName,staffLastName,staffID,totOThours,OTMonth,totLeaveDays,totHalfDays,leaveMonth,staffBasicSalary,workingDays);
				
				//passing book object to the array list object
				staffSalary.add(s);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//Returning the book array list object
		return staffSalary;
		
	}
	
	
	
	//Retreive staff leave detals
	public static List<Staff> getStaffLeaveList(String categoryMonth, String categoryYear){

														//creatting an array list type object of staff
		ArrayList<Staff> staffLeave = new ArrayList<>();
		
		
		try {
														//creating connection with the database
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
													//Query to retrieve details of leaves
			String sql = "select s.userID,s.fname,s.lanme,l.leaveMonth,l.workingDays,sum(l.totLeaveDays),sum(l.totHalfDays)\r\n" + 
					"from udssuper.leave l,udssuper.staff s\r\n" + 
					"where l.userId = s.userID and month(l.leaveMonth) = '"+categoryMonth+"' and year(l.leaveMonth) = '"+categoryYear+"'"
							+ "group by l.userId";
			
			
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				//Assigning all retrieved values to the respective variables . if the next boolean value is true
			
				String staffID = rs.getString(1);
				String staffFirstName = rs.getString(2);
				String staffLastName = rs.getString(3);
				String leaveMonth = rs.getString(4);
				int workingDays = rs.getInt(5); 
				int totLeaveDays = rs.getInt(6); 
				int totHalfDays = rs.getInt(7); 
				
													//Constructor to staff leaves
				Staff s = new Staff(staffID,staffFirstName,staffLastName,leaveMonth,workingDays,totLeaveDays,totHalfDays);
				
				staffLeave.add(s);					//passing staff object to the array list object
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();					//Print exception type
		}
		
		//Returning the staff array list object
		return staffLeave;
		
	}

	//Retrieve OT details
	public static List<Staff> getStaffOTList(String categoryMonth, String categoryYear){

		
		ArrayList<Staff> staffOT = new ArrayList<>(); //creatting an array list type object of staff
		
		
		try {
			
			con = DBConnect.getConnection(); 		//creating connection with the database
			stmt = con.createStatement();
			
		
													//Query to retrieve staff , and OT details 
		String sql = "select s.fname,s.lanme,s.userID,o.TotOThours,o.OTMonth\r\n" + 
					"from udssuper.staff s,udssuper.ot o\r\n" + 
					"where s.userID = o.userID and month(o.OTMonth) = '"+categoryMonth+"' and year(o.OTMonth) = '"+categoryYear+"' order by o.OTMonth ASC;";
			
		
			
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
													//Assigning all retrieved values to the respective variables . 
													//Iterate through each row
			
				String staffFirstName = rs.getString(1);
				String staffLastName = rs.getString(2);
				String staffID = rs.getString(3);
				int TotOThours = rs.getInt(4);
				String OTMonth = rs.getString(5);
				
				
				Staff s = new Staff(staffFirstName,staffLastName,staffID,TotOThours,OTMonth);	//Constructor for staff OT details
				
				staffOT.add(s);					//passing staffOT object to the array list object
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();				//Print exception type	
		}
		
		
		return staffOT;							//Returning the staffOT array list object
		
	}




	//Retreive details of deleted staff
	public static List<Staff> getStaffListDeleted(HttpServletResponse response) {
		 ArrayList<Staff> staff = new ArrayList<>();
	        
	        try {    
	            
	            con=DBConnect.getConnection(); 			//Get the connection
	            										//Query to retrieve
	            PreparedStatement ps= con.prepareStatement("SELECT s.id,s.userID,s.fname,s.lanme,s.userName,s.pw,s.address,s.email,s.dob,s.nic,s.religion,s.gender,s.EPFNo,s.joinedDate,s.jobTitle,s.basicSal,s.image,sp.phone1,sp.phone2  FROM staff_log s JOIN staffphone_log sp ON (s.userID = sp.userID)");
	            ResultSet rs=ps.executeQuery();			//Store the result
	            
	            while(rs.next())
	            {
					
	                
	                
	                int id = rs.getInt(1);				//Assign each values retrieved for the relevant variables
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
					Blob img = rs.getBlob(17);
					String mobNo = rs.getString(18);
					String homNo = rs.getString(19);
																		//Retrieve image of type BLOB and convert the binary
	                InputStream inputStream = img.getBinaryStream();
	                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	                byte[] buffer = new byte[4096];
	                int bytesRead = -1;
	                 
	                while ((bytesRead = inputStream.read(buffer)) != -1) {
	                    outputStream.write(buffer, 0, bytesRead);
	                }
	                 
	                byte[] imageBytes = outputStream.toByteArray();
	                 
	                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
	                 
	                inputStream.close();
	                outputStream.close();
	                													//Asssign retrieved values to the constructor
	                Staff s = new Staff(id,staffID,staffFirstName,staffLastName,staffUserName,staffPassword,staffAddress,staffemailAddress,dob,staffNIC,categoryRel,staffGender,staffEPF,joinedDate,categoryJob,staffBasicSalary,base64Image,mobNo,homNo);
					
					//passing book object to the array list object
					staff.add(s);										//Add all the data to staff return type 

	            }
	            
	        }
	        catch(Exception ex) {
	            ex.printStackTrace();									//Print exception type
	        }
	        
	        return staff;												//REturn the data retrived
	}




	//Insert a deleted staff again to the staff table
	public static boolean deleteReinsert(String staffID) {
		
		
		
		try {
			//creating the connection
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
													//query inserted values from the staff_log
			String sql = "delete from staff_log where userID = '"+staffID+"'";
			
													//query inserted values from the staffphone_log
			String sql1 = "delete from staffphone_log where userID = '"+staffID+"'";
			
			
			int rs = stmt.executeUpdate(sql);		//execute update statement for staff_log
			int rs1 = stmt.executeUpdate(sql1);		//execute update statement for staffphone_log
													//if result set value is greater than zero data has been deleted
			if(rs > 0  && rs1 > 0 ) {
				isSuccess = true;
			}else {
													//if result set value is less than zero data has not been deleted
				isSuccess = false;
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();					//Print exception type
		}
													//returning the boolean value
		return isSuccess;
	}






	
	
	
	
	
	
	
	
	
	
}
