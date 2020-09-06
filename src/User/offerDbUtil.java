package User;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;




public class offerDbUtil {

	//making the connections
			private static Connection conn = null;
			private static Statement stat = null;
			private static ResultSet rs = null;
			
			public static List<Offer> display()
			
			{
				ArrayList<Offer> offer = new ArrayList<>();
				
				try {
					
					conn=util.DBManager.getConnection();;
					stat=conn.createStatement();
				   
					String sql = "select * from offer ";
					
					//execute the sql query
					rs = stat.executeQuery(sql);
					
					
					while(rs.next())
					{
						
						String offername = rs.getString(3);
						String desc = rs.getString(4);
						Float discount = rs.getFloat(5);
						
						
						Offer off = new Offer(offername, desc, discount);
						offer.add(off);
						
					}
					
					
				
				
				
				} 
				catch(Exception e)
				{
					e.printStackTrace();
					
				}
				
					
				return offer;
			}
			

}
