package Installment;

import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DBConnect.DBConnect;
import userPayment.yourPayDetails;


public class installmentDButil {

	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
		
	//inserting installment details to database
	public static boolean insertInstallmentDetail (String payId, double tAmount, double downPay,int typeMonth)
	{
		
		boolean isSuccess = false;
		
		installmentIdGenerator insId = new installmentIdGenerator();
		String installId = insId.installmentIdGenerator();
		String typeId = null;
		try{
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			String sql = "select typeId from installmenttype where '"+typeMonth+"'";
			rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				typeId = rs.getString("typeId");
				
				String sql1 = "insert into installment values (0,'"+installId+"','"+payId+"','"+tAmount+"','"+downPay+"','"+typeMonth+"','"+typeId+"')";
				int rs = stmt.executeUpdate(sql1);
				
				if(rs > 0) {
					isSuccess = true;
				}
				else {
					isSuccess = false;
				}
			}

		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return isSuccess;
	}
	
	//inserting installment type details to database
	public static boolean insertInstallType(String desc,int months)
	{
		
		boolean isSuccess = false;
		
		installmentTypeIdGenerator insTyId = new installmentTypeIdGenerator();
		String installTypeId = insTyId.installmentTypeIdGenerator();
		
		try{
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "insert into installmenttype values (0,'"+installTypeId+"','"+desc+"','"+months+"')";
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
	
	//retrieving installment details from database
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
	
	//retrieving installment type details from database
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
	
	//updating installment type details to database
	public static boolean updateInstallType(int id,String desc,int months)
	{
		
		boolean isSuccess = false;
		
		try{
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "update installmenttype set tDesc='"+desc+"',months='"+months+"'where id='"+id+"'";
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
	
	//updating remaining installments of customers to database
	public static boolean updateInstall(String id,int remainInstall)
	{
		
		boolean isSuccess = false;
		
		try{
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "update installment set remainInstalls='"+remainInstall+"'where installmentId='"+id+"'";
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
	
	//deleting installment details from database
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
	
	//deleting installment type details from database
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
	
	//updating installment details to database when customer pays monthly installment 
	public static boolean payMonthlyInstalllment(String uid)
	{
		
		
		try {
			
			con=DBConnect.getConnection();
			stmt=con.createStatement();
			int remainInstalls;
			String installmentId;
			
			String sql = "select i.installmentId,i.remainInstalls "
					+ "from userpayment u, ordert o, installment i "
					+ "where o.orderId = u.orderId AND u.payId = i.payId AND o.uid = '"+uid+"'";
			
			rs=stmt.executeQuery(sql);
			
			while(rs.next())
			{
				installmentId = rs.getString(1);
				remainInstalls = rs.getInt(2);
				int remainInstall = remainInstalls-1;
				
				String sql1 = "update installment set remainInstalls='"+remainInstall+"' where installmentId='"+installmentId+"'";
				int rs1 = stmt.executeUpdate(sql1);
					
				if(rs1 > 0) {
					isSuccess = true;
				}
				else {
					isSuccess = false;
				}
			}
	
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return isSuccess;
	}
	
	//retrieving deleted installment type details from database
	public static List<installmentType> backupgetInstallmentTypeDetails()
	{
		ArrayList<installmentType> installType = new ArrayList<>();
		
		try {
			
			con=DBConnect.getConnection();
			stmt=con.createStatement();
			String sql = "select * from installmenttype_log";
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
	
	//re-inserting installment type details by deleting installment type details from deleted installment types table 
	public static boolean reInsertInstallmentTypeDetails(String id)
	{
		
		boolean isSuccess = false;
		
		try{	
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "delete from installmenttype_log where id ='"+id+"'";
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
