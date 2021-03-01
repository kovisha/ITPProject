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

public class itemDbUtil {
	
	private static Connection conn = null;
	private static Statement stat = null;
	private static ResultSet rs = null;
	private static boolean isSuccess;
	
	public static List<Item> display(String category, ServletResponse response)
	
	{
		ArrayList<Item> item = new ArrayList<>();
		
		try {
			
			conn=DBManager.getConection();
			stat=conn.createStatement();
		   
			/*String sql = "select i.itemName,i.itemSize,i.itemPrice,i.categoryName,i.offerName,o.discount"
					+ " from udssuper.items i , udssuper.offer o"
					+ "where categoryName = '"+category+"' and o.offerName = i.offerName ";*/
			
		/*String sql1 =	"select i.itemName ,i.itemSize ,i.itemPrice ,i.categoryName ,i.offerName ,o.discount"+
						"from udssuper.offer o , udssuper.items i"+
						"where o.offerName = i.offerName  and categoryName = '"+category+"' ";*/
		
		/*String sql = "SELECT itemName,itemSize,itemPrice,categoryName,offerName,discount"+
					 "FROM items INNER JOIN offer ON items.offerName = offer.offerName "+
					 "where categoryName = '"+category+"'";*/
			
			
			//String sql1 = "select o.discount "
				//	+ "from udssuper.offer o , udssuper.items i"
				//	+ "where o.offerName = i.offerName ";
			
			
	//	String sql= "select i.itemName ,i.itemSize ,i.itemPrice ,i.categoryName ,i.offerName ,o.discount from offer o ,items i where i.categoryName = '"+category+"' and o.offerId = i.offerId " ;
		//	String sql = "select i.itemId , i.itemName,i.size,i.price,o.offerName,o.discount,c.catname from item i, offer o , category c where i.catId= c.catid and c.catname = '"+category+"' and i.offerId=o.offerId";		
			
	//String sql="select i.itemId , i.itemName,i.size,i.price,o.offerName,o.discount,c.catname from item i, offer o , category c where i.catId= '"+categoryid+"' and i.catId=c.catid and i.offerId=o.offerId";		
			
			

			 PreparedStatement ps = conn.prepareStatement("select i.itemId , i.itemName,i.size,i.price ,o.offerName,o.discount,c.catname,i.image,i.qtyAvailable from item i, offer o , category c where i.catId= c.catid and c.catname = '"+category+"' and i.offerId=o.offerId");
			
			 rs = ps.executeQuery();
			
			
			while(rs.next())
			{
				 String itemid = rs.getString(1);
				 String itemName = rs.getString(2) ;
				 Double size = rs.getDouble(3);
				 Double price = rs.getDouble(4);
				 String offerName  = rs.getString(5);
				 Double discount = rs.getDouble(6);
				 String categoryName = rs.getString(7) ;
				 Blob img = rs.getBlob(8);
				 int qty = rs.getInt(9);
				 
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
				
				
				
				
				Item i = new Item(itemid,itemName , size , price , categoryName,offerName,discount,base64Image,qty);
				
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
		 		
		 		conn=DBManager.getConection();//establishing connection
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
