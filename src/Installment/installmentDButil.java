package Installment;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DBConnect.DBConnect;


public class installmentDButil {

	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
		
	
	public static boolean insertInstallmentDetail (String payId, double tAmount, double downPay, int remainInstall, String typeId)
	{
		
		boolean isSuccess = false;
		
		try{
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "insert into customer_details values (0,'"+0+"','"+payId+"','"+tAmount+"','"+downPay+"','"+remainInstall+"','"+typeId+"')";
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
	
	public static boolean insertInstallType(String desc,int months)
	{
		
		boolean isSuccess = false;
		
		try{
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "insert into installmenttype values (0,'ITY005','"+desc+"','"+months+"')";
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
	
	public static List<installment> getInstallmentDetails()
	{
		ArrayList<installment> install = new ArrayList<>();
		
		try {
			
			con=DBConnect.getConnection();
			stmt=con.createStatement();
			String sql = "select * from installment";
			rs=stmt.executeQuery(sql);
			
			while(rs.next())
			{
				int id=rs.getInt(1);
				String installmentId = rs.getString(2);
				String payId = rs.getString(3);
				Double totAmount = rs.getDouble(4);
				Double downPay = rs.getDouble(5);
				int remainInstalls = rs.getInt(6);
				String typeId = rs.getString(7);
				
				installment install1 = new installment(id,installmentId,payId,totAmount,downPay,remainInstalls,typeId);
				install.add(install1);
			}
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return install;
	}
	
	public static List<installmentType> getInstallmentTypeDetails()
	{
		ArrayList<installmentType> installType = new ArrayList<>();
		
		try {
			
			con=DBConnect.getConnection();
			stmt=con.createStatement();
			String sql = "select * from installmenttype";
			rs=stmt.executeQuery(sql);
			
			while(rs.next())
			{
				int id=rs.getInt(1);
				String typeId = rs.getString(2);
				String tDesc = rs.getString(3);
				int months=rs.getInt(4);
				
				
				installmentType installType1 = new installmentType(id,typeId,tDesc,months);
				installType.add(installType1);
			}
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return installType;
	}
	
	public static boolean deleteInstallmentDetails(String id)
	{
		
		boolean isSuccess = false;
		
		try{	
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "delete from installment where installmentId ='"+id+"'";
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
	
	public static boolean deleteInstallmentTypeDetails(String id)
	{
		
		boolean isSuccess = false;
		
		try{	
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "delete from installmenttype where id ='"+id+"'";
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
