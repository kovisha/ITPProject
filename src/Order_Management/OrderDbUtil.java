package Order_Management;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import Order_Management.DBManager;

public class OrderDbUtil {
	
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	private static ResultSet result = null;
	private static ResultSet res_new = null;

	
	
	
	 public static boolean insertOrder(String username ,Double total,String orderid ) {
			
			boolean isSuccess = false;
			
			/*
			 * OrderIdGenerator id = new OrderIdGenerator(); String orderid =
			 * id.OrderIDgenerator();
			 */
			
			
			
			
			try{
				con = DBManager.getConection();
				stmt = con.createStatement();
				
			/*	String uid = "select UserID from udssuper.customer where UName = '"+username+"' ";
				ResultSet rs1 = stmt.executeQuery(uid);*/
				
				/*insert values into order table*/
				String cartname = username + "cart" ;
				
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				Date date = new Date();
				
				String dte = format.format(date);
				
				
				String sql = "INSERT INTO udssuper.order VALUES (null,'"+orderid+"','"+total+"','"+dte+"',(select UserID from udssuper.customer where UName = '"+username+"' ),'OFF002')";
				int rs = stmt.executeUpdate(sql);
				
				/*insert values into orderitem table*/
				/*
				String count  = "SELECT COUNT(*) FROM ".concat(cartname);
				ResultSet res_count = stmt.executeQuery(count);
				
				
				  int size = 0;
				  
				  while(res_count.next()) {
				  
				  size = size+1;
				  */
				  
				  
				 
				
			/*	String iname = "SELECT Iname from ".concat(cartname);
				ResultSet res_iname = stmt.executeQuery(iname);
				
				String quantity = "SELECT Iqty from ".concat(cartname);
				ResultSet res_qty = stmt.executeQuery(quantity);*/
				
			/*
			 * String s = "SELECT * FROM ".concat(cartname); res_new = stmt.executeQuery(s);
			 */
			    
			    
			  //  int size ;
			    
			/*
			 * while(res_new.next()) {
			 */
			    	//size = size+1;
			    
			  //  for (int i = 0 ; i<(size) ;i++) {
				
				
				/*String iname = res_new.getString(2);
			    int quantity = res_new.getInt(5);
					
					String sql2 = "INSERT INTO udssuper.orderitemsample VALUES(null,'"+orderid+"','"+iname+"','"+quantity+"')";
					 int result = stmt.executeUpdate(sql2);
					 
					 if( result>0) {
							isSuccess = true;
							System.out.println("item order Table values inserted");
						}
						else {
						isSuccess = false;
					}
					
				}
				*/
			   // }
				
				  
				
			}
			
			catch(Exception e) {
				e.printStackTrace();
			}
			
			return isSuccess;
			
		}

}
