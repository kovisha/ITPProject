package Order_Management;

import java.sql.*;



public class UserDAO {
	
	

	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	private static Statement st = null;
	
	public  boolean validate(String username , String password)
	{
		boolean status = false;

		try {

			//1. making the connection
			con=DBManager.getConection(); 

			//2. create a statement using connection object
			ps = con.prepareStatement("select UName , pw  from uds_super.customer where UName = ? and pw = ? ") ;


			ps.setString(1, username);
			ps.setString(2 , password);


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
	
	
	
	
//--------------------------if user exists retrieving the details of user-----------------------------------------
	 public User UserLogin(String username, String password) {
		 
			String sqlQuery = "select * from customer where Username=? and Password=?";
			
			User loggedUser = new User();
			
			try {
				
				//1. making the connection
				  con=DBManager.getConection();
				 
				  //2.create a statement using connection object
				 ps = con.prepareStatement(sqlQuery) ;
				 
				 ps.setString(1, username);
				 ps.setString(2, password);
				 
				 
				 //3.execute the query
				  rs = ps.executeQuery();
				 
				 while(rs.next()) {
						loggedUser.setiD(rs.getInt(1));
						loggedUser.setUserID(rs.getString(2));
						loggedUser.setuName(rs.getString(3));
						loggedUser.setPw(rs.getString(4));
						loggedUser.setAddress(rs.getString(5));
						loggedUser.setEmail(rs.getString(6));
						loggedUser.setDob(rs.getString(7));
						loggedUser.setAnniversary(rs.getString(8));
						loggedUser.setOccupation(rs.getString(9));
						loggedUser.setLoyaltyCardNo(rs.getString(11));
						loggedUser.setLoyaltyExpiry(rs.getString(12));
						loggedUser.setLoyaltyPoints(rs.getInt(13));
						loggedUser.setPhone(rs.getString(14));
						loggedUser.setfName(rs.getString(15));
						loggedUser.setlName(rs.getString(16));
						
						
			}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				
			}
			return loggedUser;		
	 
			}

}
