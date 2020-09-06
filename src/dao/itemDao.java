package dao;

import java.sql.Connection;


import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;

import model.Category;
import model.Item;
import util.DBUtil;

public class itemDao {

	//initializing database connection variables
	
	private static boolean isSuccess;
	private static Connection con = null;
	private static ResultSet rs = null;
	private static Statement st = null;
	
	
	
	/**************************************method to insert new item******************************************/
	
	public static boolean insertItem(String id,String itemName,double iSize,String barcodeID,  double iPrice,int qty,String itemStatus, String offerName,  String category) 
	{
		isSuccess = false;
		
		try {
			//creating the connection with the database
			con = DBUtil.getConnection();
			
			st = con.createStatement();
			
			//Insert query //image column should be added
			String sql = "Insert into item values( 0,'"+id+"','"+itemName+"','"+itemStatus+"','"+iSize+"','"+barcodeID+"','"+iPrice+"','"+""+"','"+qty+"','"+category+"','"+offerName+"')";
			
			int rs = st.executeUpdate(sql);
			 
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
	public static List<Item> getItemList(){

		//creating an array list type object of category
		ArrayList<Item> item = new ArrayList<>();
		
		
		try {
			//creating connection with the database
			con = DBUtil.getConnection();
			st = con.createStatement();
			
			//query
			String sql = "select * from item";
			
			rs = st.executeQuery(sql);
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
				
				

				//creating an object of item and pass all values to the constructor in the item class
				Item i1 = new Item(id,itemID,itemName,itemSize,barcodeID,itemPrice,qtyAvailable,itemStatus,offerName,categoryName);
				
				//passing i1 object to the array list object
				item.add(i1);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//Returning the item array list object
		return item;
		
	}
	
	/*******************************method to delete  items**************************************/
	
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
	
	/*******************************method to update  items**************************************/
	
	//Method to update the item data. This return a boolean value whether the data has been updated to the database or not	
			public static boolean updateItem(String catid,String itemName,double itemSize,String barcodeID,double itemPrice,int availableQty,String status,String offerName,String categoryName)
			{
					try {
						
						//creating connection with the database
						con = DBUtil.getConnection();
						st = con.createStatement();
						
						//Query
						String sql = "update item set itemName = '"+itemName+"',size = '"+itemSize+"',barcideId = '"+barcodeID+"',price = '"+itemPrice+"',qtyAvailable = '"+availableQty+"',catId = '"+categoryName+"',offerId = '"+offerName+"'" + "where itemId = '"+catid+"'";

						
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
	

