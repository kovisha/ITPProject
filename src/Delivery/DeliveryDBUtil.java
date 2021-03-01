package Delivery;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Delivery.DeliveryDBConnect;
import Delivery.DeliveryType;


public class DeliveryDBUtil {

	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	

	/**
	 * To Retrieve delivery Type details from the database
	 */
	public static List<DeliveryType> getDeliveryTypeDetails() {
		
		ArrayList<DeliveryType> deliveryType = new ArrayList<>();
		
		try {			
			con=DeliveryDBConnect.getConnection();
			stmt=con.createStatement();
			String sql = "SELECT * FROM deliverytype";
			
			 rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
		 		int id = rs.getInt(1);
				String typeName = rs.getString(2);
				double charges = rs.getDouble(3);
				
				DeliveryType dT = new DeliveryType(id,typeName,charges);
				deliveryType.add(dT);
			}			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}

		return deliveryType;
	}
	
	/**
	 * To Insert deliveryType details from the database
	 */
	public static boolean insertDeliveryTypeDetails (String dType, double dCharge)
	{
		
		boolean isSuccess = false;
		
		try{
			con = DeliveryDBConnect.getConnection();
			stmt = con.createStatement();
			
			String sql = "INSERT INTO deliverytype VALUES (null,'"+dType+"','"+dCharge+"')";
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return isSuccess;
	}
	
	/**
	 * To Retrieve delivery details from the database
	 */
	public static List<DeliveryDetails> getDeliveryDetails() {
		
		ArrayList<DeliveryDetails> DeliveryDetails = new ArrayList<>();
		
		try {			
			con=DeliveryDBConnect.getConnection();
			stmt=con.createStatement();
			String sql = "SELECT * FROM deliveredby";
			
			 rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				String id = rs.getString(1);
				String uID = rs.getString(2);
				String deliveryID = rs.getString(3);
				String orderID = rs.getString(4);
				String status = rs.getString(5) ;
				Date dateTime = rs.getDate(6);
				double amount = rs.getDouble(7);
				String address = rs.getString(8);
				String delType = rs.getString(9);
				
				DeliveryDetails dD = new DeliveryDetails(id, uID, deliveryID, orderID, status, dateTime, amount, address, delType);
				DeliveryDetails.add(dD);
			}			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}

		return DeliveryDetails;
	}
	
	
	/**
	 * To Retrieve delivery details from the database by passing deliveryID
	 */
	
	public static List<DeliveryDetails> getDeliveryDetails(String DID) {
		
		ArrayList<DeliveryDetails> DeliveryDetails = new ArrayList<>();
		
		try {
			
			con=DeliveryDBConnect.getConnection();
			stmt=con.createStatement();
			String sql = "SELECT * FROM deliveredby WHERE deliveryID='"+DID+"'";
			
			 rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				String id = rs.getString(1);
				String uID = rs.getString(2);
				String deliveryID = rs.getString(3);
				String orderID = rs.getString(4);
				String status = rs.getString(5) ;
				Date dateTime = rs.getDate(6);
				double amount = rs.getDouble(7);
				String address = rs.getString(8);
				String DelType = rs.getString(9);

				
			
				DeliveryDetails DD = new DeliveryDetails(id, uID, deliveryID, orderID, status, dateTime, amount, address, DelType);
				DeliveryDetails.add(DD);
			}
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return DeliveryDetails;
		
		}
			
	

	/**
	 * To Update deliveryType details to the database
	 */
	public static boolean updateDeliveryDetails (String uID,  String id, String status, double amount, String delDate)
	{
		
		boolean isSuccess = false;
		
		try{
			con = DeliveryDBConnect.getConnection();
			stmt = con.createStatement();
			
			String update="UPDATE deliveredby "
					+ "set uID='"+uID+"', status='"+status+"',amount='"+amount+"', dateTime = CURRENT_TIMESTAMP "
					+ " WHERE id = '"+id+"' ";
			
			int rs = stmt.executeUpdate(update);
			
			if(rs > 0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return isSuccess;
	}
	
	/**
	 * To Retrieve delivery staff details from the database
	 */
	public static List<DeliveryStaff> getDeliveryStaffDetails() {
		
		ArrayList<DeliveryStaff> DeliveryStaffDetails = new ArrayList<>();
		
		try {			
			con=DeliveryDBConnect.getConnection();
			stmt=con.createStatement();
			String sql = "SELECT * FROM delstaff";
			
			 rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				int id = rs.getInt(1);
				String SID = rs.getString(2);
				String name = rs.getString(3);
				int ordDelivered = rs.getInt(4);
				int totOrdDelivered = rs.getInt(5) ;
				Date dateJoined = rs.getDate(6);
				double rating = rs.getDouble(7);
				double avgRating = rs.getDouble(8);
		 		
				
				
				DeliveryStaff ds = new DeliveryStaff(id ,SID, name, ordDelivered, totOrdDelivered, dateJoined, rating, avgRating);
				DeliveryStaffDetails.add(ds);
			}			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}

		return DeliveryStaffDetails;
	}
	
	
	/**
	 * To Retrieve delivery Type details to update form
	 */
	public static List<DeliveryType> getDeliveryTypeDetail(String DTID) {
		ArrayList<DeliveryType> DeliveryTypeDetails = new ArrayList<>();
		
		try {
			
			con=DeliveryDBConnect.getConnection();
			stmt=con.createStatement();
			String sql = "SELECT * FROM deliverytype WHERE id='"+DTID+"'";
			
			 rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				int id = rs.getInt(1);
				String typeName = rs.getString(2);
				double charges = rs.getDouble(3);
				
				DeliveryType DTD = new DeliveryType(id, typeName, charges);
				DeliveryTypeDetails.add(DTD);
			}
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return DeliveryTypeDetails;
		
	}

	/**
	 * To update delivery Type details to DB when iving the id  
	 */
	public static boolean updateDeliveryTypeDetails(int id, double dtCharges) {
		
		boolean isSuccess = false;
		
		try{
			con = DeliveryDBConnect.getConnection();
			stmt = con.createStatement();
			
			String update="UPDATE deliverytype SET charges = '"+dtCharges+"' WHERE id ='"+id+"'";
			
			int rs = stmt.executeUpdate(update);
			
			if(rs > 0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return isSuccess;
	}

	/**
	 * To delete delivery Type details from DB
	 */
	public static boolean deleteDeliveryType(int id) {
		boolean isSuccess = false;
		
		try{
			con = DeliveryDBConnect.getConnection();
			stmt = con.createStatement();
			
			String deleteData = "DELETE FROM deliverytype WHERE id = '"+id+"'";
			int rs = stmt.executeUpdate(deleteData);
			
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

	//Method to insert Customer Delivery Details without Address
	public static boolean insertCusDeliveryTypeDetailsWithoutAddress(String orderid, String dtype, String LoggedUser) {
		
		//Retrive the default address from the customer
		
		String address = null;
		String status = "Recieved";
		String amount = null;
		
		con = DeliveryDBConnect.getConnection();
		try {
			//get Default Address 
			stmt = con.createStatement();
			String getAddress = "SELECT address FROM customer WHERE UName = '"+LoggedUser+"' ";
			
			rs = stmt.executeQuery(getAddress);
			
			while (rs.next()) {
				 address = rs.getString(1);
			}
			
			
			//getAmount
			stmt = con.createStatement();
			String getAmount = "SELECT charges FROM deliverytype WHERE typeName ='"+dtype+"' ";
			rs = stmt.executeQuery(getAmount);
			
			while (rs.next()) {
				amount = rs.getString(1);
			}
			
			
			stmt = con.createStatement();
			String setDelDetails = "UPDATE deliveredby SET status='"+status+"',amount='"+amount+"',Deladdress='"+address+"',DelType='"+dtype+"' WHERE orderID='"+orderid+"' ";
			int rs = stmt.executeUpdate(setDelDetails);
			
			if(rs > 0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return isSuccess;
	}
	
	//Method to insert Customer Delivery Details with Addresss 
	public static boolean insertCusDeliveryTypeDetailsWithAddress(String orderid, String dtype, String delAddress, String LoggedUser) {
		
		String amount = null;
		String status = "Recieved";
		
		//getAmount
		try {
			con = DeliveryDBConnect.getConnection();
			stmt = con.createStatement();
			
			String getAmount = "SELECT charges FROM deliverytype WHERE typeName ='"+dtype+"' ";
			rs = stmt.executeQuery(getAmount);
			
			while (rs.next()) {
				amount = rs.getString(1);
			}
			
			stmt = con.createStatement();
			String setDelDetails = "UPDATE deliveredby SET status='"+status+"',amount='"+amount+"',Deladdress='"+delAddress+"',DelType='"+dtype+"' WHERE orderID='"+orderid+"' ";
			int rs = stmt.executeUpdate(setDelDetails);
			
			if(rs > 0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isSuccess;
		
	}

	//To Retrive USER PROFIL DELIVERY Details
	public static List<DeliveryUserDetails> deliveryUserDetails(String loggedUser) {
		
		ArrayList<DeliveryUserDetails> deliveryUserDetail = new ArrayList<>();
		
		try {
			
			con=DeliveryDBConnect.getConnection();
			stmt=con.createStatement();
			String sql = "SELECT d.deliveryID,d.orderID,d.status,d.dateTime,d.DelType,d.uID FROM customer c,udssuper.order o,deliveredby d WHERE c.UserID=o.uid and d.orderID=o.orderID and c.UName='"+loggedUser+"' ";
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				

				String deliveryID = rs.getString(1);
				String orderID = rs.getString(2);
				String status = rs.getString(3) ;
				Date dateTime = rs.getDate(4);
				String delType = rs.getString(5);
				String uID = rs.getString(6);

							
				DeliveryUserDetails DD = new DeliveryUserDetails(deliveryID, orderID, status, dateTime, delType, uID);
				deliveryUserDetail.add(DD);
			}
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return deliveryUserDetail;
	}

	//Method to  insert Delivery Rate Details 
	public static boolean insertDeliveryRateDetails(int drate, String sugg, String comp, String delID, String LoggedUser) {
		
		boolean isSuccess = false;
		String uID =null;
		int ordDelivered =0;
		int totOrdDelivered =0;
		double rating =0;
		double avgRating =0;
		
		
		try{
			con = DeliveryDBConnect.getConnection();
			stmt = con.createStatement();
			
			//retrive staff ID
			String retriveStaffID = "SELECT uID FROM deliveredby WHERE deliveryID = '"+delID+"' ";
			rs = stmt.executeQuery(retriveStaffID);
			
			while (rs.next()) {
				uID = rs.getString(1);
				
			}
			
			//get Staff Rate
			String retriveStaffdet = "SELECT ordDelivered, totOrdDelivered, rating, avgRating FROM delstaff WHERE SID = '"+uID+"' ";
			rs = stmt.executeQuery(retriveStaffdet);
			
			while (rs.next()) {
				ordDelivered = Integer.parseInt(rs.getString(1)); 
				totOrdDelivered = Integer.parseInt(rs.getString(2));
				rating = Double.parseDouble(rs.getString(3));
				avgRating = Double.parseDouble(rs.getString(4));
				
			}
			 
			//update staff Rate
			
			rating = Math.round(((rating * ordDelivered) + (double)drate)/ (ordDelivered+1)) ;
			
			avgRating = Math.round(((avgRating * totOrdDelivered) + (double)drate)/ (totOrdDelivered+1)) ;
			
			ordDelivered = ordDelivered + 1;
			totOrdDelivered = totOrdDelivered +1;			
			
			String updateStaffdet = "UPDATE delstaff SET date = CURRENT_TIMESTAMP, ordDelivered='"+ordDelivered+"',totOrdDelivered='"+totOrdDelivered+"',rating='"+rating+"',avgRating='"+avgRating+"' WHERE SID='"+uID+"' ";
			int rs = stmt.executeUpdate(updateStaffdet);
			
			if(rs > 0) {		
				//update Rating
				String insertRating = "INSERT INTO rating VALUES(null,'"+LoggedUser+"','"+sugg+"','"+comp+"' )";
				int rs1 = stmt.executeUpdate(insertRating);
				
				if(rs1 > 0) {
					isSuccess = true;
				}
				else {
					isSuccess = false;
				}
				
			}
			else {
				isSuccess = false;
			}	
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return isSuccess;
	}

	//method to retrive suggestions
	public static List<Suggestions> getSuggestionsDetails() {
		
		ArrayList<Suggestions> suggestions = new ArrayList<>();
		
		try {			
			
			con=DeliveryDBConnect.getConnection();
			stmt=con.createStatement();
			String sql = "SELECT * FROM rating";
			
			 rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				String id = rs.getString(1);
				String cusID = rs.getString(2);
				String suggest= rs.getString(3);
				String complaints = rs.getString(4);
				
				Suggestions ds = new Suggestions(id ,cusID, suggest, complaints);
				suggestions.add(ds);
			}			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}

		return suggestions;
	}
	
	
	


}
