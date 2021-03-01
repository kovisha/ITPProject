package Order_Management;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Order_Management.DBManager;



public class ShoppingCartDbUtil {
	
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	public static boolean cartCreation(String username) {
		
		boolean isSuccess = true;
		
		String cartname = username + "cart" ;
		
		
		final String Drop_table = "DROP TABLE IF EXISTS ".concat(cartname);
		
		 final String CREATE_TABLE_SQL = "CREATE TABLE ".concat(cartname)+"("
                + "id INTEGER AUTO_INCREMENT,"
                + "Itemid VARCHAR(45) NOT NULL,"
                + "Iname VARCHAR(45) NOT NULL,"
                + "Iprice DOUBLE NOT NULL,"
                + "Idiscount DOUBLE NOT NULL,"
                + "Iqty INTEGER NOT NULL,"
                + "InetTotal INTEGER NOT NULL,"
                + "OfferName VARCHAR(45),"
                + "CategoryName VARCHAR(45),"
                + "PRIMARY KEY (id))";
		 
		 
		try {
			
			con = DBManager.getConection();
			stmt = con.createStatement();
			
			stmt.executeUpdate(Drop_table);
			stmt.executeUpdate(CREATE_TABLE_SQL);
			System.out.println("Table created");
			
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
		
		return isSuccess;
		
	}
	
   public static boolean insertCartDetails(String username ,String itemid,String ItemName, Double price , Double discount,int qty,Double netTotal,String offer,String category) {
		
		boolean isSuccess = false;
		
		try{
			con = DBManager.getConection();
			stmt = con.createStatement();
			
			String cartname = username + "cart" ;
			
			String sql = "INSERT INTO ".concat(cartname)+ " VALUES (null,'"+itemid+"','"+ItemName+"','"+price+"','"+discount+"', '"+qty+"' , '"+netTotal+"', '"+offer+"','"+category+"')";
			int rs = stmt.executeUpdate(sql);  
			
			String sql1 = "update item set qtyAvailable = qtyAvailable -'"+qty+"' where itemId ='"+itemid+"' ";
			int rs1 = stmt.executeUpdate(sql1);
			
           /* String sql1 = "update item set qtyAvailable=qtyAvailable-1  where itemId ='"+itemid+"' ";*/
			
			 
			
			if(rs > 0) {
				isSuccess = true;
				System.out.println("Table values inserted and quantity deducted");
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
   
   public static List<ShoppingCart> retreiveData(String username)
	{
		ArrayList<ShoppingCart> shop = new ArrayList<>();
		
		try {
			
			con = DBManager.getConection();
			stmt = con.createStatement();
			
			String cartname = username + "cart" ;
			
			String retrieve = "SELECT * FROM ".concat(cartname);
			ResultSet rs=stmt.executeQuery(retrieve);
			
			int total = 0;
			while(rs.next())
			{
				int id = rs.getInt(1);
				String itemid = rs.getString(2);
				String itemname = rs.getString(3);
				Double price  = rs.getDouble(4);
				Double discount = rs.getDouble(5);
				int qty = rs.getInt(6);
				Double netTotal = rs.getDouble(7);
				String offer = rs.getString(8);
				String category = rs.getString(9);
				
				
					
				ShoppingCart sc = new ShoppingCart(id, itemid,itemname,price,discount,qty,netTotal,offer,category);
				shop.add(sc);
			}
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return shop;
	}
   
   public static List<ShoppingCartTotalAmount> retreiveTotal(String username)
  	{
  		ArrayList<ShoppingCartTotalAmount> shop = new ArrayList<>();
  		
  		try {
  			
  			con = DBManager.getConection();
  			stmt = con.createStatement();
  			
  			String cartname = username + "cart" ;
  			
  			String retrieve = "SELECT SUM(InetTotal) FROM ".concat(cartname);
  			ResultSet rs=stmt.executeQuery(retrieve);
  			
  			
  			while(rs.next())
  			{
  				double total = rs.getDouble(1);
  				
  				ShoppingCartTotalAmount sc = new ShoppingCartTotalAmount(total);
  				shop.add(sc);
  			}
  			
  		}
  		catch(Exception ex) {
  			ex.printStackTrace();
  		}
  		
  		return shop;
  	}
   
   
   
   public static double retreiveTotalForHomeApply(String username)
 	{
	   
	   double totalInstallValue =0;
 		
 		
 		try {
 			
 			con = DBManager.getConection();
 			stmt = con.createStatement();
 			
 			String cartname = username + "cart" ;
 			
 			String retrieve = "SELECT SUM(InetTotal) FROM ".concat(cartname)+" where CategoryName = ''";
 			ResultSet rs=stmt.executeQuery(retrieve);
 			
 			
 			while(rs.next())
 			{
 				 totalInstallValue = rs.getDouble(1);
 				
 			}
 			
 		}
 		catch(Exception ex) {
 			ex.printStackTrace();
 		}
 		
 		return totalInstallValue;
 	}
    
    
     
     
   
   public static boolean insertqty(String username , int qty) {
		
		boolean isSuccess = false;
		
		try{
			con = DBManager.getConection();
			stmt = con.createStatement();
			
			String cartname = username + "cart" ;
			
			String sql = "INSERT INTO ".concat(cartname)+ "(Iqty) VALUES ('"+qty+"')";
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
				isSuccess = true;
				System.out.println("qty value inserted");
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
   
   
   
   public static boolean updateCart(String username,String id , String name , int qty ,double netAmount)
	{
		boolean isSuccess = false;
		
		try {
			
			con=DBManager.getConection();
			stmt=con.createStatement();
			
			String cartname = username + "cart" ;
		
			
			String sql = "update ".concat(cartname)+ " set Iqty='"+qty+"' , InetTotal='"+netAmount+"' where id ='"+id+"' ";
			int rs = stmt.executeUpdate(sql);
			
			 // String itemid = "select itemid from ".concat(cartname)+" where id='"+id+"' ";
			  
			//  String sql1 = "update item set qtyAvailable=qtyAvailable-'"+qty+"' where itemId in '"+itemid+"' "; 
			int qty1 = qty-1;
			   
			  String sql2 = "update udssuper.item set qtyAvailable=qtyAvailable- '"+qty1+"' where itemId = (select itemid from ".concat(cartname)+" where id = '"+id+"')";
			  
			  int rs1 = stmt.executeUpdate(sql2);
			  
			 
			 
			
			
		
			
			if(rs>0)
			{
				isSuccess = true;
				
			} else {
				isSuccess = false;
				
			}
			
			
			
		}
		
		catch(Exception e) 
		{
			e.printStackTrace();
			
		}
		
		return  isSuccess;
		
	}
   
   
   
   public static boolean deleteItemCart(String username,String id,int qty,String itemid)
 	{
 		boolean isSuccess = false;
 		
 		try {
 			
 			 con = DBManager.getConection();
 	         stmt = con.createStatement();
 	        String cartname = username + "cart" ;
 	         
 			String sql = "delete from ".concat(cartname) +" where id ='"+id+"'";
 			int rs = stmt.executeUpdate(sql);
 			
 			 String sql2 = "update udssuper.item set qtyAvailable = qtyAvailable+'"+qty+"' where itemId = '"+itemid+"'";
	 		int rs1 = stmt.executeUpdate(sql2);
 
 			
					/*
					 * String retrieve =
					 * "SELECT qtyAvailable from  udssuper.item where itemId = (select itemid from "
					 * .concat(cartname)+" where id = '"+id+"')"; ResultSet
					 * retrieveq=stmt.executeQuery(retrieve);
					 * 
					 * 
					 * 
					 * while(retrieveq.next()) { int q = retrieveq.getInt(9) + qty;
					 * 
					 * 
					 * }
					 */
 			
 			
 			
 			if(rs>0 )
 			{
 				isSuccess = true;
 				
 			} else {
 				isSuccess = false;
 				
 			}
 			
 		}
 		
 		catch(Exception e)
 		{
 			e.printStackTrace();
 			
 		}
 		
 		
 		
 		
 		
 		return  isSuccess;
 		
 	}
 	


}
