package package1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import package1.Supplier;

import package1.Supplier;

import package1.DBConnect;

public class SupplierDBUtil {


	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	private static ResultSet rs1 = null;
	
	
	public static boolean insertsupplier(String supplierid, String name, String status, String address, String email, String phone1, String phone2, String description) {
		boolean isSuccess = false;
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			String sql = "insert into supplier values (0,'"+supplierid+"', '"+name+"', '"+status+"', '"+address+"', '"+email+"', '"+description+"')";
			String sql2 = "insert into supplierphone values (0,'"+supplierid+"', '"+phone1+"', '"+phone2+"')";
			
			int rs = stmt.executeUpdate(sql);
			int rs1 = stmt.executeUpdate(sql2);
			
			if(rs > 0 && rs1 > 0) {
				isSuccess = true;
			}else {
				isSuccess = false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
	
//	public static List<Supplier> displaysupplier() {
//		
//		ArrayList<Supplier> supplier = new ArrayList<>();
//		
//		try {
//			
//			con = DBConnect.getConnection();
//			stmt = con.createStatement();
//			
//			String sql = "select * from supplier";
////			String sql2 = "select sp.supplierID,sp.phone1,sp.phone2 from supplierphone sp, supplier s where s.supplierID=sp.supplierID";
////			, supplierphone sp where s.supplierID = sp.supplierID
//			
//			rs = stmt.executeQuery(sql);
//			
//			while(rs.next()) {
//				
//				int id = rs.getInt(1);
//				String supplierID = rs.getString(2);
//				String name = rs.getString(3);
//				String status = rs.getString(4);
//				String address = rs.getString(5);
//				String email = rs.getString(6);
////				String phone1 = rs1.getString(3);
////				String phone2 = rs1.getString(4);
//				String description = rs.getString(7);
//				
//				
//				Supplier s = new Supplier(id, supplierID, name, status, address, email, description);
//				supplier.add(s);
//				
//			}
//			
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		return supplier;
//	}
	
	
	public static List<Supplier> displaysupplier1() {
		
		ArrayList<Supplier> supplier = new ArrayList<>();
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			String sql = "select s.supplierID, s.suppliername, s.status, s.address, s.email, sp.phone1, sp.phone2, s.description from supplier s, supplierphone sp where s.supplierID=sp.supplierID";
//			String sql2 = "select sp.supplierID,sp.phone1,sp.phone2 from supplierphone sp, supplier s where s.supplierID=sp.supplierID";
//			, supplierphone sp where s.supplierID = sp.supplierID
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
			
				String supplierID = rs.getString(1);
				String name = rs.getString(2);
				String status = rs.getString(3);
				String address = rs.getString(4);
				String email = rs.getString(5);
				String phone1 = rs.getString(6);
				String phone2 = rs.getString(7);
				String description = rs.getString(8);
				
				
				Supplier s = new Supplier(supplierID, name, status, address, email, phone1, phone2, description);
				supplier.add(s);
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return supplier;
	}
	
	
	public static boolean updateSupplier(String supplierID , String name , String status , String address , String email, String phone1, String phone2, String description) {
		
		boolean isSuccess = false;
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			String sql = "update supplier set suppliername='"+name+"' , status='"+status+"' ,address='"+address+"' ,email='"+email+"' ,description='"+description+"'"
						+"where supplierID='"+supplierID+"'";
			String sql2 = "update supplierphone set phone1='"+phone1+"', phone2='"+phone2+"'"
						+"where supplierID='"+supplierID+"'";
			
			int rs = stmt.executeUpdate(sql);
			int rs1 = stmt.executeUpdate(sql2);
			
			if(rs > 0 && rs1> 0 ) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
	
//	public static List<Supplier> displayUpdateSupplier(String supplierID) {
//		
////		int convertedID = Integer.parseInt(supplierID);
//	
//		ArrayList<Supplier> supplier = new ArrayList<>();
//		
//		try {
//			
//			con = DBConnect.getConnection();
//			stmt = con.createStatement();
//			
//			String sql = "select * from supplier where supplierID='"+supplierID+"'";
//			rs = stmt.executeQuery(sql);
//			
//			while(rs.next()) {
//				int id = rs.getInt(1);
//				String supplierid = rs.getString(2);
//				String name = rs.getString(3);
//				String status = rs.getString(4);
//				String address = rs.getString(5);
//				String email = rs.getString(6);
//				String description = rs.getString(7);
//				
//			
//			
//				Supplier s = new Supplier(id, supplierid, name, status, address, email, description);
//				supplier.add(s);
//			}
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		
//		return supplier;
//	}
	
	public static boolean deleteSupplier(String supplierID, String name, String status) {
		
		boolean isSuccess = false;
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			String sql = "DELETE FROM supplierphone WHERE supplierID='"+supplierID+"'";
			String sql1 = "DELETE FROM supplier WHERE supplierID='"+supplierID+"'";
			
			
			int rs = stmt.executeUpdate(sql);
			int rs1 = stmt.executeUpdate(sql1);
			
			if(rs > 0  && rs1 > 0) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
	
}
