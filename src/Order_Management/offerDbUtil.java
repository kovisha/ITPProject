package Order_Management;


import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.ServletResponse;

import Order_Management.DBManager;



public class offerDbUtil {

	//making the connections
			private static Connection conn = null;
			private static Statement stat = null;
			private static ResultSet rs = null;
			
			public static List<Offer> display(ServletResponse response)
			
			{
				ArrayList<Offer> offer = new ArrayList<>();
				
				try {
					
					conn=DBManager.getConection();
					stat=conn.createStatement();
				   
				    PreparedStatement ps = conn.prepareStatement("select * from offer");
					
					//String sql = "select * from offer ";
					
					//execute the sql query
					rs = ps.executeQuery();
					
					
					while(rs.next())
					{
						
						String offername = rs.getString(3);
						String desc = rs.getString(4);
						Float discount = rs.getFloat(5);
						Blob img = rs.getBlob(9);
						
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
						
						
						Offer off = new Offer(offername, desc, discount,base64Image);
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
