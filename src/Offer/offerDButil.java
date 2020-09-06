package Offer;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import DBConnect.DBConnect;

public class offerDButil {

	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	
	public static boolean insertOfferDetail (String name, String desc, String discP, String status, String img, String path)
	{
		
		boolean isSuccess = false;
		
		try{
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "insert into offer values (0,'OFF006','"+name+"','"+desc+"','"+discP+"','"+status+"','"+img+"','"+path+"')";
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
	
	public static List<Offer> getOfferDetails()
	{
		ArrayList<Offer> offer = new ArrayList<>();
		
		try {
			
			con=DBConnect.getConnection();
			stmt=con.createStatement();
			String sql = "select * from offer";
			ResultSet rs=stmt.executeQuery(sql);
			
			while(rs.next())
			{
				int id=rs.getInt(1);
				String OfferId = rs.getString(2);
				String name = rs.getString(3);
				String desc = rs.getString(4);
				float discP = rs.getFloat(5);
				String status = rs.getString(6);
				String img = rs.getString(7);
				
				
				Offer off1 = new Offer(id,OfferId,name,desc,discP,status,img);
				offer.add(off1);
			}
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return offer;
	}
	
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
}
