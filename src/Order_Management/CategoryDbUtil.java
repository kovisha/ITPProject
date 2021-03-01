package Order_Management;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import Order_Management.DBManager;

public class CategoryDbUtil {
	
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	
	public static List<Category> displayCategory() {
		
		
		
		ArrayList<Category> cat = new ArrayList<>();
		//create database connection
		
				
		//validate
		try {
			
			con = DBManager.getConection();
			stmt = con.createStatement();
			
			String sql = "SELECT * FROM udssuper.category";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String catid = rs.getString(2);
				String categoryName= rs.getString(3);
				
			Category category = new Category(id,catid,categoryName);
			cat.add(category);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return cat;
	}

}
