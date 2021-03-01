package userPayment;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import DBConnect.DBConnect;
import Offer.offerIdGenerator;

public class userPaymentDButil {
	
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	//inserting user payment details to database
	public static boolean insertPaymentDetail (String pid, String payType, double totAmount, String orderId, LocalDate d)
	{
		
		boolean isSuccess = false;
		
		receiptNoGenerator rNo = new receiptNoGenerator();
		String recNo = rNo.receiptNoGenerator();
		
		try{
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "insert into userpayment values (0,'"+pid+"','"+recNo+"','"+payType+"','"+d+"','"+totAmount+"','"+orderId+"')";
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
	
	//retrieving user payment details from database
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
	
	//deleting user payment details from database
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
	
	//retrieving user payment details of a specific user from database
	public static List<yourPayDetails> getYourPaymentDetails(String uname)
	{
		ArrayList<yourPayDetails> yourPay = new ArrayList<>();
		
		try {
			
			con=DBConnect.getConnection();
			stmt=con.createStatement();
			
			String sql = "select u.paydate,u.totAmount,i.totAmount,downPay,remainInstalls,months "
					+ "from userpayment u, ordert o, installment i, installmenttype t customer c"
					+ "where o.orderId = u.orderId AND u.payId = i.payId AND i.typeId = t.typeId AND o.uid = c.uid AND c.UName = '"+uname+"' ";
			
			
			rs=stmt.executeQuery(sql);
			
			while(rs.next())
			{
				Date date=rs.getDate(1);
				Double paidTotAmount = rs.getDouble(2);
				Double installTotAmount = rs.getDouble(3);
				Double downPay = rs.getDouble(4);
				int remainInstalls = rs.getInt(5);
				int months = rs.getInt(6);
				
				double monthlyInstall = (double)(installTotAmount-downPay)/months;
				double dueInstall = (double)monthlyInstall*remainInstalls;
				
				String mInstall = String.format("%1.2f", monthlyInstall);
				monthlyInstall = Double.valueOf(mInstall);
				String dInstall = String.format("%1.2f", dueInstall);
				dueInstall = Double.valueOf(dInstall);
			
				
				yourPayDetails yrPay1 = new yourPayDetails(date,paidTotAmount,dueInstall,monthlyInstall);
				yourPay.add(yrPay1);
			}
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return yourPay;
	}
	

}
