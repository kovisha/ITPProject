package userPayment;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DBConnect.DBConnect;

public class userPaymentDButil {
	
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	public static boolean insertPaymentDetail (String pType, double totAmount, String orderId)
	{
		
		boolean isSuccess = false;
		
		try{
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "insert into customer_details values (0,'"+0+"','"+0+"','"+pType+"','#','"+totAmount+"','"+orderId+"')";
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

	public static List<userPayment> getUserPaymentDetails()
	{
		ArrayList<userPayment> userPay = new ArrayList<>();
		
		try {
			
			con=DBConnect.getConnection();
			stmt=con.createStatement();
			String sql = "select * from userpayment";
			rs=stmt.executeQuery(sql);
			
			while(rs.next())
			{
				int id=rs.getInt(1);
				String payId = rs.getString(2);
				String receiptNo = rs.getString(3);
				String paytype = rs.getString(4);
				Date paydate = rs.getDate(5);
				Double totAmount = rs.getDouble(6);
				String orderId = rs.getString(7);
				
				userPayment uPay1 = new userPayment(id,payId,receiptNo,paytype,paydate,totAmount,orderId);
				userPay.add(uPay1);
			}
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return userPay;
	}
	
	public static boolean deleteUserPayment(String id)
	{
		
		boolean isSuccess = false;
		
		try{	
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "delete from userpayment where id ='"+id+"'";
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
