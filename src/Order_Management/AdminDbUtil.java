package Order_Management;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdminDbUtil {
	
	//making the connections
	private static Connection con = null;
	private static Statement stat = null;
	private static ResultSet rs = null;
	
	/*public static List<Order> onprogressOrderDisplay()
	
	{
		ArrayList<Order> order = new ArrayList<>();
		
		try {
			
			con=DBManager.getConnection();
			stat=con.createStatement();
		   
			String sql = "select * from order";
			
			//execute the sql query
			rs = stat.executeQuery(sql);
			
			
			while(rs.next())
			{
				int id = rs.getInt(1);;
				String orderID = rs.getString(2);
				double total = rs.getDouble(3);
				String date = rs.getString(4);
				String uid = rs.getString(5);
				String offerid = rs.getString(6);
				
				Order odd = new Order(id,orderID, total, date, uid, offerid);
				order.add(odd);
				
			}
			
			
		
		
		
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		
			
		return order;
	}*/
	
	
	
    public static List<Order> onprogressOrderDisplay() {
       
        ArrayList<Order> order = new ArrayList<>();
       
        try {
           
            con = DBManager.getConection();
            stat = con.createStatement();
           
         //   String sql = "SELECT o.id,o.orderID,o.total,o.date,o.uid,o.offerid FROM udssuper.order o deliveredby d where ";
           
            String sql = "SELECT o.id,o.orderID,o.total,o.date,o.uid,o.offerid FROM udssuper.order o ,deliveredby d where (d.status = 'Received' OR d.status = 'Accepted' OR d.status = 'On progress') and o.orderID = d.orderID" ; 
//            String sql2 = "select sp.supplierID,sp.phone1,sp.phone2 from supplierphone sp, supplier s where s.supplierID=sp.supplierID";
//            , supplierphone sp where s.supplierID = sp.supplierID
           
            rs = stat.executeQuery(sql);
           
            while(rs.next()) {
               
                int id = rs.getInt(1);
                String orderID = rs.getString(2);
                double total = rs.getDouble(3);
                String date = rs.getString(4);
                String uid = rs.getString(5);
                String off_id = rs.getString(6);
//                String phone1 = rs1.getString(3);
//                String phone2 = rs1.getString(4);
              
           Order s = new Order(id,orderID, total, date, uid,off_id);
                order.add(s);
               
            }
           
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return order;
    }

	
    public static List<Order> DispatchedOrderDisplay() {
        
        ArrayList<Order> order = new ArrayList<>();
       
        try {
           
            con = DBManager.getConection();
            stat = con.createStatement();
           
            String sql = "SELECT o.id,o.orderID,o.total,o.date,o.uid,o.offerid FROM udssuper.order o ,deliveredby d where d.status = 'Dispatched' and o.orderID = d.orderID";
//            String sql2 = "select sp.supplierID,sp.phone1,sp.phone2 from supplierphone sp, supplier s where s.supplierID=sp.supplierID";
//            , supplierphone sp where s.supplierID = sp.supplierID
           
            rs = stat.executeQuery(sql);
           
            while(rs.next()) {
               
                int id = rs.getInt(1);
                String orderID = rs.getString(2);
                double total = rs.getDouble(3);
                String date = rs.getString(4);
                String uid = rs.getString(5);
                String off_id = rs.getString(6);
//                String phone1 = rs1.getString(3);
//                String phone2 = rs1.getString(4);
              
           Order s = new Order(id,orderID, total, date, uid,off_id);
                order.add(s);
               
            }
           
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return order;
    }
    
    
    public static boolean deleteOrder(String id)
	{
		boolean isSuccess = false;
		
		try {
			
			 con = DBManager.getConection();
	         stat = con.createStatement();
			String sql = "delete from udssuper.order where  orderID= '"+id+"'";
		

			int rs = stat.executeUpdate(sql);
			
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
	

    public static List<Order> orderReport(String startDate , String endDate) {
        
        ArrayList<Order> order = new ArrayList<>();
       
        try {
           
            con = DBManager.getConection();
            stat = con.createStatement();
           
            String sql = "SELECT * FROM udssuper.order where date between '"+startDate+"' AND '"+endDate+"'";
//            String sql2 = "select sp.supplierID,sp.phone1,sp.phone2 from supplierphone sp, supplier s where s.supplierID=sp.supplierID";
//            , supplierphone sp where s.supplierID = sp.supplierID
           
            rs = stat.executeQuery(sql);
           
            while(rs.next()) {
               
                int id = rs.getInt(1);
                String orderID = rs.getString(2);
                double total = rs.getDouble(3);
                String date = rs.getString(4);
                String uid = rs.getString(5);
                String off_id = rs.getString(6);
//                String phone1 = rs1.getString(3);
//                String phone2 = rs1.getString(4);
              
           Order s = new Order(id,orderID, total, date, uid,off_id);
                order.add(s);
               
            }
           
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return order;
    }





}
