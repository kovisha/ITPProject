package User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class itemDbUtil {
	
	private static Connection conn = null;
	private static Statement stat = null;
	private static ResultSet rs = null;
	private static boolean isSuccess;
	
	public static List<Item> display(String category)
	
	{
		ArrayList<Item> item = new ArrayList<>();
		
		try {
			
			conn=util.DBManager.getConnection();
			stat=conn.createStatement();
		   
			String sql = "select * from items where categoryName = '"+category+"' ";
			
			//execute the sql query
			rs = stat.executeQuery(sql);
			
			
			while(rs.next())
			{
				
				 String itemName = rs.getString(2) ;
				 Double size = rs.getDouble(4);
				 String price = rs.getString(6);
				 String categoryName = rs.getString(8) ;
				 String offerName  = rs.getString(9);
				
				
				Item i = new Item(itemName , size , price , categoryName,offerName);
				item.add(i);
				
			}
			
			
	
		
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		
			
		return item;
	}
	
	
	
	 public static boolean customize(String category) {
		 	
		 	try {
		 		
		 		conn=util.DBManager.getConnection();//establishing connection
		 		stat=conn.createStatement();
		 		
		 		//updates details
		 		String sql = "select * from items where categoryName = '"+category+"' ";
		 		int rs = stat.executeUpdate(sql);//execute query
		 		
		 		//if update successfully returns true else returns false
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
