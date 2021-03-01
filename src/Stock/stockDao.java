package Stock;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.ServletResponse;
import javax.servlet.http.Part;


import util.DBUtil;

public class stockDao {

	
	//initializing database connection variables
	
	private static boolean isSuccess;
	private static Connection con = null;
	private static ResultSet rs = null;
	private static Statement st = null;
	private static PreparedStatement ps = null;
	
	
	
	/*******************************method to insert new Stock**************************************/
	
	
	
		public static boolean insertStock(String stockName , double stockSize,int suppliedQty, String suppliedDate ,int qtySent, String supplierName, String categoryName ,int availableQty,Part part ) 
		{
			boolean isSuccess = false;
			
			goodsIDGenerator gd = new  goodsIDGenerator();
			 String stockNumber = gd.stockIDgenerator();
			
			try {
				//creating the connection with the database
				con = DBUtil.getConnection();
				
				st = con.createStatement();
				
				InputStream inputstream = part.getInputStream();
				
				//Insert query //image column should be added
				//String sql = "Insert into stock values(0,'"+stockNumber+"','"+stockName+"','"+suppliedQty+"','"+suppliedDate+"','"+stockSize+"',0,'"+qtySent+"','"+supplierName+"','"+""+"','"+categoryName+"', '"+availableQty+"')";
				
				String sql= "Insert into stock (id,stockid,stockname,suppliedqty,supplieddate,stocksize,reorderlevel,qtysenttostore,supplierdid,image,categoryid,qtyAvailable) values(?,?,?,?,?,?,?,?,?,?,?,?)";
				
				ps = con.prepareStatement(sql);
				
				ps.setInt(1, 0);
				ps.setString(2, stockNumber);
				ps.setString(3, stockName);
				ps.setInt(4,suppliedQty);
				ps.setString(5, suppliedDate);
				ps.setDouble(6, stockSize);
				ps.setInt(7, 0);
				ps.setInt(8, qtySent);
				ps.setString(9,supplierName);
				ps.setBlob(10,inputstream);
				ps.setString(11,categoryName);
				ps.setInt(12, availableQty);
				
				
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
			
			
			//return isSucces value to StockInsertServlet
			return isSuccess;
			
		}
		
		
/*******************************method to retrieve Stock**************************************/
		
		//Method to retrieve all rows and display from the stock table in database
		//Return type list of the stock with all data
		public static List<Stock> getStockList(ServletResponse response){

			String base64Image = null;
			//creating an array list type object of Stock
			ArrayList<Stock> stock = new ArrayList<>();
			
			
			try {
				//creating connection with the database
				con = DBUtil.getConnection();
				st = con.createStatement();
				
				//query
				String sql = "select * from stock";
				
				ps=con.prepareStatement(sql);
				
				rs = ps.executeQuery();
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
					
					
					
					Blob image = rs.getBlob(10);
					
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
					

					//creating an object of stock and pass all values to the constructor in the stock class
					Stock stk = new Stock(id,stockid,stockName,qtyAvailable,stockSize,reOrderLevel,qtySupplied,supDate,qtySent,supplierName,categoryName, base64Image);
					
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
		
		/*******************************method to update  Stock by setting reorder level**************************************/
		
		//Method to update the stock data. This return a boolean value whether the data has been updated to the database or not	
		public static boolean updateStock(String id,String stockName,int qtyAvailable,float stockSize,int qtySupplied,String suppliedDate,int storeQty,String suppName,String categoryName,int MaxSold , int avgSold,int leadTime,int avgLeadTime)
		{
			
			boolean isSuccess=false;
			
				try {
					
					//creating connection with the database
					con = DBUtil.getConnection();
					st = con.createStatement();
					
					//executing the stored procedure
					
					CallableStatement  cs = con.prepareCall("{call stockNotify(?,?,?,?,?,?,?,?)}");
					
					cs.setInt(1, MaxSold);
					cs.setInt(2, avgSold);
					cs.setInt(3, leadTime);
					cs.setInt(4, avgLeadTime);
					cs.setInt(5, qtyAvailable);
					cs.setString(6,stockName);
					cs.setFloat(7, stockSize);
					cs.setString(8,suppName);
					
					
					
					cs.execute();
					cs.close();
					
					System.out.println("Stored procedure called successfully!");
					
					//Query
					String sql = "update stock set stockname = '"+stockName+"',suppliedqty = suppliedqty +  '"+qtySupplied+"',supplieddate = '"+suppliedDate+"',stocksize = '"+stockSize+"',qtysenttostore = qtysenttostore + '"+storeQty+"',supplierdid = '"+suppName+"',categoryid = '"+categoryName+"',qtyAvailable = '"+ qtyAvailable+"' " + "where stockid = '"+id+"'";

					
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
		
		
		/***************************Method to update stock without setting reorder level**********************************************/
	
	
		
		//Method to update the stock data. This return a boolean value whether the data has been updated to the database or not	
		public static boolean updateStockWithoutReorder(String id,String stockName,int qtyAvailable,float stockSize,int qtySupplied,String suppliedDate,int storeQty,String suppName,String categoryName)
		{
			
			boolean isSuccess=false;
			
				try {
					
					//creating connection with the database
					con = DBUtil.getConnection();
					st = con.createStatement();
					
					
					//Query
					String sql = "update stock set stockname = '"+stockName+"',suppliedqty = suppliedqty +  '"+qtySupplied+"',supplieddate = '"+suppliedDate+"',stocksize = '"+stockSize+"',reorderlevel= reorderlevel + '"+0+"',qtysenttostore = qtysenttostore + '"+storeQty+"',supplierdid = '"+suppName+"',categoryid = '"+categoryName+"',qtyAvailable = '"+ qtyAvailable+"' " + "where stockid = '"+id+"'";

					
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
		

		
/*******************************method to retrieve stock Notifications**************************************/
		
		//Method to retrieve all rows and display from the notifications table in database
		//Return type list of the notification with all data
		public static List<Notifications> getNotification(){

			//creating an array list type object of Notifications
			ArrayList<Notifications> notify = new ArrayList<>();
			
			
			try {
				//creating connection with the database
				con = DBUtil.getConnection();
				st = con.createStatement();
				
				//query
				String sql = "select * from notifications";
				
				rs = st.executeQuery(sql);
				while(rs.next()) {
					//Assigning all retrieved values to the respective variables . if the next boolean value is true
					int id = rs.getInt(1);
					String stockName = rs.getString(2);
					String supplierName = rs.getString(3);
					int reOrderLevel= rs.getInt(4);
					double stockSize = rs.getDouble(5);
					String reShelfDate = rs.getString(6);
					int reshelQty = rs.getInt(7);
					
					
					//creating an object of notifications and pass all values to the constructor in the notifications class
					Notifications notification = new Notifications(id,stockName,supplierName,reOrderLevel,stockSize,reShelfDate,reshelQty);
					
					//passing notify object to the array list object
					notify.add(notification);
					
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			//Returning the notifications array list object
			return notify;
			
		}
		
/*******************************method to delete  Stock Notifications**************************************/
		
		public static boolean deleteNotifications(String id) {
			
			boolean isSuccess=false;
			
			
		    	
		    	try {
		    		
		    		con = DBUtil.getConnection();
					st = con.createStatement();
					
		    		String sql = "delete from notifications where id='"+id+"'";//deleting details
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
