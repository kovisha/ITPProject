package Offer;

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
import javax.servlet.http.Part;

import DBConnect.DBConnect;

public class offerDButil {

	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	//inserting offer details to database
	public static boolean insertOfferDetail (String name, String desc, String discP, String status, double min, double max, Part img)
	{
		
		boolean isSuccess = false;
		
		offerIdGenerator offId = new offerIdGenerator();
		String offerId = offId.offerIdGenerator();
		
		try{
			con = DBConnect.getConnection();
			/* stmt = con.createStatement(); */
			String sql= "insert into offer(offerId,offerName,descrip,discount,status,orderMinAmount,orderMaxAmount,image) values(?,?,?,?,?,?,?,?)";
			InputStream inp = img.getInputStream(); 
			PreparedStatement ps = con.prepareStatement(sql); 
			ps.setString(1,offerId);
			ps.setString(2,name);
			ps.setString(3,desc);
			ps.setString(4,discP);
			ps.setString(5,status);
			ps.setDouble(6,min);
			ps.setDouble(7,max);
			ps.setBlob(8,inp);
			int rs = ps.executeUpdate();
			 
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
	
	//retrieving offer details from database
	public static List<Offer> getOfferDetails(ServletResponse response)
	{
		ArrayList<Offer> offer = new ArrayList<>();
		
		try {	
			
			con=DBConnect.getConnection();
			PreparedStatement ps= con.prepareStatement("select * from offer");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				int id=rs.getInt(1);
				String OfferId = rs.getString(2);
				String name = rs.getString(3);
				String desc = rs.getString(4);
				float discP = rs.getFloat(5);
				String status = rs.getString(6);
				double min = rs.getDouble(7);
				double max = rs.getDouble(8);
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
				
				
				Offer off1 = new Offer(id,OfferId,name,desc,discP,status,min,max,base64Image);
				offer.add(off1);
					
			}
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return offer;
	}
	
	//updating offer details to database with image
	public static boolean updateOfferDetail (String offerId, String name, String desc, String discP, String status, double min, double max, Part img)
	{
		
		boolean isSuccess = false;
		
		try{
			con = DBConnect.getConnection();
			/* stmt = con.createStatement(); */
			
			String sql= "update offer set offerName=?,descrip=?,discount=?,status=?,orderMinAmount=?,orderMaxAmount=?,image=? where offerId='"+offerId+"'";
			InputStream inp = img.getInputStream(); 
			PreparedStatement ps = con.prepareStatement(sql); 
			ps.setString(1,name);
			ps.setString(2,desc);
			ps.setString(3,discP);
			ps.setString(4,status);
			ps.setDouble(5,min);
			ps.setDouble(6,max);
			ps.setBlob(7,inp);
			
			int rs = ps.executeUpdate();
			
			
			
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
	
	//updating offer details to database without image
	public static boolean updateOfferDetail2 (String offerId, String name, String desc, String discP, String status, double min, double max)
	{
		
		boolean isSuccess = false;
		
		try{
			con = DBConnect.getConnection();
			
			String sql= "update offer set offerName=?,descrip=?,discount=?,status=?,orderMinAmount=?,orderMaxAmount=? where offerId='"+offerId+"'";
			PreparedStatement ps = con.prepareStatement(sql); 
			ps.setString(1,name);
			ps.setString(2,desc);
			ps.setString(3,discP);
			ps.setString(4,status);
			ps.setDouble(5,min);
			ps.setDouble(6,max);
			
			int rs = ps.executeUpdate();
			
			
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
	
	//deleting offer details in database
	public static boolean deleteOfferDetails(String id)
	{
		
		boolean isSuccess = false;
		
		try{	
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "delete from offer where offerId ='"+id+"'";
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

	//identifying offer percentage for total bill amount
	public static int calculateTotal(double grossTotal) {
		
		int offerPerc = 0;
		try{	
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select orderMinAmount,orderMaxAmount,discount from offer where orderMinAmount!='null' and status = 'en'";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				double min = rs.getDouble(1);
				double max = rs.getDouble(2);
				
				if(grossTotal>=min & grossTotal<max) {
					offerPerc = rs.getInt(3);
				}
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return offerPerc;
	}
}
