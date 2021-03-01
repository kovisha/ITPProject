package Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class adminDAO {
	
	
	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	private static Statement st = null;
	
	
	//-------------------method to validate the presence of the logged admin----------------------------------------------
	public  boolean validateAdmin(String userName , String pw)
	{
		boolean status = false;

		try {

			//1. making the connection
			con=DBManager.getConnection(); 

			//2. create a statement using connection object
			ps = con.prepareStatement("select userName , pw  from staff where userName = ? and pw = ? ") ;


			ps.setString(1, userName);
			ps.setString(2 , pw);


			System.out.println(ps);

			//3.execute the query
			rs = ps.executeQuery();
			status = rs.next();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return status;
	}
	
			
			
			
			 public static StaffUser checkAdmin(String username, String password) {
				 
					String sqlQuery = "select * from staff where userName=? and pw=?";
					
					StaffUser loggedStaff = new StaffUser();
					
					try {
						
						//1. making the connection
						  con=DBManager.getConnection(); 
						 
						  //2.create a statement using connection object
						 ps = con.prepareStatement(sqlQuery) ;
						 
						 ps.setString(1, username);
						 ps.setString(2, password);
						 
						 
						 //3.execute the query
						  rs = ps.executeQuery();
						 
						 while(rs.next()) {
							 loggedStaff.setId(rs.getInt(1));
							 loggedStaff.setUserID(rs.getString(2));
							 loggedStaff.setFname(rs.getString(3));
							 loggedStaff.setLname(rs.getString(4));
						   	 loggedStaff.setUserName(rs.getString(5));
							 loggedStaff.setPw(rs.getString(6));
							 loggedStaff.setAddress(rs.getString(7));
							 loggedStaff.setEmail(rs.getString(8));
							 loggedStaff.setDob(rs.getString(9));
							 loggedStaff.setNic(rs.getString(10));
							 loggedStaff.setReligion(rs.getString(11));
							 loggedStaff.setGender(rs.getString(12));
							 loggedStaff.setEpfNo(rs.getInt(13));
							 loggedStaff.setJoinedDate(rs.getString(14));
							 loggedStaff.setJobTitle(rs.getString(15));
							 loggedStaff.setBasicSal(rs.getDouble(16));
								
								
								
					}
					}
					catch(Exception e)
					{
						e.printStackTrace();
						
					}
					return loggedStaff;		
			 
					}
			 
			
			
		//-------------------------------retrieving Active Users------------------------------------------------
			public static List<CustomerOrder> getAllUsers() throws Exception{
				
				LocalDate ld = java.time.LocalDate.now();
				LocalDate lastOrder = ld.minusMonths(10);
		    	
					ArrayList<CustomerOrder> custOrder = new ArrayList<>();
					
					try { 
					   
						con = DBManager.getConnection();//establishing connection
					    st = con.createStatement();
					    
					    String sql = "SELECT c.ID , c.UserID , c.UName, c.fname , c.lname , c.address , c.email, c.phone, c.dob , o.orderID , o.date, c.loyaltyCardNo , c.loyaltyExpiry, c.loyalyPoints FROM uds_super_db.customer c, uds_super_db.order o  WHERE UserID = uid  GROUP BY c.UName ORDER BY o.date desc ;" ;
					    rs = st.executeQuery(sql);//execute query
					    
					    while(rs.next()) {
					    	int id = rs.getInt(1);
							String userID = rs.getString(2);
							String uName = rs.getString(3);
							//String pw = rs.getString(4);
							String fname = rs.getString(4);
							String lname = rs.getString(5);
							String address = rs.getString(6);
							String email = rs.getString(7);
							String phone = rs.getString(8);
							String dob = rs.getString(9);
							String orderID = rs.getString(10);
							String orderDate = rs.getString(11);
							String loyaltyCardNo = rs.getString(12);
							String loyaltyExpiry = rs.getString(13);
							int loyaltyPoints = rs.getInt(14);
						//String user = rs.getString(8);
						
						//create a new instance to retrieve data
						CustomerOrder u = new CustomerOrder(id, userID , uName , address , email , dob , loyaltyCardNo ,loyaltyExpiry , loyaltyPoints , phone , fname , lname , orderDate, orderID);
						custOrder.add(u);
					    }
					    
					}
					catch(Exception e) {
					    e.printStackTrace();
					}
					
					return custOrder;
					
				    }
			 
			
			//-------------------------------------Delete customer----------------------------------------------------
			public static boolean deleteCust(String id) {
				
				boolean isSuccess=false;
			    	
			    	try {
			    		
			    		con = DBManager.getConnection();//establishing connection
			    		st = con.createStatement();
			    		
			    		String sql = "DELETE FROM customer WHERE UserID='"+id+"' ";//deleting details
			    		int rs = st.executeUpdate(sql);//execute query
			    		
			    		//if deleted successfully returns true else false
			    		if(rs > 0) {
			    			isSuccess = true;
			    		}
			    		else {
			    			isSuccess = false;
			    		}
			    		
			    	}
			    	catch(Exception e) {
			    		e.printStackTrace();
			    	}
			    	
			    	return isSuccess;
			    }
			
			
			
			//------------------------------------------------------------------------------------------------------------------------------------------
			public static List<User> getAllDeletedUsers() throws Exception{
				
	
		    	
					ArrayList<User> user = new ArrayList<>();
					
					try { 
					   
						con = DBManager.getConnection();//establishing connection
					    st = con.createStatement();
					    
					    String sql = "select * from deletedcustomers" ;
					    rs = st.executeQuery(sql);//execute query
					    
					    while(rs.next()) {
					    	int id = rs.getInt(1);
							String userID = rs.getString(2);
							String uName = rs.getString(3);
							String pw = rs.getString(4);
							String fname = rs.getString(14);
							String lname = rs.getString(15);
							String address = rs.getString(5);
							String email = rs.getString(6);
							String phone = rs.getString(16);
							String dob = rs.getString(7);
							String anniversary = rs.getString(8);
							String occupation = rs.getString(9);
							String img = rs.getString(10);
							String loyaltyCardNo = rs.getString(11);
							String loyaltyExpiry = rs.getString(12);
							int loyaltyPoints = rs.getInt(13);
						//String user = rs.getString(8);
						
						//create a new instance to retrieve data
						User u = new User(id, userID , uName , pw, address , email , dob , anniversary, occupation, loyaltyCardNo ,loyaltyExpiry , loyaltyPoints , phone , fname , lname,img);
						user.add(u);
					    }
					    
					}
					catch(Exception e) {
					    e.printStackTrace();
					}
					
					return user;
					
				    }
			
			
			//-------------------------------------Restoring customer----------------------------------------------------
			public static boolean restoreCust(String id) {
				
				boolean isSuccess=false;
			    	
			    	try {
			    		
			    		con = DBManager.getConnection();//establishing connection
			    		st = con.createStatement();
			    		
			    		String sql = "DELETE FROM deletedcustomers WHERE UserID='"+id+"' ";//deleting details
			    		int rs = st.executeUpdate(sql);//execute query
			    		
			    		//if deleted successfully returns true else false
			    		if(rs > 0) {
			    			isSuccess = true;
			    		}
			    		else {
			    			isSuccess = false;
			    		}
			    		
			    	}
			    	catch(Exception e) {
			    		e.printStackTrace();
			    	}
			    	
			    	return isSuccess;
			    }
			
			
			 

}
