package User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Admin.Order;

public class orderHistoryDbUtil {
	
	private static Connection con = null;
	private static Statement stat = null;
	private static ResultSet rs = null;
	
	public static List<Order> OrderHistoryDisplay(String uID) {
	       
        ArrayList<Order> order = new ArrayList<>();
       
        try {
           
            con = util.DBManager.getConnection();;
            stat = con.createStatement();
           
//            String sql = "SELECT * FROM neworder where uid = '"+uID+"' ";
            
            String sql = "SELECT n.id, n.orderID, n.total, n.date, n.uid, n.offerid FROM neworder n, customer c where  c.UserID = n.uid and c.uname = '"+ uID +"' ";
            
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
