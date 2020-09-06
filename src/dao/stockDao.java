package dao;

import java.sql.Connection;




import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import model.Stock;
import util.DBUtil;

public class stockDao {

	
	//initializing database connection variables
	
	private static boolean isSuccess;
	private static Connection con = null;
	private static ResultSet rs = null;
	private static Statement st = null;
	
	
	
	/*******************************method to insert new Stock**************************************/
	
	
	
		public static boolean insertStock(String id,String stockName , double stockSize,int suppliedQty, String suppliedDate ,int qtySent, String supplierName, String categoryName  ) 
		{
			boolean isSuccess = false;
			
			try {
				//creating the connection with the database
				con = DBUtil.getConnection();
				
				st = con.createStatement();
				
				//Insert query //image column should be added
				String sql = "Insert into stock values(0,'"+id+"','"+stockName+"','"+suppliedQty+"','"+suppliedDate+"','"+stockSize+"',0,'"+qtySent+"','"+supplierName+"','"+""+"','"+categoryName+"',0)";
				
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
			
			
			//return isSucces value to StockInsertServlet
			return isSuccess;
			
		}
		
		
/*******************************method to retrieve Stock**************************************/
		
		//Method to retrieve all rows and display from the stock table in database
		//Return type list of the stock with all data
		public static List<Stock> getStockList(){

			//creating an array list type object of Stock
			ArrayList<Stock> stock = new ArrayList<>();
			
			
			try {
				//creating connection with the database
				con = DBUtil.getConnection();
				st = con.createStatement();
				
				//query
				String sql = "select * from stock";
				
				rs = st.executeQuery(sql);
				while(rs.next()) {
					//Assigning all retrieved values to the respective variables . if the next boolean value is true
					int id = rs.getInt(1);
					String stockid = rs.getString(2);
					String stockName = rs.getString(3);
					int qtySupplied = rs.getInt(4);
					String supDate = rs.getString(5);
					double stockSize = rs.getDouble(6);
					int reOrderLevel = rs.getInt(7);
					int qtySent = rs.getInt(8);
					String supplierName = rs.getString(9);
					String categoryName = rs.getString(11);
					int qtyAvailable = rs.getInt(12);
					
					
					
					
					

					//creating an object of stock and pass all values to the constructor in the stock class
					Stock stk = new Stock(id,stockid,stockName,qtyAvailable,stockSize,reOrderLevel,qtySupplied,supDate,qtySent,supplierName,categoryName);
					
					//passing stk object to the array list object
					stock.add(stk);
					
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			//Returning the stock array list object
			return stock;
			
		}
		
/*******************************method to delete  Stock**************************************/
		
		public static boolean delete(String id) {
			
			boolean isSuccess=false;
			
			//int deleteID = Integer.parseInt(id);
		    	
		    	try {
		    		
		    		con = DBUtil.getConnection();
					st = con.createStatement();
					
		    		String sql = "delete from stock where stockid='"+id+"'";//deleting details
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
		
		/*******************************method to update  Stock**************************************/
		
		//Method to update the stock data. This return a boolean value whether the data has been updated to the database or not	
		public static boolean updateStock(String id,String stockName,int qtyAvailable,double stockSize,int reOrderLevel,int qtySupplied,String suppliedDate,int storeQty,String supplierName,String categoryName)
		{
			boolean isSuccess=false;
			
				try {
					
					//creating connection with the database
					con = DBUtil.getConnection();
					st = con.createStatement();
					
					//Query
					String sql = "update stock set stockname = '"+stockName+"',suppliedqty = '"+qtySupplied+"',supplieddate = '"+suppliedDate+"',stocksize = '"+stockSize+"',reorderlevel = '"+reOrderLevel+"',qtysenttostore = '"+storeQty+"',supplierdid = '"+supplierName+"',categoryid = '"+categoryName+"',qtyAvailable = '"+ qtyAvailable+"' " + "where stockid = '"+id+"'";

					
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
