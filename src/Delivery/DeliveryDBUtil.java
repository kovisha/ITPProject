package Delivery;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
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
		 		String typeName = rs.getString(2);
				double charges = rs.getDouble(3);
				
				DeliveryType dT = new DeliveryType(typeName,charges);
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
		 		
				
				DeliveryDetails dD = new DeliveryDetails(id, uID, deliveryID, orderID, status, dateTime, amount);
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
			
				DeliveryDetails DD = new DeliveryDetails(id, uID, deliveryID, orderID, status, dateTime, amount);
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
	public static boolean updateDeliveryDetails (String uID,  String id, String status, double amount)
	{
		
		boolean isSuccess = false;
		
		try{
			con = DeliveryDBConnect.getConnection();
			stmt = con.createStatement();
			
			String update="UPDATE deliveredby "
					+ "set uID='"+uID+"', status='"+status+"',amount='"+amount+"'"
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
	
	
	
	
}
