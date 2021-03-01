package Order_Management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Order_Management.DBManager;

public class searchDbUtil {
	
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;

	
	/*
	 * public ArrayList<String> getAllCountriesCheck(String l) { ArrayList<String>
	 * list = new ArrayList<String>(); PreparedStatement ps = null; String data; try
	 * {
	 * 
	 * con = DBManager.getConection(); stmt = con.createStatement();
	 * 
	 * String ch=l+"%";
	 * 
	 * String sql = "SELECT nicename FROM tbctry  WHERE nicename  LIKE '"+ch+"'" ;
	 * ps = (PreparedStatement) dcon.con.
	 * prepareStatement("SELECT nicename FROM tbctry  WHERE nicename  LIKE '"+ch+"'"
	 * ); ResultSet rs = ps.executeQuery(); while (rs.next()) { data =
	 * rs.getString("nicename"); System.out.println(data); list.add(data); } } catch
	 * (Exception e) { System.out.println(e.getMessage()); } return list; }
	 * 
	 */
	
	
	
	
	
	 public static List<String> retreiveData(String prefix)
		{
			
			ArrayList<String> list = new ArrayList<String>();
			
			try {
				
				con = DBManager.getConection();
				stmt = con.createStatement();
				
				String ch =prefix+"%";
				
				String retrieveitems = "SELECT itemName from items where itemName LIKE '"+ch+"' ";
				ResultSet rs=stmt.executeQuery(retrieveitems);
				
				int total = 0;
				while(rs.next())
				{
					
					String itemname = rs.getString(2);
					
					
					list.add(itemname);
				}
				
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
			
			return list;
		}
}
