package Item;

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

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletResponse;
import javax.servlet.http.Part;


import util.DBUtil;

public class itemDao {

	//initializing database connection variables
	
	private static boolean isSuccess;
	private static Connection con = null;
	private static ResultSet rs = null;
	private static Statement st = null;
	private static PreparedStatement ps = null;
	
	
	
	/**************************************method to insert new item******************************************/
	
	public static boolean insertItem(String itemName,double iSize,  double iPrice,int qty,String itemStatus, String offerName,  String category,Part part) 
	{
		isSuccess = false;
		
		goodsIDGenerator gd = new  goodsIDGenerator();
		 String itemNumber = gd.itemIDgenerator();
		 
		 goodsIDGenerator gd2 = new goodsIDGenerator();
		 String barcodeId = gd2.barcodeIdGenerator();
		
		try {
			//creating the connection with the database
			con = DBUtil.getConnection();
			
			st = con.createStatement();
			
		InputStream inputstream = part.getInputStream();
			
			//Insert query //image column should be added
			//String sql = "Insert into item values( 0,'"+itemNumber+"','"+itemName+"','"+itemStatus+"','"+iSize+"','"+barcodeId+"','"+iPrice+"','"+""+"','"+qty+"','"+category+"','"+offerName+"')";
			
			String sql = "Insert into item (id,itemId,itemName,status,size,barcideId,price,image,qtyAvailable,catId,offerId) values(?,?,?,?,?,?,?,?,?,?,?)";
			
			ps= con.prepareStatement(sql);
			
			ps.setInt(1, 0);
			ps.setString(2,itemNumber);
			ps.setString(3, itemName);
			ps.setString(4, itemStatus);
			ps.setDouble(5,iSize);
			ps.setString(6, barcodeId);
			ps.setDouble(7, iPrice);
			ps.setBlob(8, inputstream);
			ps.setInt(9, qty);
			ps.setString(10, category);
			ps.setString(11, offerName);
			
			
			int rs = ps.executeUpdate();
			 
			if(rs > 0) {
				//if rs > 0 assign true to isSuccess boolean value
				isSuccess = true;
			}else {
				//if rs < 0 assign false to isSuccess boolean value
				isSuccess = false;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		//return isSucces value to ItemInsertServlet
		return isSuccess;
		
	}
	
	
	
	/*******************************method to retrieve  Items**************************************/
	
	//Method to retrieve all rows and display from the item table in database
	//Return type list of the item with all data
	public static List<Item> getItemList(ServletResponse response){

		String base64Image = null;
		
		//creating an array list type object of category
		ArrayList<Item> item = new ArrayList<>();
		
		
		try {
			//creating connection with the database
			con = DBUtil.getConnection();
			st = con.createStatement();
			
			//query
			String sql = "select * from item";
			
			ps=con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				//Assigning all retrieved values to the respective variables . if the next boolean value is true
				int id = rs.getInt(1);
				String itemID = rs.getString(2);
				String itemName = rs.getString(3);
				String itemStatus = rs.getString(4);
				double itemSize = rs.getDouble(5);
				String barcodeID = rs.getString(6);
				double itemPrice = rs.getDouble(7);
				
				int qtyAvailable = rs.getInt(9);
				String categoryName = rs.getString(10);
				String offerName = rs.getString(11);
				
				Blob image = rs.getBlob(8);
                
                InputStream inputStream = image.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;
               
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
               
                byte[] imageBytes = outputStream.toByteArray();
               
                base64Image = Base64.getEncoder().encodeToString(imageBytes);
               
                inputStream.close();
                outputStream.close();
				
				

				//creating an object of item and pass all values to the constructor in the item class
				Item i1 = new Item(id,itemID,itemName,itemSize,barcodeID,itemPrice,qtyAvailable,itemStatus,offerName,categoryName,base64Image);
				
				//passing i1 object to the array list object
				item.add(i1);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//Returning the item array list object
		return item;
		
	}
	
	/*******************************method to deactivate  items**************************************/
	/******************************* Delete active items and deactivate it**********************/
	public static boolean delete(String id) {
		
		boolean isSuccess=false;
		
		//int deleteID = Integer.parseInt(id);
	    	
	    	try {
	    		
	    		con = DBUtil.getConnection();
				st = con.createStatement();
				
	    		String sql = "delete from item where itemId='"+id+"'";//deleting details
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
	
	/*******************************method to activate  items**************************************/
	/******************************* Delete deactive items and activate it**********************/
	
	
	public static boolean deleteDeactivatedItems(String id) {
		
		boolean isSuccess=false;
		
		try {
    		
    		con = DBUtil.getConnection();
			st = con.createStatement();
			
    		String sql = "delete from itemlog where itemId='"+id+"'";//deleting details
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
	
	
	/*******************************method to retrieve Deactivated Items**************************************/
	
	//Method to retrieve all rows and display from the itemLog table in database
	//Return type list of the deactivated Items with all data
	public static List<Item> getDeactivatedItems(ServletResponse response){
		
		String base64Image = null;
		//creating an array list type object of deactivated Items
		ArrayList<Item> deactivatedItems = new ArrayList<>();
		
		
		try {
			//creating connection with the database
			con = DBUtil.getConnection();
			st = con.createStatement();
			
			//query
			String sql = "select * from itemlog";
			
			rs = st.executeQuery(sql);
			while(rs.next()) {
				//Assigning all retrieved values to the respective variables . if the next boolean value is true
				//Assigning all retrieved values to the respective variables . if the next boolean value is true
				int id = rs.getInt(1);
				String itemID = rs.getString(2);
				String itemName = rs.getString(3);
				String itemStatus = rs.getString(4);
				double itemSize = rs.getDouble(5);
				String barcodeID = rs.getString(6);
				double itemPrice = rs.getDouble(7);
				
				int qtyAvailable = rs.getInt(9);
				String categoryName = rs.getString(10);
				String offerName = rs.getString(11);
				
				Blob image = rs.getBlob(8);
                
                InputStream inputStream = image.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;
               
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
               
                byte[] imageBytes = outputStream.toByteArray();
               
                base64Image = Base64.getEncoder().encodeToString(imageBytes);
               
                inputStream.close();
                outputStream.close();
				
				
				//creating an object of item and pass all values to the constructor in the item class
				Item deactivated = new Item(id,itemID,itemName,itemSize,barcodeID,itemPrice,qtyAvailable,itemStatus,offerName,categoryName,base64Image);
				
				//passing i1 object to the array list object
				deactivatedItems.add(deactivated);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//Returning the deactivated items array list object
		return deactivatedItems;
		
	}
	
	/*******************************method to update  items**************************************/
	
	//Method to update the item data. This return a boolean value whether the data has been updated to the database or not	
			public static boolean updateItem(String catid,String itemName,double itemSize,String barcodeID,double itemPrice,int availableQty,String status,String offerName,String categoryName)
			{
					try {
						
						//creating connection with the database
						con = DBUtil.getConnection();
						st = con.createStatement();
						
						//Query
						String sql = "update item set itemName = '"+itemName+"',status = '"+status+"',size = '"+itemSize+"',barcideId = '"+barcodeID+"',price = '"+itemPrice+"',qtyAvailable = '"+availableQty+"',catId = '"+categoryName+"',offerId = '"+offerName+"'" + "where itemId = '"+catid+"'";

						
						int rs = st.executeUpdate(sql);
						
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
			
			
 
}
	

