package Category;



import java.sql.Connection;





import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;


public class categoryDao {

	//initializing database connection variables
	
		private static boolean isSuccess;
		private static Connection con = null;
		
		private static ResultSet rs = null;
		private static Statement st = null;
		
		
		/*******************************method to insert new Category**************************************/
		
		public static boolean insertCategory(String categoryName) 
		{
			 isSuccess = false;
			 
			 goodsIDGenerator gd = new  goodsIDGenerator();
			 String categoryNumber = gd.categoryIDgenerator();
			
			try {
				//creating the connection with the database
				con = DBUtil.getConnection();
				
				st = con.createStatement();
				
		
				//Insert query 
				//String sql = "INSERT INTO categories(CategoryName) VALUES ('"+categoryName+"')";
				//String sql = "INSERT INTO categories(catID,CategoryName) VALUES (0,'"+categoryName+"')";
				String sql = "INSERT INTO category VALUES (0,'"+categoryNumber+"','"+categoryName+"')";
				
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
			
			
			//return isSucces value to CategoryInsertServlet
			return isSuccess;
			
		}
		
		
		/*******************************method to retrieve  Categories**************************************/
		
		//Method to retrieve all rows and display from the category table in database
		//Return type list of the category with all data
		public static List<Category> getCategoryList(){

			//creating an array list type object of category
			ArrayList<Category> category = new ArrayList<>();
			
			
			try {
				//creating connection with the database
				con = DBUtil.getConnection();
				st = con.createStatement();
				
				//query
				String sql = "select * from category";
				
				rs = st.executeQuery(sql);
				while(rs.next()) {
					//Assigning all retrieved values to the respective variables . if the next boolean value is true
					int id = rs.getInt(1);
					String catid = rs.getNString(2);
					String categoryName = rs.getString(3);
					
					

					//creating an object of category and pass all values to the constructor in the category class
					Category cat = new Category(id,catid,categoryName);
					
					//passing cat object to the array list object
					category.add(cat);
					
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			//Returning the category array list object
			return category;
			
		}
		
		/*******************************method to delete  Categories**************************************/
		
		public static boolean delete(String cid) {
			
			boolean isSuccess=false;
			
			//int deleteID = Integer.parseInt(cid);
		    	
		    	try {
		    		
		    		con = DBUtil.getConnection();
					st = con.createStatement();
					
		    		String sql = "delete from category where catid='"+cid+"'";//deleting details
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
		
		/*******************************method to update  Categories**************************************/
	 
		//Method to update the category data. This return a boolean value whether the data has been updated to the database or not	
		public static boolean updateCategory(String catid,String catname)
		{
				try {
					
					//creating connection with the database
					con = DBUtil.getConnection();
					st = con.createStatement();
					
					//Query
					String sql = "update category set catname = '"+catname+"'" + "where catid = '"+catid+"'";

					
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
